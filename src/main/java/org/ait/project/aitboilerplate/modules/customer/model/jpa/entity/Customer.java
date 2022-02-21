package org.ait.project.aitboilerplate.modules.customer.model.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.order.model.entity.Orders;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToOne(mappedBy = "customer")
    private CustomerDetil detil;

}
