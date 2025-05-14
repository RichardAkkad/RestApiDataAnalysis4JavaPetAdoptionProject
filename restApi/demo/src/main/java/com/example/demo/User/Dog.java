package com.example.demo.User;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity//means its going to be used in a database and the table will come under the table name automatically as Person when use this annotation @Entity
// i think we can change the table name if we want

public class Dog {

    public static long TOTAL=0;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String sex;
    public int age;
    public String breed;
    public String colour;




    {
        TOTAL += 1;//This block is executed whenever an instance of the class is created, right before the constructor is called. its called a instance initializer
    }









}
