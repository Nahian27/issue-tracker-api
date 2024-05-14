package com.nahian.issuetrackerapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<Object> Home() {

        Map<String, Object> response = new HashMap<>();
        response.put("msg", "Welcome to Issue Tracker");

        return ResponseEntity.ok(response);
    }
}
