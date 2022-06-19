package edu.poly.sj5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.sj5.model.Product;
import edu.poly.sj5.repository.IProductRepository;
import edu.poly.sj5.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	public Page<Product> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Product> page = productRepository.findAll(pageable);
		return page;
	}
}


