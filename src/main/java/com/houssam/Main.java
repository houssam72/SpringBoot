package com.houssam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customer")
public class Main {


     @Autowired
     private CustomerRepository customerRepository;
     public static void main(String[] args){
        SpringApplication.run(Main.class,args);
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return this.customerRepository.findAll();
    }

    record NewCustomerRequest(String name,String email,Integer age){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){

         Customer customer=new Customer();
         customer.setName(request.name);
         customer.setEmail(request.email);
         customer.setAge(request.age);

        this.customerRepository.save(customer);

    }

    @PutMapping("{CustomerId}")
    public Optional<Customer> replaceEmployee(@RequestBody NewCustomerRequest request, @PathVariable("CustomerId") Integer id) {

       return this.customerRepository.findById(id).map(
               customer -> {
                   customer.setAge(request.age);
                   customer.setName(request.name);
                   customer.setEmail(request.email);
                   return this.customerRepository.save(customer);
               }
       );

    }

    @DeleteMapping("{CustomerId}")
    public void deleteCustomer(@PathVariable("CustomerId") Integer id){
         this.customerRepository.deleteById(id);
    }


    @GetMapping("/greet")
    public Greet greet(){
        return new Greet("Hello",List.of("Java","Golang","Javascript"),new Person("Houssam" , 30 , 15));
    }

    record Person(String name , int age , double savings ){}

    record Greet(
            String green,
            List<String> favProgramingLanguages,
            Person person
    ){}

    @GetMapping("/user")
    private User getUser(){
        return new User(1L,"houssam");
    }

    private class User{

        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getIdUtilisateur() {
            return id;
        }

        public String getNameUtilisateur() {
            return name;
        }
    }

}
