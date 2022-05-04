package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.ItemFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFeedbackRepository extends JpaRepository<ItemFeedback, Integer> {

}