package com.nhfc99.template.component.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/*
        "iss":"Issuer —— 用于说明该JWT是由谁签发的",
        "sub":"Subject —— 用于说明该JWT面向的对象",
        "aud":"Audience —— 用于说明该JWT发送给的用户",
        "exp":"Expiration Time —— 数字类型，说明该JWT过期的时间",
        "nbf":"Not Before —— 数字类型，说明在该时间之前JWT不能被接受与处理",
        "iat":"Issued At —— 数字类型，说明该JWT何时被签发",
        "jti":"JWT ID —— 说明标明JWT的唯一ID",
        "user-definde1":"自定义属性举例",
        "user-definde2":"自定义属性举例"
*/

@Slf4j
@Component
public class JWTUtils implements Serializable {
    private static final long serialVersionUID = -3301605591108950415L;

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "aud";
    static final String CLAIM_KEY_CREATED = "iat";

    static final String AUDIENCE_UNKNOWN = "unknown";
    static final String AUDIENCE_WEB = "web";
    static final String AUDIENCE_MOBILE = "mobile";
    static final String AUDIENCE_TABLET = "tablet";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.header}")
    private String authorization;

    /**
     * 创建Token
     *
     * @param user
     * @param device
     * @return
     */
//    public String generateToken(User user, Device device) {
//        Map<String, Object> claims = Maps.newHashMap();
//        claims.put("username", user.getU_username());
//        return doGenerateToken(claims, user.getU_id(), generateAudience(device));
//    }

    //实现创建Token
    private String doGenerateToken(Map<String, Object> claims, String subject, String audience) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);
        return Jwts.builder()
                .setClaims(claims)                  //用户参数信息
                .setSubject(subject)                //主题
                .setAudience(audience)              //接收方用户信息可以传递用户id
                .setIssuedAt(createdDate)           //创建时间
                .setExpiration(expirationDate)      //到期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 刷新Token
     *
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 验证Token
     *
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return !isTokenExpired(token);
    }

    /**
     * 判断是否token过期
     *
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    //判断设备
    private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device != null) {
            if (device.isNormal()) {
                audience = AUDIENCE_WEB;
            } else if (device.isTablet()) {
                audience = AUDIENCE_TABLET;
            } else if (device.isMobile()) {
                audience = AUDIENCE_MOBILE;
            }
        }
        return audience;
    }

    //忽略过期设备端
    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getIssuedAtDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    //计算过期时间
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    //获取用户id
    public String getUserId(String token) {
        return getUserIdFromToken(token);
    }

    public String getUserIdFromToken(String token) {
        if (!StringUtils.isEmpty(token) && StringUtils.length(token) != 32) {
            return getClaimFromToken(token, Claims::getSubject);
        }
        return null;
    }

    //创建时间
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    //到期时间
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    //接收方用户信息可以传递用户id
    public String getAudienceFromToken(String token) {
        return getClaimFromToken(token, Claims::getAudience);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 获取所有的自定义数据
     *
     * @param token
     * @return
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}