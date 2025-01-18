package com.example.wordgame.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class DictionaryService {

    private final RestTemplate restTemplate;
    private static final String API_KEY = "c0b422a3-ae51-43b7-8807-83a462b2a373:fx";
    private static final String API_URL = "https://api-free.deepl.com/v2/translate";

    public DictionaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTranslation(String word) {
        String url = UriComponentsBuilder
                .fromUriString(API_URL)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "DeepL-Auth-Key " + API_KEY);
        String targetLang = "EN";

        String body = "text=" + URLEncoder.encode(word, StandardCharsets.UTF_8) +
                "&target_lang=" + URLEncoder.encode(targetLang, StandardCharsets.UTF_8);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        try {
            String response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
            System.out.println("Translation for " + word + ": " + response); // Print to console
            StringBuilder data = new StringBuilder();
            for (int i = 58; i < Objects.requireNonNull(response).length()-4; i++) {
                data.append(response.charAt(i));
            }
            System.out.println(data);
            return data.toString();
        } catch (Exception e) {
            System.out.println("Error fetching translation: " + e.getMessage());
        }
        return "Translation not found.";
    }
}
