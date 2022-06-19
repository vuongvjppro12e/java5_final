package com.crud.repository;

import com.crud.entity.Skin;
import com.crud.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Skin,Integer> {
    List<Skin> findAllById(Integer id);
    @Query("select p from Skin p where p.name like ?1")
    List<Skin> findProductByNameLike(String name);
    List<Skin> findAllByType(Type type);
    @Query("select p from Skin p where p.id = ?1")
    Optional<Skin> findById(Integer id);
}
