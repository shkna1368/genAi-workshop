package com.shabab.aiproject;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CalculatorTool {

@Autowired
TestService testService;
    @Tool
    public int sum(int x,int y) {
testService.test();
return x+y;
    }

    @Tool
    public int minus(int x,int y) {
   return      x-y;
    }
}

