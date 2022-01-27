package org.ait.project.aitboilerplate.modules.order.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToMany(mappedBy = "itemList")
    private List<Order> orderList = new ArrayList<>();
}
