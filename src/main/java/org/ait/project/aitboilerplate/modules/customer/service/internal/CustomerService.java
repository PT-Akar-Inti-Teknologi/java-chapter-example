package org.ait.project.aitboilerplate.modules.customer.service.internal;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.Customer;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.repository.CustomerRepository;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.ait.project.aitboilerplate.shared.utils.ResponseHelpers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<ResponseTemplate<List<CustomerResponse>>> getCustomerList() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = new ArrayList<>();

        customerList.forEach(customer -> {
            //diganti dengan mapstruct mapper
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setId(customer.getId());
            customerResponse.setAddress(customer.getAddress());
            customerResponse.setBalance(customer.getBalance());
            customerResponse.setName(customer.getName());
            customerResponse.setEmail(customer.getEmail());
            customerResponseList.add(customerResponse);
        });

        return ResponseHelpers.createResponse(ResponseEnum.SUCCESS, customerResponseList);
    }

    public ResponseEntity<ResponseTemplate<CustomerResponse>> getCustomerWithId(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(customer -> {
            //ganti dengan mapstruct mapper
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setId(customer.getId());
            customerResponse.setAddress(customer.getAddress());
            customerResponse.setBalance(customer.getBalance());
            customerResponse.setName(customer.getName());
            customerResponse.setEmail(customer.getEmail());
            return ResponseHelpers.createResponse(ResponseEnum.SUCCESS, customerResponse);
        }).orElse(ResponseHelpers.createResponse(
                //ganti dengan throw exception controllerAdvice
                ResponseEnum.DATA_NOT_FOUND, null)
        );
    }

    public ResponseEntity<ResponseTemplate<CustomerResponse>> addCustomer(CustomerRequest customerRequest) {

        //diganti dengan mapstruct mapper
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAddress(customerRequest.getEmail());
        customer.setEmail(customerRequest.getAddress());
        customer.setBalance(BigDecimal.ZERO);

        customer = customerRepository.saveAndFlush(customer);

        //diganti dengan mapstruct mapper
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setBalance(customer.getBalance());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        return ResponseHelpers.createResponse(ResponseEnum.SUCCESS, customerResponse);
    }
}
