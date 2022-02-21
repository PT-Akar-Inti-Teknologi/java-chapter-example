package org.ait.project.aitboilerplate.modules.item.dto.response;

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
public class ItemResponse {

    @JsonProperty("item_id")
    private Long id;

    private String code;

    private String name;

    private BigDecimal price;

    private Integer stock;
}
