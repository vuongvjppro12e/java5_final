package edu.poly.sj5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.sj5.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
