package com.example.login_rest.controllers;

import com.example.login_rest.model.Factura;
import com.example.login_rest.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/")
    public String index(Model model) {
        // Obtener todas las facturas de la base de datos
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        // Pasar la lista de facturas a la vista
        model.addAttribute("facturas", facturas);
        return "subir-factura";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                facturaService.procesarFacturaXML(file.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/"; // Redirigir a la página principal después de subir el archivo
    }

    @GetMapping("/subir-factura")
    public String subirFactura(Model model) {
        // Obtener todas las facturas de la base de datos
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        // Pasar la lista de facturas a la vista
        model.addAttribute("facturas", facturas);
        return "subir-factura"; // Asegura que la vista tenga los datos
    }

    @PostMapping("/delete/{id}")
    public String eliminarFactura(@PathVariable int id) {
        facturaService.eliminarPorId(id); // Asegúrate de tener un método en tu servicio para eliminar por ID.
        return "redirect:/facturasguardadas"; // Redirige de nuevo a la página principal.
    }

    @GetMapping("/generar-polizas")
    public String generarPolizas() {
        return "generar-polizas"; // Asegúrate de que este archivo exista en /templates/
    }


    // Página para ver las facturas guardadas
    @GetMapping("/facturasguardadas")
    public String facturasGuardadas(Model model) {
            List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        model.addAttribute("facturas", facturas);
        return "facturasguardadas"; // Carga facturasguardadas.html
    }


}
