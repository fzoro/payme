package zoret4.payme.web.routes

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.ServerResponse
import zoret4.payme.web.handlers.CreatePaymentHandler
import zoret4.payme.web.handlers.ExecutePaymentHandler
import zoret4.payme.web.util.TestsHelper.Companion.any

@RunWith(SpringRunner::class)
@WebFluxTest
@Import(ApiRoutes::class)
class ApiRoutesTests {


    @Autowired
    lateinit var webClient: WebTestClient

    @MockBean
    lateinit var createHandler: CreatePaymentHandler
    @MockBean
    lateinit var executeHandler: ExecutePaymentHandler

    @Test
    fun `should check api routes`() {

        MockitoAnnotations.initMocks(this)
        given(executeHandler.execute(any())).willReturn(ServerResponse.ok().build())

        webClient.post().uri("/execute-payment").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .returnResult().apply { Assert.assertEquals(null, responseBody) }

        given(createHandler.create(any())).willReturn(ServerResponse.ok().build())

        webClient.post().uri("/create-payment").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .returnResult().apply { Assert.assertEquals(null, responseBody) }
    }
}