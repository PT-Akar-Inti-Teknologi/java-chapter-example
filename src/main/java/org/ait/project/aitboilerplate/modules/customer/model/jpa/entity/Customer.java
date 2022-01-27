package org.ait.project.aitboilerplate.modules.customer.model.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.order.model.entity.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String address;

    private BigDecimal balance;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderSets = new ArrayList<>();
}
