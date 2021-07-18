package com.demo.versioning

import org.apache.catalina.core.ApplicationContext
import org.apache.coyote.Response
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


@RestController
class VersionController {

    @Autowired
    lateinit var context: BuildProperties

    @GetMapping("/version")
    fun getVersion(): ResponseEntity<Message> {

        return ResponseEntity(Message(context.name,context.version), HttpStatus.OK)

    }


}

data class Message(val name: String,val version: String)