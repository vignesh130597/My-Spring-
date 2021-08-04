package com.spring.postgres.dto;

import java.util.List;

public class MessageWrapper {
    public static String finalMessage(List<String> msgList) {
        return (msgList != null && !msgList.isEmpty()) ? String.join(",", msgList) : "";
    }
}
