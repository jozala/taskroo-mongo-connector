var db = connect("localhost:27017/taskroo");

// TTL for security tokens to expire after given time
db.securityTokens.dropIndex({ "last_accessed_time": 1 });
db.securityTokens.ensureIndex({"last_accessed_time": 1}, {expireAfterSeconds: 3600});

// TTL for rememberMeToken to expire after given time
db.rememberMeTokens.dropIndex({ "create_time": 1 });
db.rememberMeTokens.ensureIndex({"create_time": 1}, {expireAfterSeconds: 1209600});

// Uniqueness of the owner_id,name in the tags
db.tags.dropIndex  ({"owner_id": 1, "name": 1});
db.tags.ensureIndex({"owner_id": 1, "name": 1}, {unique: 1});

// Uniqueness of users.email
db.users.dropIndex  ({"email": 1});
db.users.ensureIndex({"email": 1}, {unique: 1});
