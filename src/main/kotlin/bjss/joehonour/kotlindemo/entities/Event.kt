package bjss.joehonour.kotlindemo.entities

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Event(
        @Id
        val _id: ObjectId? = null,
        val eventId: Long? = null,
        val name: String? = null,
        val location: String? = null,
        val startTime: LocalDateTime? = null,
        val endTime: LocalDateTime? = null)