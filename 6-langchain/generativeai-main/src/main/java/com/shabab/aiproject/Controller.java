package com.shabab.aiproject;


import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    ChatLanguageModel model;


    @Autowired
    OllamaAssistant ollamaAssistant;

    @PostMapping
    public String chat(@RequestBody  String prompt){


        String responseText = model.generate(prompt);
        System.out.println(responseText);
        return responseText;




    }
      @PostMapping("/chat2")
    public String chat2(@RequestBody  String prompt){


  return    ollamaAssistant.chat(prompt);





    }


}
