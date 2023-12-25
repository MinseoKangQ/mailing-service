package com.blending.mailingservice.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mailing-service")
public class Test {

    @GetMapping
    public ResponseEntity<?> home() {
        return ResponseEntity.status(HttpStatus.OK).body("테스트입니다.");
    }
}
