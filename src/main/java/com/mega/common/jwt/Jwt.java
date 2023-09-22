package com.mega.common.jwt;

import com.mega.biz.login.exception.TokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class Jwt {

  private final static String secretKey = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv";
  private static final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

  public static String create(String email, String name, int time) {
    String issuer = "mega-app";
    long nowMillis = System.currentTimeMillis();
    Date issuedAt = new Date(nowMillis);
    Date expiration = new Date(nowMillis + time);

    return Jwts.builder().setHeaderParam("type", "JWT").setIssuer(issuer).setIssuedAt(issuedAt)
        .setExpiration(expiration).setId(email).setAudience(name).signWith(key)
        .compact();
  }

  public static boolean validateIssuer(String token) throws TokenException {
    try {
      return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody()
          .getIssuer().equals("mega-app");
    } catch (Exception e) {
      throw new TokenException();
    }
  }

  public static String getTokenInnerEmail(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody()
        .getId();
  }

  public static String getTokenInnerName(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody()
        .getAudience();
  }

  public static Long validateExp(String token) throws Exception {
    Claims claimsJws = Jwts.parserBuilder()
        .setSigningKey(secretKey.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody();

    Long expirationTime = claimsJws.getExpiration().getTime();
    Long currentTime = System.currentTimeMillis();

    return (expirationTime - currentTime);
  }
}

