package com.caili.todolist.model.dao;

import com.caili.todolist.model.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
