package com.snipr.controller;

import com.snipr.dto.ApiResponse;
import com.snipr.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SafetyController {

    @Autowired
    private AIService aiService;

    @PostMapping("/check-safety")
    public ResponseEntity<ApiResponse> checkSafety(@RequestBody Map<String, String> body) {
        String url = body.get("url");

        if (url == null || url.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("URL is required"));
        }

        boolean isSafe = aiService.checkURLSafety(url);
        String description = aiService.getSafetyDescription(isSafe);

        Map<String, Object> result = new HashMap<>();
        result.put("safe", isSafe);
        result.put("message", description);

        return ResponseEntity.ok(ApiResponse.success(description, result));
    }
}