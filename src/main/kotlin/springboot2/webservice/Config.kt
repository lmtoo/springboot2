package springboot2.webservice

import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint


@Configuration
class Config {

    @Autowired
    private lateinit var bus: Bus


    @Bean
    fun endpoint(helloPortImpl: HelloPortImpl): Endpoint {
        val endpoint = EndpointImpl(bus, helloPortImpl)
        endpoint.publish("/Hello")
        return endpoint
    }
}