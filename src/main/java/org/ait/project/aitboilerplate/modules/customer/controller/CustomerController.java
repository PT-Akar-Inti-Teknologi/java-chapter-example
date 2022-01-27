package org.ait.project.aitboilerplate.modules.customer.controller;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.service.internal.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
}
