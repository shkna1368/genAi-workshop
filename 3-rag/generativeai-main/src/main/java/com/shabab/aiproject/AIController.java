package com.shabab.aiproject;



import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AIController {

  @Autowired
  RagService myComp;



    @GetMapping("/search2")
    public String search2() throws IOException, InterruptedException {
return myComp.storeAndRetrieveEmbeddings();
    }

    private static final double SIMILARITY_THRESHOLD = 0.5;



    @GetMapping("/load")
    public String load() throws IOException, InterruptedException {
      return myComp.load();
    }

    @GetMapping("/search")
    public String search() throws IOException, InterruptedException {

        return myComp.search();

    }

    @GetMapping("/search3")
    public List<Document> search3() throws IOException, InterruptedException {

        return myComp.search3();

    }
}
