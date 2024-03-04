package com.hjson.chat_gpt_test.data;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OpenAiRequestDto {
    public String model;

    public List<ChatGptMessage> messages;

    public double temperature;
}
