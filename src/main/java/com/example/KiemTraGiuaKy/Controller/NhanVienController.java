package com.example.KiemTraGiuaKy.Controller;

import com.example.KiemTraGiuaKy.Model.NHANVIEN;
import com.example.KiemTraGiuaKy.Sevices.NhanVienService;
import com.example.KiemTraGiuaKy.Sevices.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;


    @GetMapping
    public String showALlNhanVien(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<NHANVIEN> nhanvienPage = nhanVienService.getAllNhanVien(pageable);

        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        model.addAttribute("nhanviens", nhanvienPage.getContent());
        model.addAttribute("totalPages", nhanvienPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "/nhanviens/nhanvien-list";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new NHANVIEN());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan()); //Load categories
        return "/nhanviens/add-nhanvien";
    }
    // Process the form for adding a new product
    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public String addProduct(@Valid NHANVIEN product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/products/add-product";
        }
        nhanVienService.addProduct(product);
        return "redirect:/nhanviens";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        NHANVIEN product = nhanVienService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productId:" + id));
        model.addAttribute("product", product);
        model.addAttribute("phongbans", phongBanService.getAllPhongBan()); // Load categories
        return "/nhanviens/edit-nhanvien";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable String id, @Valid NHANVIEN product,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "/nhanviens/edit-nhanvien";
        }
            NHANVIEN pr = nhanVienService.getProductById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid productId:" + id));
            nhanVienService.updateProduct(product);
        return "redirect:/nhanviens";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {

        nhanVienService.deleteProductById(id);

        return "redirect:/nhanviens";
    }

}
