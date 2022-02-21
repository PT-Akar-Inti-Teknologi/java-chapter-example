package org.ait.project.aitboilerplate.modules.item.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.order.model.entity.OrdersDetil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

    private BigDecimal price;

    private Integer stock;

    @OneToMany(mappedBy = "item")
    private List<OrdersDetil> orders;
}
