package org.ait.project.aitboilerplate.modules.customer.model.jpa.repository;

import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
