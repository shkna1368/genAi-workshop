package com.shabab.aiproject.funcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ControllerTest {
    @Autowired
    CustomService customService;

    @PostMapping
    public String postMessage(@RequestBody String message) {

      return   customService.sendMessage(message);
    }
}
