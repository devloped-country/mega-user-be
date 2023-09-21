package com.mega.common.jwt;

import com.mega.biz.login.exception.AuthException;
import com.mega.biz.login.exception.TokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    // JWT 토큰 생성

    return Jwts.builder().setHeaderParam("type", "JWT").setIssuer(issuer).setIssuedAt(issuedAt)
        .setExpiration(expiration).claim("email", email).claim("name", name).signWith(key)
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

//  public static boolean validateEmail(String token) {
//    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("email", String.class);
//  }

//  public static boolean validateIssuer(String token) throws Exception {
//    Jws<Claims> claimsJws = Jwts.parserBuilder()
//        .setSigningKey(secretKey.getBytes())
//        .build()
//        .parseClaimsJws(token);
//
//    Claims body = claimsJws.getBody();
//
//    return body.get("iss", String.class).equals("mega-app");
//  }
//
//  public static String validateEmail(String token) throws Exception {
//    Jws<Claims> claimsJws = Jwts.parserBuilder()
//        .setSigningKey(secretKey.getBytes())
//        .build()
//        .parseClaimsJws(token);
//
//    Claims body = claimsJws.getBody();
//
//    return body.get("userEmail", String.class);
//  }
//
//  public static String validateName(String token) throws Exception {
//    Jws<Claims> claimsJws = Jwts.parserBuilder()
//        .setSigningKey(secretKey.getBytes())
//        .build()
//        .parseClaimsJws(token);
//
//    Claims body = claimsJws.getBody();
//
//    return body.get("userName", String.class);
//  }
//
//  public static Long validateExp(String token) throws Exception {
//    Claims claimsJws = Jwts.parserBuilder()
//        .setSigningKey(secretKey.getBytes())
//        .build()
//        .parseClaimsJws(token)
//        .getBody();
//
//    Long expirationTime = claimsJws.getExpiration().getTime();
//    Long currentTime = System.currentTimeMillis();
//
//    return (expirationTime - currentTime);
//  }
//
//  public static boolean validateToken(String token) {
//    return !Jwts.parserBuilder()
//        .setSigningKey(secretKey.getBytes())
//        .build()
//        .parseClaimsJws(token)
//        .getBody()
//        .getExpiration()
//        .before(new Date());
//  }
}

