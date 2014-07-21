package com.taskroo.mongo.integration

import com.taskroo.mongo.MongoConnector
import com.taskroo.mongo.DBConnectionException

class MongoConnectorTest extends GroovyTestCase {

    // SUT
    private MongoConnector mongoConnector

    void testShouldThrowDbExceptionWhenUnableToConnectToDb() {
        mongoConnector = new MongoConnector('mongodb://incorrectHostname')

        assert shouldFail(DBConnectionException.class, {
            mongoConnector.getTaskRooDatabase();
        })

    }

    void testShouldReturnDbWhenCorrectHostnameGiven() {
        mongoConnector = new MongoConnector('mongodb://localhost')
        assert mongoConnector.getTaskRooDatabase() != null
    }
}
