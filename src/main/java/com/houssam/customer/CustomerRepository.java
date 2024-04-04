package com.houssam.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface  CustomerRepository extends CustomerRepo {
}
