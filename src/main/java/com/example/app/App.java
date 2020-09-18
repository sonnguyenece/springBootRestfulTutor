package com.example.app;

import com.example.app.others.OtherGirl;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages ="com.example.app.others")
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
try {
    Girl girl = context.getBean(Girl.class);
    System.out.println("Bean: " + girl.toString());
}catch (NoSuchBeanDefinitionException e){
    System.out.println("no bean");
}
        OtherGirl otherGirl = context.getBean(OtherGirl.class);
        System.out.println("Bean " + otherGirl.toString());

    }

}
