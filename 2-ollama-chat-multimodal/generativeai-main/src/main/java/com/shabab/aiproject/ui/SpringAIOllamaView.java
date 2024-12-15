package com.shabab.aiproject.ui;


import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/ui")
public class SpringAIOllamaView extends VerticalLayout {


    private final OllamaChatModel chatModel;



    Button addNewBtn;

    TextArea textAreaResult;
    TextArea textAreaPrompt;

@Autowired
    public SpringAIOllamaView(OllamaChatModel chatModel) {
        this.chatModel= chatModel;
        textAreaPrompt= new TextArea("Enter your Prompt here");
        textAreaPrompt.setWidth(900, Unit.PIXELS);
        textAreaPrompt.setHeight(200, Unit.PIXELS);
        this.addNewBtn = new Button("Generate");

        addNewBtn.addClickListener(buttonClickEvent -> {
            textAreaResult.setValue("");

textAreaResult.setValue(chatModel.call(textAreaPrompt.getValue()));
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