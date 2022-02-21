package org.ait.project.aitboilerplate.modules.customer.model.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.order.model.entity.Orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class CustomerDetil {

    @Id
    private Long id;

    private String name;

    private String company;

    private String email;

    private String address;

    private BigDecimal balance;

    @MapsId
    @OneToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
