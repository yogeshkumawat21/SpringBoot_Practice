package com.Main.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthCheck {
    @RequestMapping("/ok")
    public String healthCheck()
    {
        return "ok";
    }
}
