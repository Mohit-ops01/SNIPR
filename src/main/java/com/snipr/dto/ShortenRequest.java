package com.snipr.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

public class ShortenRequest {
    
    @NotBlank(message = "URL is required")
    @URL(message = "Invalid URL format")
    private String url;
    
    private String customSlug;
    
    private LocalDateTime expiresAt;
    
    private String password;
    
    private String tags;
    
    public ShortenRequest() {
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCustomSlug() {
        return customSlug;
    }
    
    public void setCustomSlug(String customSlug) {
        this.customSlug = customSlug;
    }
    
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        if (tags instanceof String) {
            this.tags = (String) tags;
        } else if (tags instanceof java.util.List) {
            this.tags = String.join(", ", (java.util.List<String>) tags);
        }
    }
}