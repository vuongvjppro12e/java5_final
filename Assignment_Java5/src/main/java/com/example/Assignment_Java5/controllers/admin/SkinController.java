package com.example.Assignment_Java5.controllers.admin;

import com.example.Assignment_Java5.entitys.Skin;
import com.example.Assignment_Java5.service.ITypeService;
import com.example.Assignment_Java5.service.ISkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/admin/skin")
public class SkinController {
    @Autowired
    ServletContext app;

    @Autowired
    private ISkinService dao;

    @Autowired
    private ITypeService TypeDao;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @GetMapping("/index")
    public String index(@ModelAttribute("skin") Skin skin, Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("list", dao.findPageAll(pageable));
        model.addAttribute("listCate",TypeDao.getAll());
        request.setAttribute("views", "/views/admin/form.jsp");
        return "home/layout";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("product") Skin skin, @RequestParam("attach") MultipartFile attach) {
        try {
            skin.setCreatedDate(new Date());
//            product.setAvailable(1);
            if (!attach.isEmpty()) {
                String filename = attach.getOriginalFilename();
                File file = new File(app.getRealPath("/images/skins/" + filename));
                skin.setImage("/images/skins/" + filename);
                try {
                    attach.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.dao.insert(skin);
            session.setAttribute("message", "Thêm Mới Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }
        return "redirect:/admin/skin/index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Integer id, Model model, @ModelAttribute("skin") Skin skin, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        model.addAttribute("pro", dao.findById(id));
        model.addAttribute("listCate",TypeDao.getAll());
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        request.setAttribute("list", dao.findPageAll(pageable));
        request.setAttribute("views", "/views/admin/form.jsp");
        return "home/layout";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("skin") Skin skin, @RequestParam(name = "id") Integer id, @RequestParam("attach") MultipartFile attach) {
        try {
            Skin p = dao.findById(id);
            skin.setCreatedDate(p.getCreatedDate());
//            product.setAvailable(p.getAvailable());
            if (!attach.isEmpty()) {
                String filename = attach.getOriginalFilename();
                File file = new File(app.getRealPath("/images/skins/" + filename));
                skin.setImage("/images/skins/" + filename);
                try {
                    attach.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                skin.setImage(p.getImage());
            }
            this.dao.update(skin);
            session.setAttribute("message", "Cập Nhật Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
        }
        return "redirect:/admin/skin/index";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") Skin skin, @RequestParam(name = "id") Integer id) {
        try {
            this.dao.delete(id);
            session.setAttribute("message", "Xoa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xoa Thất Bại");
        }
        return "redirect:/admin/skin/index";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("product") Skin skin, @RequestParam(name = "search") String name, @RequestParam(name = "page") Optional<Integer> page) {
            try {
                List<Skin> list = dao.findAllByName(name);
                Pageable pageable = PageRequest.of(page.orElse(0), 5);
                int start = (int) pageable.getOffset();
                int end = Math.min((start + pageable.getPageSize()), list.size());
                request.setAttribute("list", new PageImpl<>(list.subList(start, end), pageable, list.size()));
                if (new PageImpl<>(list.subList(start, end), pageable, list.size()).getTotalPages()-1<0){
                    session.setAttribute("error", "Tìm Thất Bại");
                    return "redirect:/admin/skin/index";
                }
                session.setAttribute("message", "Tìm Thành Công");
            } catch (Exception e) {
                e.printStackTrace();
                session.setAttribute("error", "Tìm Thất Bại");
                return "redirect:/admin/skin/index";
            }
        return "admin/form";
    }
}
