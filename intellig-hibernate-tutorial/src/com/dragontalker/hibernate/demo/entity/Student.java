package com.dragontalker.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    public Student() {}

    private String firstName;

    private String lastName;

    private String email;


}
