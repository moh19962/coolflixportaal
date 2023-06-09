package com.coolflix.customer.Repository;

import com.coolflix.customer.Domain.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Customer findByCustomerId(Integer customerId);
}
