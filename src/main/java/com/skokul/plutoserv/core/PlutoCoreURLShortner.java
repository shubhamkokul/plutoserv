package com.skokul.plutoserv.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/pluto")
public class PlutoCoreURLShortner {

    @GetMapping()
    public Mono<ServerResponse> getPluto(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("Welcome to Pluto Url Shortner"), String.class);
    }
}
