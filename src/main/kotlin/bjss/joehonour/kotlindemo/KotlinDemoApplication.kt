package bjss.joehonour.kotlindemo

import com.google.common.base.Predicates
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
class Application

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

	@Bean
	fun swaggerConfig() = Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(Predicates.not(PathSelectors.regex("/error")))
			.build()
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
