package org.ait.project.aitboilerplate.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersDetilResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetilRequest {

    @JsonProperty("item_id")
    private String id;

    @JsonProperty("qty")
    private List<OrdersDetilResponse> itemOrders;

}
