package com.houssam.customer;


import com.houssam.Exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

    @GetMapping
    public List<Customer> getCustomer(){
        return this.CustomerService.getCustomer();
    }


    @GetMapping("{CustomerId}/Exception")
    public Optional<Customer> getCustomerById(@PathVariable("CustomerId") Integer id){
        throw new ApiRequestException("ApiRequestException for customer" + id);
    }

    @GetMapping("{CustomerId}")
    public Optional<Customer> getCustomerByIdException(@PathVariable("CustomerId") Integer id){
        return this.CustomerService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@Valid @RequestBody Customer request){

        this.CustomerService.addCustomer(request);

    }

    @PutMapping("{CustomerId}")
    public Optional<Customer> replaceEmployee(@RequestBody Customer request, @PathVariable("CustomerId") Integer id) {

        return this.CustomerService.updateCustomer(request,id);

    }

    @DeleteMapping("{CustomerId}")
    public void deleteCustomer(@PathVariable("CustomerId") Integer id){
        this.CustomerService.deleteCustomer(id);
    }
}
