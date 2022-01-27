package org.ait.project.aitboilerplate.modules.customer.controller;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.service.internal.CustomerService;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ResponseTemplate<List<CustomerResponse>>> getCustomerList(){
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate<CustomerResponse>> getCustomerWithId(@PathVariable Long id){
        return customerService.getCustomerWithId(id);
    }

    @PostMapping
    public ResponseEntity<ResponseTemplate<CustomerResponse>> addCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
}
