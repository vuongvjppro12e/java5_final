package com.example.Assignment_Java5.service;

import com.example.Assignment_Java5.entitys.type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeService {
    public List<type> getAll();
    public Page<type> findPageAll(Pageable pageable);
    public type insert(type category);
    public type update(type category);
    public type delete(Integer id);
    public type findById(Integer id);
}
