package dev.spring.practice1.controller;

import dev.spring.practice1.service.TodoService;
import dev.spring.practice1.models.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Min;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@Validated
@Slf4j
public class TodoController {
    @Autowired
    private TodoService todoService;

//    @GetMapping("/data")
//    public String getData() {
//        return todoService.getData();
//    }

    @PostMapping("/create")
    public ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
        try{
            Todo CreatedTodo=todoService.createTodo(todo);
            return new ResponseEntity<>(CreatedTodo, HttpStatus.CREATED);
        }catch(RuntimeException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        try {
            Todo getTo=todoService.getTodo(id);
            return new ResponseEntity<>(getTo, HttpStatus.OK);
        }catch(RuntimeException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<>(todoService.getTodos(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    String deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "Todo deleted successfully " + id;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Todo>> getAllTodosPaged(
            @RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number must be 0 or greater") int page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Page size must be 1 or greater") int size) {
        return new ResponseEntity<>(todoService.getAllTodosPages(page, size), HttpStatus.OK);
    }
}
