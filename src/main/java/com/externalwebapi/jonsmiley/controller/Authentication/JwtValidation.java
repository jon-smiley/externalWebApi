package com.externalwebapi.jonsmiley.controller.Authentication;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.HmacKey;

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
            String payload = jws.getPayload();
            System.out.println("JWS payload: " + payload);
            //need to verify that token is not expired.

        }catch (Exception ex){
            System.out.println(ex);
                return false;
            }
        return true;
    }
}
