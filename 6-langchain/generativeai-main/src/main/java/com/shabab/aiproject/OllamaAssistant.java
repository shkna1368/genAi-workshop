package com.shabab.aiproject;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT, chatModel = "ollamaChatModel")

public interface OllamaAssistant {



    @SystemMessage("You are math assistant")
    String chat(String userMessage);
}
