package com.snipr.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "click_logs", indexes = {
    @Index(name = "idx_url_id", columnList = "url_id"),
    @Index(name = "idx_timestamp", columnList = "timestamp")
})
public class ClickLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "url_id", nullable = false)
    private URL url;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(length = 45)
    private String ipAddress;

    @Column(length = 50)
    private String device;

    @Column(length = 50)
    private String browser;

    @Column(length = 100)
    private String location;

    public ClickLog() {
    }

    public ClickLog(Long id, URL url, LocalDateTime timestamp, String ipAddress, String device, String browser, String location) {
        this.id = id;
        this.url = url;
        this.timestamp = timestamp;
        this.ipAddress = ipAddress;
        this.device = device;
        this.browser = browser;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }
}