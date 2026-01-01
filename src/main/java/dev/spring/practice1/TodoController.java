package dev.spring.practice1;

import dev.spring.practice1.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
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
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        try {
            Todo getTo=todoService.getTodo(id);
            return new ResponseEntity<>(getTo, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
