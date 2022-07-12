package com.cursosdedesarrollo.demoapp.controllers;

import com.cursosdedesarrollo.demoapp.dtos.Dato;
import com.cursosdedesarrollo.demoapp.entities.Alumno;
import com.cursosdedesarrollo.demoapp.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class ControladorAccesoServicio {
    @Autowired
    private AlumnoService alumnoService;
    // GET / Listado
    @GetMapping("/")
    public List<Alumno> getList(){
        return this.alumnoService.findAll();
    }

    // Post Body(dato) / Create
    @PostMapping("/")
    // @RequestMapping(value = "/dato/",method = RequestMethod.POST)
    public Alumno addDato(@Valid @RequestBody Alumno alumno)
            throws ServletException, IOException {
        alumno = this.alumnoService.save(alumno);
        return alumno;
    }

    // Get /{id} - Read
    @GetMapping("/{id}")
    public Alumno showDatoById(@PathVariable Long id)
            throws ServletException, IOException {
        Alumno alumno = this.alumnoService.findById(id);
        return alumno;
    }
    // Post  /{id} Modifica todo
    // Put   /{id} Modifica todo
    // Patch /{id} Modifica parcialmente
    @PostMapping("/{id}")
    public Alumno editDatoById(
            @PathVariable Long id,
            @Valid @RequestBody Alumno alumno)
            throws ServletException, IOException {
        // coger de la bbdd el objeto por su (id)
        Alumno alumnoGuardado = this.alumnoService.findById(id);
        //modificar el objeto
        alumnoGuardado.setNombre(alumno.getNombre());
        alumnoGuardado.setEdad(alumno.getEdad());
        //guardar el objeto
        this.alumnoService.save(alumnoGuardado);
        //devolver el objeto
        return alumnoGuardado;
    }

    // Get /{id}/delete Borrado
    // Delete /{id} Borrado
    @DeleteMapping("/{id}")
    public Alumno deleteDatoById(@PathVariable Long id)
            throws ServletException, IOException {
        Alumno alumno = this.alumnoService.findById(id);
        this.alumnoService.delete(alumno);

        return alumno;
    }

}
