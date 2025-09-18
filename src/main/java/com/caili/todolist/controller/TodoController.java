package com.caili.todolist.controller;

import com.caili.todolist.model.entity.Todo;
import com.caili.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String getTodos(Model model) {
        Iterable<Todo> todoList = todoService.getTodo();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "todolist";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
        Iterable<Todo> allTodoList = todoService.createTodo(todo);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "redirect:/todos"; // 自動重整頁面，避免要必須手動重整頁面而導致重複送值問題
    }

    @ResponseBody
    @PutMapping("/todos/{id}")
    public String upadteTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        todoService.updateTodo(id ,todo);
        return "OK";
    }

    @ResponseBody
    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
        return "OK";
    }
}
