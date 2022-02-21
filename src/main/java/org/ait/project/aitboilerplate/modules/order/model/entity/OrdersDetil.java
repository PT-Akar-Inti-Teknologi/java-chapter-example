package org.ait.project.aitboilerplate.modules.order.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.Customer;
import org.ait.project.aitboilerplate.modules.item.model.entity.Item;
import org.ait.project.aitboilerplate.modules.order.model.entity.key.OrdersDetilKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class OrdersDetil {

    @EmbeddedId
    private OrdersDetilKey key;

    @ManyToOne
    @JoinColumn(
            name = "item_id",
            referencedColumnName = "id",
            insertable = false, updatable = false)
    private Item item;

    private Integer qty;

    @ManyToOne
    @JoinColumn(
            name = "transaction_code",
            referencedColumnName = "transaction_code",
            insertable = false, updatable = false)
    private Orders orders;
}
