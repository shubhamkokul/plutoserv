package com.skokul.plutoserv.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.skokul.plutoserv.auth.service.TokenManagement;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/pluto/auth")
public class PlutoAuthenticator {

    @Autowired
    TokenManagement tokenManagement;

    @PostMapping("/create")
    public Mono<ServerResponse> createAccessToken(ServerRequest request) {
        System.out.println(request.toString());
        // return
        // ServerResponse.ok().body(Mono.just(tokenManagement.createJWTToken(null,
        // null)), String.class);
        return ServerResponse.ok().body(Mono.just("shubham"), String.class);
    }
}
