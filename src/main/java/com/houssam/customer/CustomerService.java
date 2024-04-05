package com.houssam.customer;

import com.houssam.Exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final static Logger LOGGER=  LoggerFactory.getLogger(CustomerService.class);

    @Autowired
//    @Qualifier("fake")
    public CustomerRepo customerRepo;

//    record NewCustomerRequest(String name,String email,Integer age){}

    public List<Customer> getCustomer(){
        LOGGER.info("getCustomers was called");
        return this.customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id){

        if(!this.customerRepo.findById(id).isPresent()) {
            NotFoundException notFoundException = new NotFoundException("Customet with :" + id + " N=not found");
            LOGGER.error("error in getting customer {}",id,notFoundException.toString());
            throw notFoundException;
        }

            return this.customerRepo.findById(id);
    }

    public void addCustomer(Customer request){

        Customer customer=new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());

        this.customerRepo.save(customer);

    }

    public Optional<Customer> updateCustomer(Customer request,  Integer id) {

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
