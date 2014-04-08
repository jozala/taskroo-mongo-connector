package pl.aetas.gtweb.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class MongoConnector {

    private final String mongoUri;

    @Autowired
    public MongoConnector(String mongoDbUri) {
        this.mongoUri = mongoDbUri;
    }

    private Logger LOGGER = LogManager.getLogger();

    public DB getDatabase(String dbName) {

        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));
            return mongoClient.getDB(dbName);
        } catch (UnknownHostException e) {
            LOGGER.fatal("Cannot connect to MongoDB on {}. App is not able to work.", mongoUri);
            throw new DBConnectionException("Cannot connect to MongoDB", e);
        }
    }

    public DB getGtWebDatabase() {
        return getDatabase("gtweb");
    }
}
