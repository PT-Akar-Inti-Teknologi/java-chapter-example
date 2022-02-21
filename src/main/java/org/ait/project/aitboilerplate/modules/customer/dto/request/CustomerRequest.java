package org.ait.project.aitboilerplate.modules.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @Size(min = 5, message = "{customer.username.minimum}")
    @JsonProperty("username")
    private String username;

    @Size(min = 5, message = "{customer.password.minimum}")
    @JsonProperty("password")
    private String password;

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
