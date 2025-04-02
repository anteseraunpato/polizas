package com.example.login_rest.controllers;

import com.example.login_rest.model.Factura;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TemplateDashboardController {


    // Ruta para Inicio
    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    // Ruta para Subir Factura

    // Ruta para Generar
    @GetMapping("/generar")
    public String generar() {
        return "generar";
    }

    // Ruta para Pólizas
    @GetMapping("/polizas")
    public String polizas() {
        return "polizas";
    }

}
