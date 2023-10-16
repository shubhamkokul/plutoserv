package com.skokul.plutoserv.core;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PlutoCoreURLShortner {

    @GetMapping(value = "/v1/pluto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPluto() {
        return ResponseEntity.ok().body("Welcome to Pluto Url Shortner");

    }
}
