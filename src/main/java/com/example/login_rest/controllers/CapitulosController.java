package com.example.login_rest.controllers;

import com.example.login_rest.model.Capitulos;
import com.example.login_rest.service.CapitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CapitulosController {

    @Autowired
    private CapitulosService capitulosService;

    @GetMapping("/crear-capitulo")
    public String listaCapitulos(Model model) {
        List<Capitulos> capitulos = capitulosService.obtenerTodosLosCapitulos();
        model.addAttribute("capitulos",capitulos);
        return "crear-capitulo";
    }

    //TODO Recibir la informacion del formulario en los parametros de entrada de la funcion generarCapitulos

    @PostMapping("/crearcapitulo")
    public String generarCapitulo(@RequestParam String denominacion, @RequestParam int numCap) {
        try {
            capitulosService.crearCapitulo(denominacion, numCap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/crear-capitulo"; // Redirigir a la página principal después de subir el archivo
    }
}
