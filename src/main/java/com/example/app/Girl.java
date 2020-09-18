package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Girl {
    @Override
    public String toString() {
        return "Girl.java";
    }
}
