package org.ait.project.aitboilerplate.modules.customer.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse extends CustomerRequest {

    @JsonProperty("customer_id")
    private Long id;

    @JsonProperty("customer_balance")
    private BigDecimal balance;

}
