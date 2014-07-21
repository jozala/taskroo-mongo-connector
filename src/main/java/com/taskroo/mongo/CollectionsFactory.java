package com.taskroo.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectionsFactory {

    private DB mongoDb;

    @Autowired
    public CollectionsFactory(DB mongoDb) {
        this.mongoDb = mongoDb;
    }

    public DBCollection getCollection(String collectionName) {
        return mongoDb.getCollection(collectionName);
    }
}
