package com.externalwebapi.jonsmiley.controller.Authentication;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.HmacKey;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JwtValidation {
    public static boolean Validation(String jwt){
        try{
            if(!jwt.contains("Bearer")){
                return false;
            }
            jwt = jwt.replace("Bearer ", "");
            JsonWebSignature jws = new JsonWebSignature();
            jws.setAlgorithmConstraints(
                    new AlgorithmConstraints(
                            AlgorithmConstraints.ConstraintType.WHITELIST, AlgorithmIdentifiers.HMAC_SHA256)
            );
            jws.setCompactSerialization(jwt);
            String key = "Smiley$1959!384$892-frLn$5578lk0)0f4";

            jws.setKey(new HmacKey(key.getBytes()));
            Object payload = new JSONObject(jws.getPayload());
            long expirationTime = ((JSONObject) payload).getInt("exp");
            Date date = new Date();
            long currentTime = date.getTime()/1000;
            if (currentTime >= expirationTime){
                return false;
            }
            System.out.println("JWS payload: " + payload);
        }catch (Exception ex){
            System.out.println(ex);
                return false;
            }
        return true;
    }
}
