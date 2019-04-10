package bjss.joehonour.kotlindemo.repository

import bjss.joehonour.kotlindemo.entities.Event
import org.springframework.data.mongodb.repository.MongoRepository

interface EventRepository : MongoRepository<Event, String>
{
    fun findByEventId(eventId: Long): Event?
}