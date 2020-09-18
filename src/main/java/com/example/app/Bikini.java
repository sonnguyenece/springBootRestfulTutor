package com.example.app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Wearing Bikini");
    }
}
