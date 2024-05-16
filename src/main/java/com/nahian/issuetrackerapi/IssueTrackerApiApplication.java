package com.nahian.issuetrackerapi;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IssueTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueTrackerApiApplication.class, args);
    }

    @GetMapping("/")
    public HashMap<String, String> Home() {

        HashMap<String, String> response = new HashMap<>();
        response.put("msg", "Welcome to Issue Tracker");

        return response;
    }
}
