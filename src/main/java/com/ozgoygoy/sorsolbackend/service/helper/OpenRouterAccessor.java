package com.ozgoygoy.sorsolbackend.service.helper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenRouterAccessor {

    private String openRouterApiKey = "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";


    public String callOpenRouter(String input) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://openrouter.ai/api/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + openRouterApiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "meta-llama/llama-3.2-3b-instruct:free"); // Optional
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", input);
        requestBody.put("messages", new Map[]{message});

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                UriComponentsBuilder.fromHttpUrl(url).toUriString(),
                HttpMethod.POST,
                entity,
                String.class
        );

        return JsonParser.extractContent(response.getBody());
    }




}