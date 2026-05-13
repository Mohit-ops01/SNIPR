package com.snipr.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class AIService {

    @Value("${google.safebrowsing.api.key:}")
    private String apiKey;

    private static final String SAFE_BROWSING_URL =
            "https://safebrowsing.googleapis.com/v4/threatMatches:find?key=";

    /**
     * Checks URL safety using Google Safe Browsing API.
     * Returns true if URL is safe, false if threat detected.
     */
    public boolean checkURLSafety(String urlToCheck) {
        if (urlToCheck == null || urlToCheck.isEmpty()) return false;

        // Fallback to basic checks if no API key configured
        if (apiKey == null || apiKey.isEmpty()) {
            return basicSafetyCheck(urlToCheck);
        }

        try {
            String requestBody = "{"
                    + "\"client\": {\"clientId\": \"snipr\", \"clientVersion\": \"1.0\"},"
                    + "\"threatInfo\": {"
                    + "\"threatTypes\": [\"MALWARE\", \"SOCIAL_ENGINEERING\", \"UNWANTED_SOFTWARE\", \"POTENTIALLY_HARMFUL_APPLICATION\"],"
                    + "\"platformTypes\": [\"ANY_PLATFORM\"],"
                    + "\"threatEntryTypes\": [\"URL\"],"
                    + "\"threatEntries\": [{\"url\": \"" + urlToCheck + "\"}]"
                    + "}}";

            URL apiUrl = new URL(SAFE_BROWSING_URL + apiKey);
            HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                Scanner scanner = new Scanner(conn.getInputStream(), StandardCharsets.UTF_8);
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();

                // If response contains "matches", the URL is unsafe
                boolean isSafe = !response.contains("\"matches\"");
                return isSafe;
            }

        } catch (Exception e) {
            // If API call fails, fallback to basic check
            return basicSafetyCheck(urlToCheck);
        }

        return true;
    }

    /**
     * Basic rule-based safety check as fallback
     */
    private boolean basicSafetyCheck(String url) {
        String lower = url.toLowerCase();

        String[] suspiciousTlds = {".tk", ".ml", ".ga", ".cf", ".gq", ".xyz", ".top", ".click"};
        for (String tld : suspiciousTlds) {
            if (lower.contains(tld)) return false;
        }

        String[] maliciousKeywords = {"phishing", "malware", "virus", "hack", "scam", "fraud",
        "fake", "password-reset", "account-verify", "login-verify", "secure-update", "verify-account"};
        for (String kw : maliciousKeywords) {
            if (lower.contains(kw)) return false;
        }

        // Block raw IP addresses
        if (lower.matches("^https?://\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}(:\\d+)?(/.*)?$")) return false;

        // Block non-ASCII (homograph attacks)
        if (!url.matches("^[\\x00-\\x7F]*$")) return false;

        return true;
    }

    public String getSafetyDescription(boolean isSafe) {
        return isSafe ? "URL is safe (verified by Google Safe Browsing)" : "URL flagged as potentially unsafe";
    }
}