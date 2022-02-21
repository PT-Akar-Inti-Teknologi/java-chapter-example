package org.ait.project.aitboilerplate.modules.customer.model.jpa.repository;

import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.CustomerDetil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDetilRepository extends JpaRepository<CustomerDetil,Long> {
    Optional<Object> findByCustomerUsernameOrEmail(String username, String email);
}
