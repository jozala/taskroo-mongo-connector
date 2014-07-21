var db = connect("localhost:27017/taskroo");

// TTL for session to expire after given time
db.sessions.dropIndex({ "last_accessed_time": 1 });
db.sessions.ensureIndex({"last_accessed_time": 1}, {expireAfterSeconds: 3600});

// Uniqueness of the owner_id,name in the tags
db.tags.dropIndex  ({"owner_id": 1, "name": 1});
db.tags.ensureIndex({"owner_id": 1, "name": 1}, {unique: 1});
