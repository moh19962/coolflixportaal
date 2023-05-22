package com.coolflix.customer.Controller;

import com.coolflix.customer.Domain.Request.CustomerRegistrationRequest;
import com.coolflix.customer.Domain.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
