package com.example.login_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uuid; // UUID del CFDI
    private String numeroPoliza;
    private Date fecha;
    private String nombreEmpresa;
    private String rfc;
    private String partida;
    private String cap;
    private String denominacion;
    private String observaciones;
    private Double cargo;

    }