package com.example.login_rest.service;

import com.example.login_rest.model.Partidas;
import com.example.login_rest.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidasService {

    @Autowired
    private PartidasRepository partidasRepository;

    //metodo para obtener todas las partida
    public List<Partidas> obtenerTodasLasPartidas() {
        return partidasRepository.findAll();
    }
}
