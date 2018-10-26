package zoret4.payme.web.routes

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router
import zoret4.payme.web.handlers.PaymeHandler


@Configuration
class ApiRoutes(val paymeHandler: PaymeHandler) {

    @Bean
    fun routes() = router {
        (accept(MediaType.APPLICATION_JSON) and "/payme").nest {
            "/".nest {
                GET("/", paymeHandler::get)
            }
        }

    }
}