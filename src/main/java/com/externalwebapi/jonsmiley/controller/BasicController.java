package com.externalwebapi.jonsmiley.controller;

import com.externalwebapi.jonsmiley.controller.Authentication.JwtValidation;
import com.externalwebapi.jonsmiley.model.BasicModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {
    //stock api
    @RequestMapping(value = "/stockapi", method = RequestMethod.GET)
    public BasicModel GetStockPrices(
            @RequestParam(value="symbol", required = true) String symbol,
            @RequestParam(value = "series", required = true) String series,
            @RequestHeader(name = "Authorization", required = true) String auth){

        boolean authenticate = JwtValidation.Validation(auth);
        if (authenticate) {
            return new BasicModel(symbol);
        } else {
            String fail = "fail";
            return new BasicModel(fail);
        }
    }
}
