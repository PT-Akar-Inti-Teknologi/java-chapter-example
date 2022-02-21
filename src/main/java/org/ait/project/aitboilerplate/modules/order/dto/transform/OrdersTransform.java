package org.ait.project.aitboilerplate.modules.order.dto.transform;

import org.ait.project.aitboilerplate.modules.customer.dto.transform.CustomerTransform;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersResponse;
import org.ait.project.aitboilerplate.modules.order.model.entity.Orders;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = { CustomerTransform.class, OrdersDetilTransform.class})
public interface OrdersTransform {

    @Named("toItemResponse")
    @Mapping(target = "customer", source = "customer", qualifiedByName = "toCustomerResponse")
    @Mapping(target = "itemOrders", source = "itemOrders", qualifiedByName = "toDetilOrderListResponse")
    OrdersResponse toResponse(Orders data);

    @Named("tItemListResponse")
    @IterableMapping(qualifiedByName = "toItemResponse")
    List<OrdersResponse> toListResponse(List<Orders> data);

}
