package bjss.joehonour.kotlindemo.controllers

import bjss.joehonour.kotlindemo.entities.Event
import bjss.joehonour.kotlindemo.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

// 4. data classes get rid of needing to write get/sets. They are immutable and provide helper methods for copying/mutating in an immutable way. e.g. copy
// 5. default parameters mean we dont need to specify everything if we don't want to
// 6. nullable types ?. if you dont specify a type as nullable, it cant be assigned null. This forces the called to either continue optionally ? or enforce not null !!
data class ApiEvent(
        val id: Long,
        val name: String? = null,
        val location: String? = null,
        val startTime: LocalDateTime? = null,
        val endTime: LocalDateTime? = null)

@RestController
@RequestMapping(value = ["/events"])
class EventController {

    // 1. example of lateinit (trust me, i will initialise this immediately after object instantiation)
    @Autowired
    lateinit var eventRepository: EventRepository

    // 2. if a method is a single line, just use the = operator to return the type (no need for brackets)
    // 3. if the last parameter passed to a method is a function that accepts a single parameter, it acts like a clojure with it being the parameter passed.
    @RequestMapping(method = [RequestMethod.GET])
    fun getAllEvents(): List<ApiEvent> = eventRepository.findAll().map { it.toApiEvent() }

    // 7. extension methods on event allow helpful methods to be added to a type that should only contain data (making it look useful to its current context).
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = [RequestMethod.POST])
    fun createEvent(@RequestBody event: ApiEvent): ApiEvent {

        executeIfEventExists(event.id) {
            throw IllegalArgumentException("event with id ${event.id} already exists")
        }

        val domainEvent = event.toDomainEvent()
        val result = eventRepository.save(domainEvent)
        return result.toApiEvent()
    }

    // 8. we can interop easily with java classes/annotations etc etc, none of spring is written in Kotlin but we work fine with it
    @RequestMapping("/{id}", method = [RequestMethod.GET])
    fun getEvent(@PathVariable id: Long): ApiEvent {
        executeIfEventExists(id) {
            return it.toApiEvent()
        }

        throw IllegalArgumentException("event with id $id does not exist")
    }

    // 9. named parameters allow us to explicitly call what we want to set in a method
    // 10. this is a use of the immutable data class, use copy to make a copy changing any of the variables specified, but get a new object back
    @RequestMapping("/{id}", method = [RequestMethod.PUT])
    fun updateEvent(@PathVariable id: Long, @RequestBody event: ApiEvent): ApiEvent {
        executeIfEventExists(id) {
            val updatedEvent = it.copy(eventId = event.id, name = event.name, location = event.location, startTime = event.startTime, endTime = event.endTime)
            return eventRepository.save(updatedEvent).toApiEvent()
        }

        throw IllegalArgumentException("event with id ${event.id} already exists")
    }

    // 11. here is some serious complex shit. We inline a mmethod that accepts a function, which means it executes in the calling scope. This means you can return from the function, and it returns from the calling method
    // 12. pattern matching with when (this can be extended to types and any boolean conditions you can think of (ranges, null, less, greater etc etc) will add example on slide maybe
    // 13. as last parameter is a function, you can just write a clojure like statement when calling.
    private inline fun executeIfEventExists(id: Long, exists: (Event) -> Unit) {
        val existingEvent = eventRepository.findByEventId(id)

        when(existingEvent) {
            null -> return
            else -> exists(existingEvent)
        }
    }
}

// 14. example of an extension method that is a high order function (does not mutate state) and does not need to belong to a class
fun ApiEvent.toDomainEvent(): Event = Event(
        eventId = this.id,
        name = this.name,
        location = this.location,
        startTime = this.startTime,
        endTime = this.endTime)

// 15. quick example of showing the null safety forcing not null, this is not normally recommended, just for demo
fun Event.toApiEvent(): ApiEvent = ApiEvent(this.eventId!!, this.name, this.location, this.startTime, this.endTime)

// TODO:
// still need to show some of the more advanced pattern matching
// object singletons (companion objects)