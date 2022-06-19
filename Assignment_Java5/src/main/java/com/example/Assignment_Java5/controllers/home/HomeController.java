package com.example.Assignment_Java5.controllers.home;

import com.example.Assignment_Java5.service.ITypeService;
import com.example.Assignment_Java5.service.ISkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    ServletContext app;

    @Autowired
    private ISkinService productDao;

    @Autowired
    private ITypeService categoryDao;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        model.addAttribute("listCate",categoryDao.getAll());
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("show",productDao.findPageAll(pageable));
        request.setAttribute("views", "/views/home/home.jsp");
        return "home/layout";
    }
//    @GetMapping("/showNro")
//    public String show(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page,@RequestParam(name = "id") Integer id) {
//        Pageable pageable = PageRequest.of(page.orElse(0), 5);
//        model.addAttribute("listItems", itemsDao.findItemsByCate(id,pageable));
//        request.setAttribute("view", "/views/home/items.jsp");
//        return "home/layout";
//    }
}
