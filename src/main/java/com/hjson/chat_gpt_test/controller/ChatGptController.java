package com.hjson.chat_gpt_test.controller;

import com.hjson.chat_gpt_test.data.ChatGptRequestDto;
import com.hjson.chat_gpt_test.data.ChatGptResponseDto;
import com.hjson.chat_gpt_test.service.ChatGptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptController {
    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatGptResponseDto> chat(@RequestBody ChatGptRequestDto chatGptRequestDto) {
        ChatGptResponseDto chatGptResponseDto = chatGptService.chat(chatGptRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(chatGptResponseDto);
    }
}
