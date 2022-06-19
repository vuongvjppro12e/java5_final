package com.example.Assignment_Java5.service.iplm;

import com.example.Assignment_Java5.entitys.OrderDetail;
import com.example.Assignment_Java5.repository.IOrderDetailRepository;
import com.example.Assignment_Java5.service.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    private IOrderDetailRepository repository;

    @Override
    public List<OrderDetail> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<OrderDetail> findPageAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OrderDetail insert(OrderDetail orderDetail) {
        orderDetail.setId(null);
        return repository.save(orderDetail);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        return null;
    }

    @Override
    public OrderDetail delete(Integer id) {
        if (id != null) {
            Optional<OrderDetail> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public OrderDetail findById(Integer id) {
        return repository.findById(id).get();
    }
}
