package com.servicediabetes.ApiDiabetesDomain.Usuario.Security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

public class TokenJwtConfig {    
    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("4Ff9bJ9mRY7zP5nEwK4G7kL8hJ6rK3bNT1".getBytes(StandardCharsets.UTF_8));
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
}
