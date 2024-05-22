package com.spring.app.security.filters;

import com.spring.app.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

  public String generateToken(Authentication authentication){
    Date currentDate = new Date();
    Date expireDate = new Date(currentDate.getTime() + SecurityConstants.EXPIRATION_TIME);

    String token = Jwts.builder()
      .setSubject(authentication.getName())
      .setIssuedAt(currentDate)
      .setExpiration(expireDate)
      .signWith(SecurityConstants.SECRET_KEY, SignatureAlgorithm.HS512)
      .compact();

    return token;
  }

  public String getUsernameFromJWT(String token){
    Claims claims = Jwts
      .parserBuilder()
      .setSigningKey(SecurityConstants.SECRET_KEY)
      .build()
      .parseClaimsJws(token)
      .getBody();
    return claims.getSubject();
  }

  public boolean validateToken(String token){
    try {
      Jwts
        .parserBuilder()
        .setSigningKey(SecurityConstants.SECRET_KEY)
        .build()
        .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
    }
  }

}
