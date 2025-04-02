package com.example.login_rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Capitulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numeroCap;
    private String denominacion;

    @OneToMany
    private List<Partidas> partidas;
}
