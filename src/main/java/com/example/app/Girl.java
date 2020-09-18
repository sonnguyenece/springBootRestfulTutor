package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class Girl {
    Outfit outfit;

}
