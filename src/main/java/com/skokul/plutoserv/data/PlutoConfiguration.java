package com.skokul.plutoserv.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PlutoConfiguration {

    @Autowired
    private Environment env;

    private static final String JWT_SECRET_KEY = "jwt.secret";

    public String getJwtSecretKey() {
        return env.getProperty(JWT_SECRET_KEY);
    }

}
