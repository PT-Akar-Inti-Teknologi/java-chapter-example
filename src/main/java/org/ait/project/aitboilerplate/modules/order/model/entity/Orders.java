package org.ait.project.aitboilerplate.modules.order.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.Customer;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.CustomerDetil;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "transaction_code")
    String transactionCode;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            insertable = false, updatable = false)
    private CustomerDetil customer;

    @OneToMany(mappedBy = "orders")
    private List<OrdersDetil> itemOrders;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
}
