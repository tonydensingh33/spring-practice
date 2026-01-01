package dev.spring.practice1;

//CRUD

import dev.spring.practice1.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
