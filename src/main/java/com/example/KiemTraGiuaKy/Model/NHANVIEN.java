package com.example.KiemTraGiuaKy.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class NHANVIEN {

    @Id
    @NotNull(message = "not null")
    private String id;

    @NotNull(message = "not null")
    private String tenNV;

    private String phai;

    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "phongban_id")
    private PHONGBAN phongban;

    private int Luong;
}
