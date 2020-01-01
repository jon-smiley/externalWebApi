package com.externalwebapi.jonsmiley.controller;

import com.externalwebapi.jonsmiley.controller.Authentication.JwtValidation;
import com.externalwebapi.jonsmiley.model.BasicModel;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @RequestMapping("/stockapi")
    public BasicModel GetStockPrices(
            @RequestParam(value="value", defaultValue ="test1") String value,
            @RequestHeader(name = "Authorization", required = true) String auth){

        boolean authenticate = JwtValidation.Validation(auth);
        if (authenticate) {
            return new BasicModel(value);
        } else {
            String fail = "fail";
            return new BasicModel(fail);
        }
    }
}
