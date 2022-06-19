package com.example.Assignment_Java5.service.iplm;

import com.example.Assignment_Java5.entitys.type;
import com.example.Assignment_Java5.repository.ITypeRepository;
import com.example.Assignment_Java5.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository repository;

    @Override
    public List<type> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<type> findPageAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public type insert(type category) {
        category.setId(null);
        return repository.save(category);
    }

    @Override
    public type update(type category) {
        Integer id = category.getId();
        if (id != null) {
            Optional<type> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(category);
            }
        }
        return null;
    }

    @Override
    public type delete(Integer id) {
        if (id != null) {
            Optional<type> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public type findById(Integer id) {
        return repository.findById(id).get();
    }
}
