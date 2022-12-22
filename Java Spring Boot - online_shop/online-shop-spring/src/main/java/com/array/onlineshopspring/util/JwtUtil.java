//package com.array.onlineshopspring.util;
//
//import io.jsonwebtoken.*;
//import lombok.Value;
//import lombok.extern.log4j.Log4j2;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Log4j2
//@Component
//public class JwtUtil {
//
//    @Value("${onlineshopspring.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${onlineshopspring.jwtExpirationMs}")
//    private String jwtExpirationMs;
//
//    public String generateJwtToken(Authentication authentication) {
//        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//
//        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.ES512, jwtSecret)
//                .compact();
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//
//        } catch (SignatureException e) {
//            log.error("Invalid JWT signature: {}", e.getMessage());
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            log.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            log.error("JWT token is not supported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims that string is empty: {}", e.getMessage());
//        }
//        return false;
//    }
//}
