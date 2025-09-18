package com.caili.todolist.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String task = '';

    @Column(insertable = false, columnDefinition = "int default 1")
    Integer status = 1;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Date createTime = new Date();

    @LastModifiedDate
    @Column(nullable = false)
    Date updateTime = new Date();

    @JsonBackReference // 子級角色
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    // 設定多對多關聯時，需要創造中介表格
    // 以此關聯來說，需要設定一個含有 todo_id, tag_id 的中介表格
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="todos_tag", joinColumns = {@JoinColumn(name="tag_id")}, inverseJoinColumns = {@JoinColumn(name="todo_id")})
    Set<Tag> tags;

}
