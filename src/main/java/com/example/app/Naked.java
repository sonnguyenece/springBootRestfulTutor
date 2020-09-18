package com.example.app;//package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Naked implements Outfit {
    @Override
    public void wear() {
        System.out.println("Wearing Nothing");
    }
}
