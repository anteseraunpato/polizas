package com.example.login_rest.service;

import com.example.login_rest.model.Capitulos;
import com.example.login_rest.repository.CapitulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitulosService {
    @Autowired
    private CapitulosRepository capitulosRepository;

    public void crearCapitulo(String denominacion, int numCap) {
        try {
            // Crear y guardar el capítulo en la base de datos
            Capitulos capitulos = new Capitulos();
            capitulos.setDenominacion(denominacion);
            capitulos.setNumeroCap(numCap);
            capitulosRepository.save(capitulos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo para obtener todas las facturas
    public List<Capitulos> obtenerTodosLosCapitulos() {
        return capitulosRepository.findAll();
    }

}
