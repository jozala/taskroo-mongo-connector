var db = connect("localhost:27017/gtweb");

db.sessions.ensureIndex({"last_accessed_time": 1}, {expireAfterSeconds: 1800});