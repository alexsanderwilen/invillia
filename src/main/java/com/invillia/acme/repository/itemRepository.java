package com.invillia.acme.repository;

import com.invillia.acme.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends JpaRepository<Item, Long> {
}
