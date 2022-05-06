package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
  @Query(value = "select avg(i.rating) from item_feedbacks as i where i.id = ?1", nativeQuery = true)
  Double averageRating(Integer id);
}