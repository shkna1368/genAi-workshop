package com.shabab.aiproject.ui;


import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;

@Route("/mmui")
public class SpringAIOllamaMultiodalView extends VerticalLayout {


    private final OllamaChatModel chatModel;



    Button addNewBtn;

    TextArea textAreaResult;
    TextArea textAreaPrompt;

@Autowired
    public SpringAIOllamaMultiodalView(OllamaChatModel chatModel) {
        this.chatModel= chatModel;
        textAreaPrompt= new TextArea("Enter your Prompt here");
        textAreaPrompt.setWidth(900, Unit.PIXELS);
        textAreaPrompt.setHeight(200, Unit.PIXELS);
        this.addNewBtn = new Button("Generate");

        addNewBtn.addClickListener(buttonClickEvent -> {
            textAreaResult.setValue("");



            Resource imageResource = new ClassPathResource("multimodal.test.png");

            var userMessage = new UserMessage("Explain what do you see on this picture?",
                    new Media(MimeTypeUtils.IMAGE_PNG, imageResource));

            ChatResponse response = chatModel.call(new Prompt(userMessage));




textAreaResult.setValue(response.getResults().get(0).toString());
                });






        textAreaResult = new TextArea();
        textAreaResult.setWidth(700, Unit.PIXELS);
        textAreaResult.setHeight(700, Unit.PIXELS);

        textAreaResult.setMaxLength(20000);
        textAreaResult.setValueChangeMode(ValueChangeMode.EAGER);




        HorizontalLayout horizontalLayout=new HorizontalLayout(textAreaResult);


        // build layout
        VerticalLayout actions = new VerticalLayout(textAreaPrompt,addNewBtn);
        add(actions,horizontalLayout);

       // add(new Button("Click me", e -> Notification.show("Hello, Spring+Vaadin user!")));
    }
}