package dev.spring.practice1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public String getData() {
        return todoRepository.getData();
    }
}
