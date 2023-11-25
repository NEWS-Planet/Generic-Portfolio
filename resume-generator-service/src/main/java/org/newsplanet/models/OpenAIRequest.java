package org.newsplanet.models;

import lombok.Data;

@Data
public class OpenAIRequest {
    private String prompt;
    private double temperature;
    private int maxTokens;
    private int n;
}