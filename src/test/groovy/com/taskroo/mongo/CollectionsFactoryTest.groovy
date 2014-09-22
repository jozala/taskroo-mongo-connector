package com.taskroo.mongo

import com.mongodb.DB
import org.jongo.Jongo
import spock.lang.Specification

class CollectionsFactoryTest extends Specification {

    CollectionsFactory collectionsFactory

    // mocks
    DB mongoDb = Mock(DB)
    Jongo jongo = Mock(Jongo)

    void setup() {
        collectionsFactory = new CollectionsFactory(mongoDb, jongo)
    }

    def "should retrieve collection from TaskRoo database"() {
        when:
        collectionsFactory.getCollection('someCollection')
        then:
        1 * mongoDb.getCollection('someCollection')
    }

    def "should retrieve jongo/mongo collection from TaskRoo database"() {
        when:
        collectionsFactory.getMongoCollection('givenCollection')
        then:
        1 * jongo.getCollection('givenCollection')
    }
}
