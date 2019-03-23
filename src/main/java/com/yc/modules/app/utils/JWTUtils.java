package com.yc.modules.app.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * json web token 工具类
 *
 * unsignedToken = encodeBase64(header) + '.' + encodeBase64(payload)
 * signature = HMAC-SHA256(key, unsignedToken)
 * token = encodeBase64(header) + '.' + encodeBase64(payload) + '.' + encodeBase64(signature)
 */
@ConfigurationProperties(prefix = "yc.jwt")
@Component
@Slf4j
public class JWTUtils {

    // 生成签名秘钥
    private String secret;
    // token过期时间
    private long expire;
    private String header;

    /**
     * 生成json web token
     * @param userId
     * @return
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setSubject(userId + "").setIssuedAt(nowDate).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("validate is token error ", e);
            return null;
        }
    }

    /**
     * token是否过期    true：过期
     * @param expiration    过期时间
     * @return
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}