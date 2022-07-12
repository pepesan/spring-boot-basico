package com.cursosdedesarrollo.demoapp.controllers;

import com.cursosdedesarrollo.demoapp.entities.Alumno;
import com.cursosdedesarrollo.demoapp.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorAccesoServicio {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/api/crud/list")
    public List<Alumno> getList(){
        return this.alumnoService.findAll();
    }
}
