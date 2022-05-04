package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {

}