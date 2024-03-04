package com.hjson.chat_gpt_test.service;

import com.hjson.chat_gpt_test.data.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGptService {
    @Value("${openai.secret-key}")
    private String secretKey;

    public ChatGptResponseDto chat(ChatGptRequestDto chatGptRequestDto) {
        System.out.println(secretKey);
        System.out.println(chatGptRequestDto.getMessage());

        List<ChatGptMessage> messages = new ArrayList<>();
        ChatGptMessage message = new ChatGptMessage("user", chatGptRequestDto.getMessage());
        messages.add(message);

        OpenAiRequestDto openAiRequestDto = new OpenAiRequestDto(
                "gpt-3.5-turbo",
                messages,
                0
        );

        WebClient webClient = WebClient.builder().baseUrl("https://api.openai.com").build();
        OpenAiResponseDto openAiResponseDto = webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/v1/chat/completions").build())
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                    headers.add("Authorization", "Bearer " + secretKey);
                })
                .bodyValue(openAiRequestDto)
                .retrieve()
                .bodyToMono(OpenAiResponseDto.class)
                .block();

        if(openAiResponseDto.getError() != null) {
            System.out.println(openAiResponseDto.getError());
        }

        return new ChatGptResponseDto(openAiResponseDto.getChoices().get(0).getMessage().getContent());
    }
}
