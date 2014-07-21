package com.taskroo.mongo

import com.mongodb.DB
import spock.lang.Specification

class CollectionsFactoryTest extends Specification {

    CollectionsFactory collectionsFactory

    // mocks
    DB mongoDb = Mock(DB)

    void setup() {
        collectionsFactory = new CollectionsFactory(mongoDb)

    }

    def "should retrieve collection from TaskRoo database"() {
        when:
        collectionsFactory.getCollection('someCollection')
        then:
        1 * mongoDb.getCollection('someCollection')
    }
}
