package org.ait.project.aitboilerplate.modules.customer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.service.internal.CustomerService;
import org.ait.project.aitboilerplate.shared.constant.GlobalConstant;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(tags = GlobalConstant.documentationGroupCustomer)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDataCustomer)
    public ResponseEntity<ResponseTemplate<List<CustomerResponse>>> getCustomerList(){
        return customerService.getCustomerList();
    }

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDetilCustomer)
    public ResponseEntity<ResponseTemplate<CustomerResponse>> getCustomerWithId(@PathVariable Long id){
        return customerService.getCustomerWithId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagCreateCustomer)
    public ResponseEntity<ResponseTemplate<CustomerResponse>> addCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
}
