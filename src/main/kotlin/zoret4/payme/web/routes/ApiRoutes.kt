package zoret4.payme.web.routes

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router
import zoret4.payme.web.handlers.CreatePaymentHandler
import zoret4.payme.web.handlers.ExecutePaymentHandler


@Configuration
class ApiRoutes(val createPaymeHandler: CreatePaymentHandler, val executePaymeHandler: ExecutePaymentHandler) {

    @Bean
    fun routes() = router {
        (accept(MediaType.APPLICATION_JSON) and "/").nest {
            POST("/execute-payment", createPaymeHandler::create)
            POST("/create-payment", executePaymeHandler::execute)
        }
    }
}
