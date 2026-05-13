package com.snipr.dto;

import java.util.List;
import java.util.Map;

public class DashboardStats {
    private Long totalLinks;
    private Long totalClicks;
    private Long activeLinks;
    private List<URLResponse> topLinks;
    private Map<String, Long> dailyClicks;
    
    public DashboardStats() {
    }
    
    public DashboardStats(Long totalLinks, Long totalClicks, Long activeLinks, List<URLResponse> topLinks,
                          Map<String, Long> dailyClicks) {
        this.totalLinks = totalLinks;
        this.totalClicks = totalClicks;
        this.activeLinks = activeLinks;
        this.topLinks = topLinks;
        this.dailyClicks = dailyClicks;
    }
    
    public Long getTotalLinks() {
        return totalLinks;
    }
    
    public void setTotalLinks(Long totalLinks) {
        this.totalLinks = totalLinks;
    }
    
    public Long getTotalClicks() {
        return totalClicks;
    }
    
    public void setTotalClicks(Long totalClicks) {
        this.totalClicks = totalClicks;
    }
    
    public Long getActiveLinks() {
        return activeLinks;
    }
    
    public void setActiveLinks(Long activeLinks) {
        this.activeLinks = activeLinks;
    }
    
    public List<URLResponse> getTopLinks() {
        return topLinks;
    }
    
    public void setTopLinks(List<URLResponse> topLinks) {
        this.topLinks = topLinks;
    }
    
    public Map<String, Long> getDailyClicks() {
        return dailyClicks;
    }
    
    public void setDailyClicks(Map<String, Long> dailyClicks) {
        this.dailyClicks = dailyClicks;
    }
    
    // Builder-like static method for compatibility
    public static DashboardStatsBuilder builder() {
        return new DashboardStatsBuilder();
    }
    
    public static class DashboardStatsBuilder {
        private Long totalLinks;
        private Long totalClicks;
        private Long activeLinks;
        private List<URLResponse> topLinks;
        private Map<String, Long> dailyClicks;
        
        public DashboardStatsBuilder totalLinks(Long totalLinks) {
            this.totalLinks = totalLinks;
            return this;
        }
        
        public DashboardStatsBuilder totalClicks(Long totalClicks) {
            this.totalClicks = totalClicks;
            return this;
        }
        
        public DashboardStatsBuilder activeLinks(Long activeLinks) {
            this.activeLinks = activeLinks;
            return this;
        }
        
        public DashboardStatsBuilder topLinks(List<URLResponse> topLinks) {
            this.topLinks = topLinks;
            return this;
        }
        
        public DashboardStatsBuilder dailyClicks(Map<String, Long> dailyClicks) {
            this.dailyClicks = dailyClicks;
            return this;
        }
        
        public DashboardStats build() {
            return new DashboardStats(totalLinks, totalClicks, activeLinks, topLinks, dailyClicks);
        }
    }
}