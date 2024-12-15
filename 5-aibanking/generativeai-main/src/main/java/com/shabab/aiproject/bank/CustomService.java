package com.shabab.aiproject.bank;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

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
            .functions("openBankAccount","fundTransfer")

            .call()
            .content();


return    response.toString();


}

public List<BankAccount> getAllAccount(){


}

}
