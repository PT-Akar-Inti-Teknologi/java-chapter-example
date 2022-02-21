package org.ait.project.aitboilerplate.modules.item.model.repository;

import org.ait.project.aitboilerplate.modules.item.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findByCode(String code);
}
