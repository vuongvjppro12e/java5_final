package com.example.giaodien.service;

import com.example.giaodien.entity.Product;
import com.example.giaodien.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private IProductRepository repository;

    public ProductService(IProductRepository repository){
        this.repository = repository;
    }
    public List<Product>getAll(){
        return repository.findAll();
    }
    public Product add(Product Product){
        Product.setId(null);
        return repository.save(Product);
    }
    public Product update(Product Product){
        Integer id = Product.getId();
        if(id!=null){
            Optional<Product> p = repository.findById(id);
            if(p.isPresent()){
                repository.save(Product);
                return repository.save(Product);
            }
        }
        return repository.save(Product);
    }
    public Product delete(Integer id){
        if(id!=null){
            Optional<Product> p = repository.findById(id);
            if(p.isPresent()){
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }
}
