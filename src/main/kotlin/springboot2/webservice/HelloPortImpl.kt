package springboot2.webservice

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import springboot2.web.controller.WelcomeController
import javax.jws.WebParam
import javax.jws.WebMethod
import javax.xml.ws.RequestWrapper
import javax.jws.WebResult
import javax.jws.WebService
import javax.xml.ws.ResponseWrapper


@WebService
interface Hello {

    @WebResult(name = "return", targetNamespace = "")
    @WebMethod(action = "urn:SayHello")
    fun sayHello(@WebParam(name = "myname", targetNamespace = "") myname: String): String
}


@Component
class HelloPortImpl : Hello {


    @Autowired
    lateinit var welcomeController: WelcomeController

    override fun sayHello(myname: String): String {

        println(welcomeController)
        LOG.info("Executing operation sayHello$myname")
        try {
            return "Hello, Welcome to CXF Spring boot $myname!!!"

        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            throw RuntimeException(ex)
        }

    }

    companion object {

        private val LOG = LoggerFactory.getLogger(HelloPortImpl::class.java.name)
    }

}