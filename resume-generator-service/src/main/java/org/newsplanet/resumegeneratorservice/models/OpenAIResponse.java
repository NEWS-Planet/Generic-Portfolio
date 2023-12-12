package org.newsplanet.resumegeneratorservice.models;

import java.util.List;

import lombok.Data;

@Data
public class OpenAIResponse {
    private List<Choice> choices;

    @Data
    public static class Choice{
        private String text;
    }
}
