package org.ait.project.aitboilerplate.modules.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.item.dto.response.ItemResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersResponse {

    @JsonProperty("transaction_code")
    private String transactionCode;

    @JsonProperty("customer")
    private CustomerResponse customer;

    @JsonProperty("detil")
    private List<OrdersDetilResponse> itemOrders;

}
