package com.shabab.aiproject.funcs;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
    ChatClient chatClient;
    public CustomService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
public String sendMessage(String message) {
String prompt =message+ " .Respond only with required function call";
    var response = chatClient
            .prompt()
            .user(prompt)
            .functions("booksByAuthor","flightSearch") // reference by bean name.

            .call()
            .content();


return    response.toString();


}

}
