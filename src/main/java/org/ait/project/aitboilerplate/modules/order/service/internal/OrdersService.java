package org.ait.project.aitboilerplate.modules.order.service.internal;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.exception.CustomerException;
import org.ait.project.aitboilerplate.modules.order.dto.request.OrdersRequest;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersResponse;
import org.ait.project.aitboilerplate.modules.order.dto.transform.OrdersTransform;
import org.ait.project.aitboilerplate.modules.order.model.entity.Orders;
import org.ait.project.aitboilerplate.modules.order.model.entity.OrdersDetil;
import org.ait.project.aitboilerplate.modules.order.model.repository.OrdersRepository;
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
public class OrdersService {

    private final OrdersRepository orderRepository;
    private final ResponseHelpers responseHelpers;
    private final OrdersTransform orderTransform;

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<List<OrdersResponse>>> getOrderList() {
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                orderTransform.toListResponse(orderRepository.findAll()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<OrdersResponse>> getOrderWithTransactionCode(String transactionCode) {
        Optional<Orders> customerOptional = orderRepository.findByTransactionCode(transactionCode);
        if (!customerOptional.isPresent()) {
            throw new CustomerException(ResponseEnum.CUSTOMER_NOT_FOUND, transactionCode);
        }
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                orderTransform.toResponse(customerOptional.get()));
    }

    public ResponseEntity<ResponseTemplate<OrdersResponse>> addOrder(OrdersRequest orderRequest) {
        return null;
    }
}
