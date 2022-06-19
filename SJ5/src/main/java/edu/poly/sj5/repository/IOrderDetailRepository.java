package edu.poly.sj5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.sj5.model.OrderDetail;
import edu.poly.sj5.model.OrderDetailId;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
