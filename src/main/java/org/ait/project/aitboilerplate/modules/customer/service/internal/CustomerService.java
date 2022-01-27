package org.ait.project.aitboilerplate.modules.customer.service.internal;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


}
