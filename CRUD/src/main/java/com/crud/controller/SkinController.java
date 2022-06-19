package com.crud.controller;

import com.crud.entity.Skin;
import com.crud.entity.Type;
import com.crud.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class SkinController {
    @Autowired
    IProductRepository repository;

    @Autowired
    HttpServletRequest request;


    @ResponseBody
    @PostMapping("/skin")
    public ResponseEntity<Skin> create(@Validated @RequestBody Skin skin) {
//        Product p = new Product();
//        p.setName("thu3");
//        p.setPrice(BigDecimal.valueOf(10000));
//        return repository.save(p);
        return ResponseEntity.ok(repository.save(skin));
    }


    @ResponseBody
    @PutMapping("/skin/{id}")
    public ResponseEntity update(@Validated @RequestBody Skin skin, @PathVariable Integer id) {

        List<Skin> p = repository.findAllById(id);
        p.get(0).setName(skin.getName());
        p.get(0).setType(Type.valueOf(String.valueOf(skin.getType())));
        p.get(0).setPrice(skin.getPrice());
        p.get(0).setBuff(skin.getBuff());
        p.get(0).setRare(skin.getRare());

//        p.get(0).setId(id);
//        p.get(0).setName("Update");
//        p.get(0).setPrice(BigDecimal.valueOf(3000));
//        return repository.save(p.get(0));

        return ResponseEntity.ok(repository.save(p.get(0)));
    }

    @ResponseBody
    @DeleteMapping("/skin/{id}")
    public String delete(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Xóa thành công sản phẩm " + id;
    }


    @ResponseBody
    @GetMapping("/skin/{id}")
    public Optional<Skin> selectOne(@PathVariable("id") Integer id) {
        System.out.println(id);
        Optional<Skin> p = repository.findById(id);
        return p;
    }

    @ResponseBody
    @GetMapping("/skin")
    public List<Skin> selectByType(@RequestParam(name = "type", required = false) Type type, @RequestParam(name = "name", required = false) String name) {
        System.out.println("OK");
        if (type != null) {
            return repository.findAllByType(type);
        } else if (name != null) {
            return repository.findProductByNameLike("%" + name + "%");
        } else {
            return repository.findAll();
        }
    }
}
