package com.example.demo.Service;


import com.example.demo.Exceptions.IdNotFoundException;
import com.example.demo.Repository.DogRepository;


import com.example.demo.User.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

import static java.util.Arrays.stream;

@Service
public class DogService {
    @Autowired
    public DogRepository dogRepository;

    public void serviceSaveMethod(Dog user) {

        dogRepository.save(user);
    }

    

    public ResponseEntity<Dog> serviceFindMethod(Long id) throws IdNotFoundException {

        Optional<Dog> user = dogRepository.findById(id);
        if (user.isPresent()) {
            Dog actualuser = user.get();
            return ResponseEntity.ok().header("output", "object information").body(actualuser);
        }

        throw new IdNotFoundException("id not found in database, please try again");
 

    }
 

    public String serviceFindAgeMethod(int age) {
        List<Dog> li = dogRepository.findAll();

        Function<Dog, String> lambVar = person -> String.valueOf(person.getId());


        List<String> info = li.stream().filter(person -> person.age < 30).map(lambVar).toList();


        return "the following id values for this age and below is "+String.join(", ",info);


    }


    public String deleteId(Long id) {

        if (dogRepository.existsById(id)) {
            dogRepository.deleteById(id);
            return "found";
        }
        return "not found";

    }


    public String serviceAgeCheck(Long age){
        List<Dog> li=dogRepository.findAll();


        List<Integer> ageLi =new ArrayList<>();
        li.stream().filter(person->person.getAge()<=age).forEach(person->ageLi.add(person.getAge()));

        return ageLi.isEmpty()?"unfortunately no people of the age "+age+" or less were found":(ageLi.size()*100)/ li.size()+"% of the people are under the age of "+age;


    }







}
