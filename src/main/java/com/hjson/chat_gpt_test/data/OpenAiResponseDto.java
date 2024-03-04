package com.hjson.chat_gpt_test.data;

import lombok.Getter;

import java.util.List;

public class OpenAiResponseDto {
    public String warning;

    public String id;

    public String object;

    public Long created;

    public String model;

    @Getter
    public List<ChatGptChoices> choices;

    public ChatGptUsage usage;

    @Getter
    public ChatGptError error;
}
