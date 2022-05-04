package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.VisitFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitFeedbackRepository extends JpaRepository<VisitFeedback, Integer> {

}