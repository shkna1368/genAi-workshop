package com.shabab.aiproject;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class RagService {
    private final VectorStore vectorStore;
    private static final double SIMILARITY_THRESHOLD = 0.5;

    @Value("classpath:input.txt")
    Resource resource;

    public RagService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public String storeAndRetrieveEmbeddings() {
        // Store embeddings
        List<Document> documents =
                List.of(new Document("I like Spring Boot"),
                        new Document("I love Java programming language"));
        vectorStore.add(documents);

        // Retrieve embeddings
        SearchRequest query = SearchRequest.query("Spring Boot").withTopK(2);
        List<Document> similarDocuments = vectorStore.similaritySearch(query);
        String relevantData = similarDocuments.stream()
                .map(Document::getContent)
                .collect(Collectors.joining(System.lineSeparator()));

        return relevantData;
    }

    public String load() throws IOException, InterruptedException {
        List<Document> documents = Files.lines(resource.getFile().toPath())
                .map(line -> new Document(line, Map.of("meta1", "meta2")))
                .toList();

        TextSplitter textSplitter = new TokenTextSplitter();

        for (Document document : documents) {
            List<Document> splitteddocs = textSplitter.split(document);
            System.out.println("before adding document: " + document.getContent());
            vectorStore.add(splitteddocs);
            System.out.println("Added document: " + document.getContent());
           // Thread.sleep(20000);
        }
        return "Loaded " + resource.getFilename();
    }

    public String search() throws IOException, InterruptedException {

        List<Document> results = vectorStore.similaritySearch(SearchRequest.
                query("Bike for small kids").withTopK(2)
                .withSimilarityThreshold(SIMILARITY_THRESHOLD));
        return results.toString();
    }
     public List<Document>  search3() throws IOException, InterruptedException {

         List <Document> documents = List.of(
                    new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
                    new Document("The World is Big and Salvation Lurks Around the Corner"),
                    new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));


//////var x=embeddingModel.embed("tell me a jok");
////
          vectorStore.add(documents);
          List<Document> results = vectorStore.similaritySearch(SearchRequest.query("Spring").withTopK(5));

           return results;
    }


}



