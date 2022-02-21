package org.ait.project.aitboilerplate.modules.item.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @JsonProperty("item_code")
    private String code;

    @JsonProperty("item_name")
    private String name;

    @JsonProperty("item_price")
    private BigDecimal price;

    @JsonProperty("stock")
    private Integer stock;
}
