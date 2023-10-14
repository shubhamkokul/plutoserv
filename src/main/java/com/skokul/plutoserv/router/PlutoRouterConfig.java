package com.skokul.plutoserv.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.skokul.plutoserv.auth.PlutoAuthenticator;
import com.skokul.plutoserv.core.PlutoCoreURLShortner;

@Configuration
public class PlutoRouterConfig {
    // Route Request to Core - Shortner and Retriever
    // Route Request to auth - Login and Register using JWT

    /**
     * @param handler
     * @return
     */
    @Bean
    RouterFunction<ServerResponse> routes(PlutoCoreURLShortner urlShortner, PlutoAuthenticator authenticator) {
        return RouterFunctions
        .route(RequestPredicates.GET("/v1/pluto").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),urlShortner::getPluto)
        .andRoute(RequestPredicates.POST("/v1/pluto/auth/create").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),authenticator::createAccessToken);
    }

}
