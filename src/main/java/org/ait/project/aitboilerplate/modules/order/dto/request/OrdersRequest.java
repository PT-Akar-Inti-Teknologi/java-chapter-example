package org.ait.project.aitboilerplate.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersDetilResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersRequest {

    @JsonProperty("customer_id")
    private String customer_id;

    @JsonProperty("detil")
    private List<OrdersDetilResponse> itemOrders;

}
