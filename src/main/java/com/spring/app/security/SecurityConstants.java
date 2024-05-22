package com.spring.app.security;

import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


public class SecurityConstants {

  private static final String SECRET = "q5h8QeZ+Tde6i5/wZ7N5T7+xE8N9KdCJ8PjFcJZsV5ItGy9E/1D7uU4kbyG+oZ5hZ1YrIX0dK5aKO1QsGr/Miw==\n";
  public static final Key SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
  public static final long EXPIRATION_TIME = 1000*60*60*24;
  public static final String PREFIX_TOKEN= "Bearer ";
  public static final String AUTHORIZATION_HEADER = "Authorization";

}
