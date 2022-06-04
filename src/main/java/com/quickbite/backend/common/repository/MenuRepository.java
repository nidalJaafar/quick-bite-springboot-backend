package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

  boolean existsByName(String name);
}