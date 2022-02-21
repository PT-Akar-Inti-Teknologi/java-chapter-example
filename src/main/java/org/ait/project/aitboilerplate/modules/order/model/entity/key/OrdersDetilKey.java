package org.ait.project.aitboilerplate.modules.order.model.entity.key;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class OrdersDetilKey implements Serializable {

  @Column(name = "transaction_code")
  String transactionCode;

  @Column(name = "item_id")
  Long itemId;

}
