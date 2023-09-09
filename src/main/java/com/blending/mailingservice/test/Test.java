package com.blending.mailingservice.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mailing-service")
public class Test {

    @GetMapping()
    public String home() {
        return "mailing-service test";
    }
}
