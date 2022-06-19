package com.example.Assignment_Java5.repository;

import com.example.Assignment_Java5.entitys.Skin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISkinRepository extends JpaRepository<Skin,Integer> {
    List<Skin> findAllByName(String name);
    @Query("Select obj from Skin obj")
    Page<Skin> findAllProduct (Pageable pageable);
}
