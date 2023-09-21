package com.mega.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class Jwt {

  private final static String secretKey = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv";

  public static String create(String email, String name, int time) {
    String issuer = "mega-app";
    long nowMillis = System.currentTimeMillis();
    Date issuedAt = new Date(nowMillis);
    Date expiration = new Date(nowMillis + time);

    // JWT 토큰 생성
    Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
    String jwtToken = Jwts.builder()
        .setHeaderParam("type", "JWT")
        .setIssuer(issuer)
        .setIssuedAt(issuedAt)
        .setExpiration(expiration)
        .claim("userEmail", email)
        .claim("userName", name)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();

    return jwtToken;
  }

  public static boolean validateIssuer(String token) throws Exception {
    Jws<Claims> claimsJws = Jwts.parserBuilder()
        .setSigningKey(secretKey.getBytes())
        .build()
        .parseClaimsJws(token);

    Claims body = claimsJws.getBody();

    return body.get("iss", String.class).equals("mega-app");
  }

  public static String validateEmail(String token) throws Exception {
    Jws<Claims> claimsJws = Jwts.parserBuilder()
        .setSigningKey(secretKey.getBytes())
        .build()
        .parseClaimsJws(token);

    Claims body = claimsJws.getBody();

    return body.get("userEmail", String.class);
  }

  public static String validateName(String token) throws Exception {
    Jws<Claims> claimsJws = Jwts.parserBuilder()
        .setSigningKey(secretKey.getBytes())
        .build()
        .parseClaimsJws(token);

    Claims body = claimsJws.getBody();

    return body.get("userName", String.class);
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

  public static boolean validateToken(String token) {
    return !Jwts.parserBuilder()
        .setSigningKey(secretKey.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getExpiration()
        .before(new Date());
  }
}

