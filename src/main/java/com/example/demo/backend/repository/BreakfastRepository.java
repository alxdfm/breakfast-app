package com.example.demo.backend.repository;

import com.example.demo.backend.entity.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast,Long> {

}
