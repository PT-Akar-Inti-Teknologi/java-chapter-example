package org.ait.project.aitboilerplate.modules.customer.model.jpa.repository;

import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUsernameOrDetilEmail(String username, String email);
}
