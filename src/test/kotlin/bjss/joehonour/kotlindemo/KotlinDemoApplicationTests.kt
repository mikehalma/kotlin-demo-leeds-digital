package bjss.joehonour.kotlindemo

import bjss.joehonour.kotlindemo.controllers.ApiEvent
import bjss.joehonour.kotlindemo.controllers.EventController
import bjss.joehonour.kotlindemo.entities.Event
import bjss.joehonour.kotlindemo.repository.EventRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinDemoApplicationTests {

	@MockBean
	lateinit var repository: EventRepository

	@Autowired
	lateinit var unitUnderTest: EventController

	@Test
	fun should_returnAllEventsOnGetAll() {
		// Act
		val events = listOf(Event(eventId = 1), Event(eventId = 2))
		Mockito.`when`(repository.findAll()).thenReturn(events)

		// Arrange
		val result = unitUnderTest.getAllEvents()

		// Assert
		assertThat(result, contains(ApiEvent(id = 1), ApiEvent(id = 2)))
	}
}
