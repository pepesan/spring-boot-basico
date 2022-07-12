package com.cursosdedesarrollo.demoapp.services;

import com.cursosdedesarrollo.demoapp.entities.Alumno;
import com.cursosdedesarrollo.demoapp.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalUnit;
import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return this.alumnoRepository.findAll();
        //this.alumnoRepository.findById();
        //this.alumnoRepository.save(objeto);
        //this.alumnoRepository.delete(objeto);
    }
}
