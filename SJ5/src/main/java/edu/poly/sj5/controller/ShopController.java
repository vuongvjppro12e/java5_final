package edu.poly.sj5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.sj5.model.Product;
import edu.poly.sj5.service.ICartService;
import edu.poly.sj5.service.IProductService;
import edu.poly.sj5.utility.CommonConst;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping
	public String getAll(Model model,
			@RequestParam(name = "pageNumber", defaultValue="0") int pageNumber) {
		Page<Product> productPage = productService
				.getByPage(pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", productPage);
		return "shop/shopping";
	}
	
	@GetMapping("/cart/{productId}")
	public String addToCart(Model model, 
			@PathVariable int productId) {
		cartService.addToCart(productId, 1);
		model.addAttribute("cartDetails", 
				cartService.getCart().getCartDetails());
		return "shop/cart";
	}
}
