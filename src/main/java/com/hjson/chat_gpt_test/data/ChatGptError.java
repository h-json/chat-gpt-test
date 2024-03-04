package com.hjson.chat_gpt_test.data;

import lombok.Getter;

public class ChatGptError {
    @Getter
    public String message;

    public String type;

    public String param;

    public String code;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("message: ").append(message);
        sb.append("type: ").append(type);
        sb.append("param: ").append(param);
        sb.append("code: ").append(code);

        return sb.toString();
    }
}
