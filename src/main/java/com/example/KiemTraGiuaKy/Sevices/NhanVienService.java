package com.example.KiemTraGiuaKy.Sevices;

import com.example.KiemTraGiuaKy.Model.NHANVIEN;
import com.example.KiemTraGiuaKy.Repository.NhanVienRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhanVienService {
private final NhanVienRepository nhanVienRepository;

    public Page<NHANVIEN> getAllNhanVien(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }
    public Optional<NHANVIEN> getProductById(String id) {
        return nhanVienRepository.findById(id);
    }
    // Add a new product to the database
    public NHANVIEN addProduct(NHANVIEN product) {
        return nhanVienRepository.save(product);
    }
    // Update an existing product
    public NHANVIEN updateProduct(@NotNull NHANVIEN product) {
        NHANVIEN existingProduct = nhanVienRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " + product.getId() + " does not exist."));
        existingProduct.setTenNV(product.getTenNV());
        existingProduct.setPhai(product.getPhai());
        existingProduct.setNoiSinh(product.getNoiSinh());
        existingProduct.setPhongban(product.getPhongban());
        existingProduct.setLuong(product.getLuong());
        return nhanVienRepository.save(existingProduct);
    }
    // Delete a product by its id
    public void deleteProductById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        nhanVienRepository.deleteById(id);
    }
}
