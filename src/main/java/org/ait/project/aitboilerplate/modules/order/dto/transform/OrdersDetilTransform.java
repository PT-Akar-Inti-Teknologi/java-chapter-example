package org.ait.project.aitboilerplate.modules.order.dto.transform;

import org.ait.project.aitboilerplate.modules.item.dto.transform.ItemTransform;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersDetilResponse;
import org.ait.project.aitboilerplate.modules.order.model.entity.OrdersDetil;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemTransform.class)
public interface OrdersDetilTransform {

    @Named("toDetilOrderResponse")
    OrdersDetilResponse toResponse(OrdersDetil data);

    @Named("toDetilOrderListResponse")
    @IterableMapping(qualifiedByName = "toDetilOrderResponse")
    List<OrdersDetilResponse> toListResponse(List<OrdersDetil> data);

}
