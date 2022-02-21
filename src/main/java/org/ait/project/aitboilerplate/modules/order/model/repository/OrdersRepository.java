package org.ait.project.aitboilerplate.modules.order.model.repository;

import org.ait.project.aitboilerplate.modules.order.model.entity.Orders;
import org.ait.project.aitboilerplate.modules.order.model.entity.OrdersDetil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    Optional<Orders> findByTransactionCode(String transactionCode);
}
