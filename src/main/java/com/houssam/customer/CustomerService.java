package com.houssam.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation  .PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
//    @Qualifier("fake")
    public CustomerRepo customerRepo;

//    record NewCustomerRequest(String name,String email,Integer age){}

    public List<Customer> getCustomer(){
        return this.customerRepo.findAll();
    }

    public void addCustomer(Customer request){

        Customer customer=new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());

        this.customerRepo.save(customer);

    }

    public Optional<Customer> updateCustomer(Customer request, @PathVariable("CustomerId") Integer id) {

        return this.customerRepo.findById(id).map(
                customer -> {
                    customer.setAge(request.getAge());
                    customer.setName(request.getName());
                    customer.setEmail(request.getEmail());
                    return this.customerRepo.save(customer);
                }
        );

    }

    public void deleteCustomer(Integer id){
        this.customerRepo.deleteById(id);
    }


}
