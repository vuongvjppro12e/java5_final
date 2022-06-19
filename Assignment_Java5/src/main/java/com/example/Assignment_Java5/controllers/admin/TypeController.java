package com.example.Assignment_Java5.controllers.admin;

import com.example.Assignment_Java5.entitys.type;
import com.example.Assignment_Java5.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/admin/type")
public class TypeController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private ITypeService typeDao;

    @GetMapping("/index")
    public String index(@ModelAttribute("type") type category, Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("list", typeDao.findPageAll(pageable));
        request.setAttribute("views", "/views/admin/type.jsp");
        return "home/layout";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("category") type category) {
        try {
//            category.setStatus(1);
            this.typeDao.insert(category);
            session.setAttribute("message", "Thêm Mới Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }
        return "redirect:/admin/type/index";
    }

//    @GetMapping("/edit")
//    public String edit(@RequestParam(name = "id") Integer id, Model model, @ModelAttribute("category") type category, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
//        model.addAttribute("type", categoryDao.findById(id));
//        Pageable pageable = PageRequest.of(page.orElse(0), 5);
//        request.setAttribute("list", categoryDao.findPageAll(pageable));
//        return "/admin/type";
//    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute("category") type category, @RequestParam(name = "id") Integer id) {
//        try {
//            type cate=this.categoryDao.findById(id);
////            category.setStatus(cate.getStatus());
//            this.categoryDao.update(category);
//            session.setAttribute("message", "Cập Nhật Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.setAttribute("error", "Cập Nhật Thất Bại");
//        }
//        return "redirect:/admin/type/index";
//    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("category") type category, @RequestParam(name = "id") Integer id) {
        try {
            this.typeDao.delete(id);
            session.setAttribute("message", "Xóa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
        }
        return "redirect:/admin/type/index";
    }
}
