package com.example.app;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class Girl {
    @Qualifier("naked")
    @Autowired
    Outfit outfit;

//    Girl(@Qualifier("naked") Outfit outfit) {
//        this.outfit = outfit;
//    }
}
