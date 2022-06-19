package edu.poly.sj5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.sj5.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
