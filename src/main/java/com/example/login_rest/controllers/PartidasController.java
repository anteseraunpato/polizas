package com.example.login_rest.controllers;

import com.example.login_rest.model.Partidas;
import com.example.login_rest.service.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PartidasController {
    @Autowired
    private PartidasService partidasService;

    // Página para ver las partidas guardadas
    @GetMapping("/lista-partidas")
    public String listaPartidas(Model model) {
        List<Partidas> partidas = partidasService.obtenerTodasLasPartidas();
        model.addAttribute("partidas", partidas);
        return "lista-partidas"; // Carga lista-partidas.html
    }
}
