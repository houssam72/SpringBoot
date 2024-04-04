package com.houssam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@SpringBootApplication
//@RestController
public class Main {

     public static void main(String[] args){
        SpringApplication.run(Main.class,args);
    }

//    @GetMapping("/greet")
//    public Greet greet(){
//        return new Greet("Hello",List.of("Java","Golang","Javascript"),new Person("Houssam" , 30 , 15));
//    }
//
//    record Person(String name , int age , double savings ){}
//
//    record Greet(
//            String green,
//            List<String> favProgramingLanguages,
//            Person person
//    ){}
//
//    @GetMapping("/user")
//    private User getUser(){
//        return new User(1L,"houssam");
//    }
//
//    private class User{
//
//        private Long id;
//        private String name;
//
//        public User(Long id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public Long getIdUtilisateur() {
//            return id;
//        }
//
//        public String getNameUtilisateur() {
//            return name;
//        }
//    }

}
