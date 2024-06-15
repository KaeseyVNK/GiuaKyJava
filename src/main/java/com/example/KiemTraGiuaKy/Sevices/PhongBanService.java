package com.example.KiemTraGiuaKy.Sevices;


import com.example.KiemTraGiuaKy.Model.NHANVIEN;
import com.example.KiemTraGiuaKy.Model.PHONGBAN;
import com.example.KiemTraGiuaKy.Repository.PhongBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhongBanService {

    public final PhongBanRepository phongBanRepository;

    public List<PHONGBAN> getAllPhongBan()
    {
        return phongBanRepository.findAll();
    }
}
