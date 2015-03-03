package com.taskroo.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class MongoConnector {

    private final String mongoDbHost;
    private final int mongoDbPort;

    @Autowired
    public MongoConnector(String mongoDbHost, String mongoDbPort) {
        this.mongoDbHost = mongoDbHost;
        this.mongoDbPort = Integer.parseInt(mongoDbPort);
    }

    private Logger LOGGER = LogManager.getLogger();

    public DB getDatabase(String dbName) {

        try {
            MongoClient mongoClient = new MongoClient(mongoDbHost, mongoDbPort);
            return mongoClient.getDB(dbName);
        } catch (UnknownHostException e) {
            LOGGER.fatal("Cannot connect to MongoDB on {}:{}. App is not able to work.", mongoDbHost, mongoDbPort);
            throw new DBConnectionException("Cannot connect to MongoDB", e);
        }
    }

    public DB getTaskRooDatabase() {
        return getDatabase("taskroo");
    }

    public Jongo getJongoTaskRooDatabase() {
        return new Jongo(getTaskRooDatabase());
    }
}
