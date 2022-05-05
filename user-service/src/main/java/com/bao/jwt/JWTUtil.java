package com.bao.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static final long TOKEN_EXPIRE_TIME= 60*60*24*1000;
    private static final String TOKEN_SECRET="hexiao";


    private static final String TOEKN_EXPIRED = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJ1c2VyTmFtZSI6IuWMheeCnCIsImV4cCI6MTY1MTcyMjEyNH0.hijTZpjZ0sN0IAW7IbbFqvKAPDIUoPQZqcvEQ2r_2no";
    private static final String TOEKN = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJ1c2VyTmFtZSI6IuWMheeCnCIsImV4cCI6MTY1MTgyMjA0Nn0.h3Rij3fWE7AB-sf_OHda75pP6W7P_mVuVKC3nVGwyLc";
    public static void main(String[] args) {
        generatorToken("包炜");
        Map<String,Claim> map = verifyToken(TOEKN);
        System.out.println("map=" + map);
        for(Map.Entry<String,Claim> entry: map.entrySet()){
            if(entry.getValue().asString()!=null){
                System.out.println(entry.getKey()+"=="+entry.getValue().asString());
            }else{
                System.out.println(entry.getKey()+"=="+entry.getValue().asDate());
            }
        }
//        System.out.println(parseToken(TOEKN));
    }
    public static String generatorToken(String userName){
        Date date = new Date(System.currentTimeMillis()+TOKEN_EXPIRE_TIME);
        Map<String,Object> header = new HashMap<>(2);
        header.put("type","JWT");
        header.put("alg","H256");
        String token = JWT.create()
                .withHeader(header)
                .withClaim("userName",userName)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(TOKEN_SECRET));

        System.out.println(token);


        return token;
    }

    /**
     * 验证token
     */
    public static Map<String, Claim> verifyToken(String token){
        JWTVerifier verifier =JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
        DecodedJWT jwt = null;
        try{
            jwt = verifier.verify(token);
        }catch(Exception e){
            e.printStackTrace();
        }
        return jwt.getClaims();

    }

    /**
     * 解析token
     */
    public static Map<String,Claim> parseToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }

}
