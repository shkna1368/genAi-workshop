package com.shabab.aiproject;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;

import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SpringAiApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiApplication.class, args);
    }


//
//    @Bean
//    public CommandLineRunner cli(@Value("classpath:wikipedia-hurricane-milton-page.pdf") Resource hurricaneDocs,
//                                 ChatClient.Builder chatClientBuilder, VectorStore vectorStore, EmbeddingModel embeddingModel) {
//
//        return args -> {
//
//
//
//            List <Document> documents = List.of(
//                    new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
//                    new Document("The World is Big and Salvation Lurks Around the Corner"),
//                    new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));
//
//
//////var x=embeddingModel.embed("tell me a jok");
////
//           vectorStore.add(documents);
//           List<Document> results = vectorStore.similaritySearch(SearchRequest.query("Spring").withTopK(5));
////
//           System.out.println(results);
//
//
////            // 1. Load the hurricane documents in vector store
////            vectorStore.add(new TokenTextSplitter().split(new PagePdfDocumentReader(hurricaneDocs).read()));
////
////            // 2. Create the ChatClient with chat memory and RAG support
////            var chatClient = chatClientBuilder
////                    .defaultSystem("You are useful assistant, expert in hurricanes.") // Set the system prompt
////                    .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory())) // Enable chat memory
////                    .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore)) // Enable RAG
////                    .build();
////
////
////
////            SearchRequest request = SearchRequest.query("mexico tropical storm");
////            // Query Redis for the top K documents most relevant to the input message
////            List<Document> docs = vectorStore.similaritySearch(request);
////            System.out.println(docs.toString());
//          //  UserMessage userMessage = new UserMessage(message);
//
//
//
//
////            // 3. Start the chat loop
////            System.out.println("\nI am your Hurricane Milton assistant.\n");
////            try (Scanner scanner = new Scanner(System.in)) {
////                while (true) {
////                    System.out.print("\nUSER: ");
////                    System.out.println("\nASSISTANT: " +
////                            chatClient.prompt(scanner.nextLine()) // Get the user input
////                                    .call()
////                                    .content());
////                }
////            }
//        };
//    }

}
