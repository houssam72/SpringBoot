package com.houssam.customer;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository(value = "fake")
public interface CustomerFakeRepository extends CustomerRepo {

    @Override
    public default List<Customer> findAll() {
        return Collections.singletonList(new Customer(1, "FakeName", "FakeEmail",18));
    }
}
