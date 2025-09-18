package com.caili.todolist.service;

import com.caili.todolist.model.dao.TodoDao;
import com.caili.todolist.model.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Optional<User> getTodosByUserId(Integer id) {
        Optional<User> data = userDao.findById(id);
        return data;
    }
}
