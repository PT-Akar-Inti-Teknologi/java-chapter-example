package org.ait.project.aitboilerplate.modules.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.order.dto.request.OrdersRequest;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersResponse;
import org.ait.project.aitboilerplate.modules.order.service.internal.OrdersService;
import org.ait.project.aitboilerplate.shared.constant.GlobalConstant;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@Api(tags = GlobalConstant.documentationGroupOrder)
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDataOrder)
    public ResponseEntity<ResponseTemplate<List<OrdersResponse>>> getItemList(){
        return orderService.getOrderList();
    }

    @GetMapping(value = "/{transactionCode}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDetilOrder)
    public ResponseEntity<ResponseTemplate<OrdersResponse>> getItemWithTransactionCode(@PathVariable String transactionCode){
        return orderService.getOrderWithTransactionCode(transactionCode);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagCreateOrder)
    public ResponseEntity<ResponseTemplate<OrdersResponse>> addCustomer(@Valid @RequestBody OrdersRequest orderRequest){
        return orderService.addOrder(orderRequest);
    }
}
