package com.backend.todolist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.todolist.exception.ResourceNotFoundException;
import com.backend.todolist.exception.ServerError;
import com.backend.todolist.model.Todo;
import com.backend.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/items")
    public List<Todo> getAllItems() {
        List<Todo> lyricsList = new ArrayList<>();

        Streamable.of(todoRepository.findAll()).forEach(lyricsList::add);

        return lyricsList;
    }

    @PostMapping("/add/item")
    public Todo addUser(@RequestBody Todo user) {
        return todoRepository.save(user);
    }

    @PutMapping("/update/item/{id}")
    public Todo updateUser(@PathVariable("id") Long id, @RequestBody Todo user) {
        Todo itemDetails = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
        itemDetails.setName(user.getName());
        itemDetails.setCompleted(user.isCompleted());

        return todoRepository.save(itemDetails);
    }

    @DeleteMapping("item/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id) {
        Todo user = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        todoRepository.delete(user);
        return true;
    }

    @GetMapping("item/{id}")
    public Todo findById(@PathVariable("id") Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }
}
