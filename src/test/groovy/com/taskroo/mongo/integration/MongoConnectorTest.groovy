package com.taskroo.mongo.integration

import com.taskroo.mongo.MongoConnector
import com.taskroo.mongo.DBConnectionException

class MongoConnectorTest extends GroovyTestCase {

    // SUT
    private MongoConnector mongoConnector

    void testShouldThrowDbExceptionWhenUnableToConnectToDb() {
        mongoConnector = new MongoConnector('incorrectHostname', '27017')

        assert shouldFail(DBConnectionException.class, {
            mongoConnector.getTaskRooDatabase();
        })

    }

    void testShouldReturnDbWhenCorrectHostnameGiven() {
        mongoConnector = new MongoConnector('localhost', '27017')
        assert mongoConnector.getTaskRooDatabase() != null
    }

    void testShouldReturnJongo() {
        mongoConnector = new MongoConnector('localhost', '27017')
        assert mongoConnector.getJongoTaskRooDatabase() != null
    }
}
