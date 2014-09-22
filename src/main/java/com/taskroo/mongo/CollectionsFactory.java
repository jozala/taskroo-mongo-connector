package com.taskroo.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectionsFactory {

    private final DB mongoDb;
    private final Jongo jongoDb;

    @Autowired
    public CollectionsFactory(DB mongoDb, Jongo jongoDb) {
        this.mongoDb = mongoDb;
        this.jongoDb = jongoDb;
    }

    public DBCollection getCollection(String collectionName) {
        return mongoDb.getCollection(collectionName);
    }

    public MongoCollection getMongoCollection(String collectionName) {
        return jongoDb.getCollection(collectionName);
    }
}
