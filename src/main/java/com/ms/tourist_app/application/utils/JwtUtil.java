package com.ms.tourist_app.application.utils;

import com.ms.tourist_app.application.constants.AppEnv;
import com.ms.tourist_app.application.constants.AppStr;
import com.ms.tourist_app.application.dai.UserRepository;
import com.ms.tourist_app.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    private final String SECRET_KEY = AppEnv.JwtConfig.secretKey;

    private final Integer TIME_EXPIRATION = AppEnv.JwtConfig.timeExpiration;

    private final UserRepository userRepository;
    private static HttpServletRequest httpServletRequest ;

    public JwtUtil(UserRepository userRepository, HttpServletRequest httpServletRequest) {
        this.userRepository = userRepository;
        JwtUtil.httpServletRequest = httpServletRequest;
    }

    public String extractUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(AppEnv.JwtConfig.secretKey).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }

    public Date extractExpiration(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    public Long getUserIdFromToken() {
        String jwt = httpServletRequest.getHeader(AppStr.Auth.authorization).replace(AppStr.Auth.bearer.concat(AppStr.Base.whiteSpace), "");
        Claims claims = Jwts.parser().setSigningKey(AppEnv.JwtConfig.secretKey).parseClaimsJws(jwt).getBody();
        return Long.parseLong(claims.get("id").toString());
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claim = new HashMap<>();
        User user = userRepository.findByEmail(userDetails.getUsername());
        claim.put(AppStr.AuthorityConstant.claimUUID, userDetails.getUsername());
        claim.put(AppStr.AuthorityConstant.claimId,user.getId());
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setClaims(claim)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TIME_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
}
