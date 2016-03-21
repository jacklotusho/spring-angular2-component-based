package com.github.joerodriguez.sbng2ex.invitation

import com.github.joerodriguez.sbng2ex.User
import com.github.joerodriguez.sbng2ex.web.ServiceResponseWebResponder.respond
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class InvitationController {

    @Autowired
    private lateinit var invitationService: InvitationService

    @RequestMapping(
            value = "/api/user-invitations",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf("application/json"),
            produces = arrayOf("application/json")
    )
    fun createInvitation(
            @RequestBody invitationRequest: InvitationRequest
    ): ResponseEntity<User> {

        return respond(invitationService.invite(invitationRequest), HttpStatus.CREATED, HttpStatus.UNPROCESSABLE_ENTITY)
    }

}