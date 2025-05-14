package com.example.demo.Controller;


import com.example.demo.Service.DogService;
import com.example.demo.User.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DogController {
    @Autowired
    DogService dogService;



    @GetMapping("save")
    public void  saveMethod(@RequestBody Dog user) {
        dogService.serviceSaveMethod(user);


    }

    @GetMapping("searchById")
    public ResponseEntity<Dog> findPersonMethod(@RequestParam Long id)  {
        try {
            return dogService.serviceFindMethod(id);
        }
        catch(Exception e){

            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();// need this if want details about the exception in the terminal because cant have return statement and send a exception to the terminal,
            //its either one or the other when in the same method scope

            return ResponseEntity.notFound().build();



        }

    }



    @GetMapping("idOfCertainAge")
    public String searchForSpecificAge(@RequestParam int age ){
        return dogService.serviceFindAgeMethod(age);


    }

    @PostMapping("deleteId")
    public String deleteId(@RequestParam Long id){
        return dogService.deleteId(id);


    }

    @GetMapping("underCertainAgePercentage")
    public String returnPercentage(@RequestParam Long age){

        return dogService.serviceAgeCheck(age);

    }
















}
