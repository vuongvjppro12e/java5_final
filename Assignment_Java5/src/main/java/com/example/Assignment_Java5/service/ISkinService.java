package com.example.Assignment_Java5.service;

import com.example.Assignment_Java5.entitys.Skin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISkinService {
public List<Skin> getAll();
public Page<Skin> findPageAll(Pageable pageable);
public Skin insert(Skin skin);
public Skin update(Skin skin);
public Skin delete(Integer id);
public Skin findById(Integer id);
List<Skin> findAllByName(String name);
}
