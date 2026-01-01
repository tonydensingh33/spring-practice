package dev.spring.practice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoRepository {

    @Autowired
    String getData() {
        return "Data is fetched from Respository";
    }
}
