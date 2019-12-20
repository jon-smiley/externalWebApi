package com.externalwebapi.jonsmiley.controller;

import com.externalwebapi.jonsmiley.model.BasicModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    private static final String content = "test";

    @RequestMapping("/test")
    public BasicModel test(@RequestParam(value="value", defaultValue ="test1") String value){
        return new BasicModel(value);
    }
}
