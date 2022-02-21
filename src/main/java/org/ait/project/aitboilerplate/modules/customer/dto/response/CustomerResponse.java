package org.ait.project.aitboilerplate.modules.customer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    @JsonProperty("customer_id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("password")
    private String password;

    @JsonProperty("customer_name")
    private String name;

    @JsonProperty("customer_email")
    private String email;

    @JsonProperty("customer_address")
    private String address;

    @JsonProperty("customer_balance")
    private BigDecimal balance;
}
