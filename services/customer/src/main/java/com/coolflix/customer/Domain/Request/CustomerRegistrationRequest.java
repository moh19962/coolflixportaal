package com.coolflix.customer.Domain.Request;

public record CustomerRegistrationRequest(
      String firstName,
      String lastName,
      String email) {
}
