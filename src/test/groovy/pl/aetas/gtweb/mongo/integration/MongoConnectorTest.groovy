package pl.aetas.gtweb.mongo.integration

import pl.aetas.gtweb.mongo.MongoConnector
import pl.aetas.gtweb.mongo.DBConnectionException

class MongoConnectorTest extends GroovyTestCase {

    // SUT
    private MongoConnector mongoConnector

    void testShouldThrowDbExceptionWhenUnableToConnectToDb() {
        mongoConnector = new MongoConnector('mongodb://incorrectHostname')

        assert shouldFail(DBConnectionException.class, {
            mongoConnector.getGtWebDatabase();
        })

    }

    void testShouldReturnDbWhenCorrectHostnameGiven() {
        mongoConnector = new MongoConnector('mongodb://localhost')
        assert mongoConnector.getGtWebDatabase() != null
    }
}
