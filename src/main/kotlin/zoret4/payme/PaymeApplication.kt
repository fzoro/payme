package zoret4.payme

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AppProperties::class)
class PaymeApplication

fun main(args: Array<String>) {
    runApplication<PaymeApplication>(*args)
}
