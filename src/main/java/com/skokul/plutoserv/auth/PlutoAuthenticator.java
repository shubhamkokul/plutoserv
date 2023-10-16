package com.skokul.plutoserv.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skokul.plutoserv.auth.model.AccessTokenArgument;
import com.skokul.plutoserv.auth.model.AccessTokenResult;
import com.skokul.plutoserv.auth.model.AccessTokenProcess;
import com.skokul.plutoserv.auth.service.TokenManagement;
import com.skokul.plutoserv.communication.PlutoResponse;
import com.skokul.plutoserv.data.PlutoConfiguration;

@RestController
public class PlutoAuthenticator {

    @Autowired
    private TokenManagement tokenManagement;

    @Autowired
    private PlutoConfiguration plutoConfiguration;

    @PostMapping(path = "/v1/pluto/auth/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlutoResponse<AccessTokenResult>> createAccessToken(@RequestBody AccessTokenArgument body) {
        // Check for emailId in the data-source if exists return emailId already exists
        // Or Create UUID associated with Email and Store in data-source and return the
        // access-token, userId and email.
        try {
            // Validate EMAIL before creating Token
            if (body != null && !body.getEmail().isEmpty()) {
                String email = body.getEmail();
                return ResponseEntity.ok()
                        .body(new PlutoResponse.Builder<AccessTokenResult>()
                                .data(tokenManagement.createJWTToken(
                                        new AccessTokenProcess(email,
                                                UUID.nameUUIDFromBytes(email.getBytes())),
                                        plutoConfiguration.getJwtSecretKey()))
                                .build());
            } else {
                return ResponseEntity.badRequest()
                        .body(new PlutoResponse.Builder<AccessTokenResult>()
                                .httpResponseExceptionMessage("Missing Email").build());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new PlutoResponse.Builder<AccessTokenResult>()
                    .build());
        }
    }

}
