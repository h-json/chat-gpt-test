package com.hjson.chat_gpt_test.data;

import lombok.Getter;

public class ChatGptChoices {
    @Getter
    public ChatGptMessage message;

    public int index;

    public String logprobs;

    public String finish_reason;
}
