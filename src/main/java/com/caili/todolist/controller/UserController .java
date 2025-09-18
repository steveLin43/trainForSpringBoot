package com.caili.todolist.controller;

import com.caili.todolist.model.entity.Todo;
import com.caili.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}/todos")
    public ResponseEntity getTodosByUserId (@PathVariable Integer id) {
        Optional<User> todos = userService.getTodosByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }
}