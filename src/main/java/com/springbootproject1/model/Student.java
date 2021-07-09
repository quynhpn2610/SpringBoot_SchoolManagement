package com.springbootproject1.model;

import lombok.Data;

import javax.persistence.*;

// ORM: Object relational mapping - to map java objects --> data in SQL tables (Row: case = object, col: val = attribute)
// This way we don't have to worry about SQL as a java dev
@Entity // To mark this as object --> Springboot knows to use ORM
@Data // lombok import: a springboot library to create getter setter constructor
public class Student {
    @Id // to let Springboot know that this Long id is a primary key (vs. foreign key (a key to bridge to other tables))
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generate id
    private Long id;

    private String name;
    private int age;

    @ManyToOne
    private Classes classes;
}
