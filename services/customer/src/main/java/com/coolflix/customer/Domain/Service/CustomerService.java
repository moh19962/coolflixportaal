package com.coolflix.customer.Domain.Service;

import com.coolflix.amqp.Config.RabbitMQMessageProducer;
import com.coolflix.clients.feed.FeedCheckResponse;
import com.coolflix.clients.fraud.FraudCheckResponse;
import com.coolflix.clients.fraud.FraudClient;
import com.coolflix.clients.notification.NotificationClient;
import com.coolflix.clients.notification.NotificationRequest;
import com.coolflix.customer.Domain.Model.Customer;
import com.coolflix.customer.Domain.Request.CustomerRegistrationRequest;
import com.coolflix.customer.Repository.CustomerRepository;
import com.coolflix.feed.Domain.Model.Feed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RestTemplate restTemplate;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
                // todo: check if email valid
                // todo: check if email not taken
                customerRepository.saveAndFlush(customer);

            FraudCheckResponse fraudCheckResponse =
                    fraudClient.isFraudster(customer.getId());

            if (fraudCheckResponse.isFraudster()) {
                throw new IllegalStateException("fraudster");
            }

            NotificationRequest notificationRequest = new NotificationRequest(
                    customer.getId(),
                    customer.getEmail(),
                    String.format("Hi %s, welcome to Coolflix...",
                            customer.getFirstName())
            );
            rabbitMQMessageProducer.publish(
                    notificationRequest,
                    "internal.exchange",
                    "internal.notification.routing-key"
            );
    }

//    public Customer getCustomerWithFeed(Integer customerId) {
//        //Zaslon Je bent bezig met het maken van de rest template
//        log.info("Inside getCustomerWithId of customerController");
//        Customer customer = customerRepository.findByCustomerId(customerId);
//
//
//               FeedCheckResponse feedCheckResponse =  restTemplate.getForObject(
//                        "http://localhost:9093/api/v1/feed/customer/{customerId}",
//                        FeedCheckResponse.class,
//                        customer.getId()
//                );
//        return customer;
//    }

//    public Customer getCustomerWithFeed(Integer customerId) {
//        //Zaslon Je bent bezig met het maken van de rest template
//        log.info("Inside getCustomerWithId of customerController");
//        Customer customer = customerRepository.findByCustomerId(customerId);
//
//
//        FeedCheckResponse feedCheckResponse =  restTemplate.getForObject(
//                "http://localhost:9093/api/v1/feed/customer/{customerId}",
//                FeedCheckResponse.class,
//                customer.getId()
//        );
//        return customer;
//    }

//    public FeedCheckResponse getCustomerWithMessages(Integer customerId) {
//        log.info("Inside getCustomerWithId of customerController");
//        com.coolflix.feed.FeedCheckResponse
//    }
}
