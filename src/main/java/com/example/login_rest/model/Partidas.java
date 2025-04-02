package com.example.login_rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Partidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numeroPartida;
    private String denominacion;

    @ManyToOne
    @JoinColumn(name="capitulo_id")
    private Capitulos capitulos;
}
