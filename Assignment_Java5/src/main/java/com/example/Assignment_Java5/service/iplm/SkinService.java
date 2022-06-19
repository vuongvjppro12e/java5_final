package com.example.Assignment_Java5.service.iplm;

import com.example.Assignment_Java5.entitys.Skin;
import com.example.Assignment_Java5.repository.ISkinRepository;
import com.example.Assignment_Java5.service.ISkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkinService implements ISkinService {
    @Autowired
    private ISkinRepository repository;

    @Override
    public List<Skin> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Skin> findPageAll(Pageable pageable) {
        return repository.findAllProduct(pageable);
    }

    @Override
    public Skin insert(Skin skin) {
        skin.setId(null);
        return repository.save(skin);
    }

    @Override
    public Skin update(Skin skin) {
        Integer id = skin.getId();
        if (id != null) {
            Optional<Skin> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(skin);
            }
        }
        return null;
    }

    @Override
    public Skin delete(Integer id) {
        if (id != null) {
            Optional<Skin> p = repository.findById(id);
            if (p.isPresent()) {
                repository.delete(p.get());
                return p.get();
            }
        }
        return null;
    }

    @Override
    public Skin findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Skin> findAllByName(String name) {
        return repository.findAllByName(name);
    }
}
