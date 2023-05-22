package com.coolflix.customer.Domain.Service;

import com.coolflix.amqp.Config.RabbitMQMessageProducer;
import com.coolflix.clients.fraud.FraudCheckResponse;
import com.coolflix.clients.fraud.FraudClient;
import com.coolflix.clients.notification.NotificationClient;
import com.coolflix.clients.notification.NotificationRequest;
import com.coolflix.customer.Domain.Model.Customer;
import com.coolflix.customer.Domain.Request.CustomerRegistrationRequest;
import com.coolflix.customer.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
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
}
