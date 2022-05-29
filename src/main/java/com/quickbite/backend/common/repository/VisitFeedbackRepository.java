package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.entity.VisitFeedback;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitFeedbackRepository extends JpaRepository<VisitFeedback, Integer> {
  Optional<VisitFeedback> findVisitFeedbackByUserAndId(User user, Integer id);
}