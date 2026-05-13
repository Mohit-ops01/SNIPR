package com.snipr.controller;

import com.snipr.dto.ApiResponse;
import com.snipr.dto.DashboardStats;
import com.snipr.entity.ClickLog;
import com.snipr.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse> getDashboardStats() {
        DashboardStats stats = analyticsService.getDashboardStats();
        return ResponseEntity.ok(ApiResponse.success("Dashboard stats retrieved successfully", stats));
    }

    @GetMapping("/url/{id}/clicks")
    public ResponseEntity<ApiResponse> getURLClickLogs(@PathVariable Long id) {
        List<ClickLog> clickLogs = analyticsService.getURLClickLogs(id);
        return ResponseEntity.ok(ApiResponse.success("Click logs retrieved successfully", clickLogs));
    }
}