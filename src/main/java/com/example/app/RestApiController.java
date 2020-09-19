package com.example.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        todoList.add(new Todo("First","Hello"));
    }

    @GetMapping("/todo")
    public ResponseEntity<?> getTodoList() {
        return ResponseEntity.ok().body(todoList);
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") int todoId) {
        return todoList.get(todoId);
    }

    @PutMapping("/todo/{todoId}")
    public ResponseEntity<?> editTodo(@PathVariable(name = "todoId") int todoId,
                         @RequestBody Todo todo) {
        todoList.set(todoId, todo);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "todoId")int todoId){
        todoList.remove(todoId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
        todoList.add(todo);
        return ResponseEntity.ok().body(todo);
    }
}
