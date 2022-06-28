package com.quickbite.backend.security;

import com.quickbite.backend.common.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

  private static final SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  private static final Long EXPIRATION_DATE = 10000000L;

  public String buildToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
        .signWith(KEY)
        .compact();
  }

  public String getEmailFromToken(String token) {
    return getBody(token)
        .getSubject();
  }

  public Boolean isExpired(String token) {
    return getBody(token)
        .getExpiration()
        .before(new Date());
  }

  public Claims getBody(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(KEY)
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public void invalidateToken(String token) {
    getBody(token)
        .setExpiration(new Date());
  }
}
