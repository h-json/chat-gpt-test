package com.hjson.chat_gpt_test.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ChatGptMessage {
    public String role;

    @Getter
    public String content;
}
