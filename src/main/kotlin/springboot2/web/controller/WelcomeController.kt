package springboot2.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class WelcomeController {



    @GetMapping()
    fun welcome():String = "hello welcome"
}