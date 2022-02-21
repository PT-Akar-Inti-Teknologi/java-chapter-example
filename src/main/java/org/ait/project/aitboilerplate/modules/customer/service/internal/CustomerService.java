package org.ait.project.aitboilerplate.modules.customer.service.internal;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.dto.transform.CustomerTransform;
import org.ait.project.aitboilerplate.modules.customer.exception.CustomerException;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.CustomerDetil;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.repository.CustomerDetilRepository;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.ait.project.aitboilerplate.shared.utils.ResponseHelpers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDetilRepository customerDetilRepository;
    private final ResponseHelpers responseHelpers;
    private final CustomerTransform customerTransform;

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<List<CustomerResponse>>> getCustomerList() {
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                customerTransform.toListResponse(customerDetilRepository.findAll()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<CustomerResponse>> getCustomerWithId(Long id) {
        Optional<CustomerDetil> customerOptional = customerDetilRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new CustomerException(ResponseEnum.CUSTOMER_NOT_FOUND, id);
        }
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                customerTransform.toResponse(customerOptional.get()));
    }

    @Transactional
    public ResponseEntity<ResponseTemplate<CustomerResponse>> addCustomer(CustomerRequest customerRequest) {
        if(customerDetilRepository.findByCustomerUsernameOrEmail(customerRequest.getUsername(), customerRequest.getEmail()).isPresent()){
            throw new CustomerException(ResponseEnum.PARAM_INVALID, customerRequest.getEmail());
        }
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                    customerTransform.toResponse(customerDetilRepository
                            .saveAndFlush(customerTransform.toEntity(customerRequest))));
    }
}
