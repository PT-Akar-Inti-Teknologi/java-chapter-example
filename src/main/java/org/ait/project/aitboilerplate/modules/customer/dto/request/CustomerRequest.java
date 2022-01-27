package org.ait.project.aitboilerplate.modules.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "{customer.name.blank}")
    @JsonProperty("customer_name")
    private String name;

    @NotBlank(message = "{customer.email.blank}")
    @Email(message = "{customer.email.not-valid}")
    @JsonProperty("customer_email")
    private String email;

    @NotBlank(message = "{customer.address.blank}")
    @JsonProperty("customer_address")
    private String address;
}
