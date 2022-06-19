package com.example.giaodien.controller;

import com.example.giaodien.entity.Product;
import com.example.giaodien.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String getAll(ModelMap modelMap){
        List<Product> Products = service.getAll();
        modelMap.addAttribute("products",Products);
        return "product-list";
    }

    public String add(ModelMap modelMap, Product product){
        Product result = service.add(product);
        if (result==null){
            return "error";
        }else {
            return "product-detail";
        }
    }
    @RequestMapping("/new")
    String newProduct(){
        return ("product-new");
    }
//    @RequestMapping("/detail")
//    public String showProduct(Entity entity){
//        @RequestParam("name") String name,
//        @RequestParam("price") BigDecimal price,
//
//                return"product-detail";
//    }
}
