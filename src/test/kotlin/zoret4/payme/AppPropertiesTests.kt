package zoret4.payme

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration(classes = [(PaymeApplication::class)], initializers = [(ConfigFileApplicationContextInitializer::class)])
class AppPropertiesTests {

    @Autowired
    lateinit var appProperties: AppProperties

    @Test
    fun `should load the properties from application_dot_yml file`() {
        println(appProperties.test)
    }

}