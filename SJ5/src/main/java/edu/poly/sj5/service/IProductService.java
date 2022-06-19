package edu.poly.sj5.service;

import org.springframework.data.domain.Page;

import edu.poly.sj5.model.Product;

public interface IProductService {

	Page<Product> getByPage(int pageNumber, int maxRecord);
}
