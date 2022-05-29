package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByEmail(String email);

  List<User> findUsersByRole(String role);

  Optional<User> findUserByRoleAndId(String role, Integer id);
}