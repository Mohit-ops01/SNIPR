package com.snipr.dto;

import java.time.LocalDateTime;

public class URLResponse {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private String shortCode;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private Long clickCount;
    private String tags;
    private Boolean isActive;
    private Boolean isSafe;
    private Boolean isPasswordProtected;
    
    public URLResponse() {
    }
    
    public URLResponse(Long id, String originalUrl, String shortUrl, String shortCode, LocalDateTime createdAt,
                       LocalDateTime expiresAt, Long clickCount, String tags, Boolean isActive, Boolean isSafe,
                       Boolean isPasswordProtected) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortCode = shortCode;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.clickCount = clickCount;
        this.tags = tags;
        this.isActive = isActive;
        this.isSafe = isSafe;
        this.isPasswordProtected = isPasswordProtected;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOriginalUrl() {
        return originalUrl;
    }
    
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    
    public String getShortUrl() {
        return shortUrl;
    }
    
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    public String getShortCode() {
        return shortCode;
    }
    
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    public Long getClickCount() {
        return clickCount;
    }
    
    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public Boolean getIsSafe() {
        return isSafe;
    }
    
    public void setIsSafe(Boolean isSafe) {
        this.isSafe = isSafe;
    }
    
    public Boolean getIsPasswordProtected() {
        return isPasswordProtected;
    }
    
    public void setIsPasswordProtected(Boolean isPasswordProtected) {
        this.isPasswordProtected = isPasswordProtected;
    }
    
    // Builder-like static method for compatibility with existing code
    public static URLResponseBuilder builder() {
        return new URLResponseBuilder();
    }
    
    public static class URLResponseBuilder {
        private Long id;
        private String originalUrl;
        private String shortUrl;
        private String shortCode;
        private LocalDateTime createdAt;
        private LocalDateTime expiresAt;
        private Long clickCount;
        private String tags;
        private Boolean isActive;
        private Boolean isSafe;
        private Boolean isPasswordProtected;
        
        public URLResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public URLResponseBuilder originalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
            return this;
        }
        
        public URLResponseBuilder shortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
            return this;
        }
        
        public URLResponseBuilder shortCode(String shortCode) {
            this.shortCode = shortCode;
            return this;
        }
        
        public URLResponseBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        
        public URLResponseBuilder expiresAt(LocalDateTime expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }
        
        public URLResponseBuilder clickCount(Long clickCount) {
            this.clickCount = clickCount;
            return this;
        }
        
        public URLResponseBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }
        
        public URLResponseBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }
        
        public URLResponseBuilder isSafe(Boolean isSafe) {
            this.isSafe = isSafe;
            return this;
        }
        
        public URLResponseBuilder isPasswordProtected(Boolean isPasswordProtected) {
            this.isPasswordProtected = isPasswordProtected;
            return this;
        }
        
        public URLResponse build() {
            return new URLResponse(id, originalUrl, shortUrl, shortCode, createdAt, expiresAt,
                    clickCount, tags, isActive, isSafe, isPasswordProtected);
        }
    }
}