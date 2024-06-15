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
@Table(name = "PHONGBAN")

public class PHONGBAN {

    @Id
    @NotNull(message = "not null")
    private String id;


    @NotNull(message = "not null")
    private String tenP;
}
