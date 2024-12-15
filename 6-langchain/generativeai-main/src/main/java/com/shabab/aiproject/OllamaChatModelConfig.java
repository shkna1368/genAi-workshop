package com.shabab.aiproject;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaChatModelConfig {

    @Value("${langchain4j.ollama.chat-model.base-url}")
    private String baseURL;

    @Value("${langchain4j.ollama.chat-model.model-name}")
    private String modelName;

    @Bean
    ChatLanguageModel ollamaChatModel() {
        return OllamaChatModel.builder()
                .baseUrl(baseURL)
                .modelName(modelName)
                .temperature(0.7)
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}