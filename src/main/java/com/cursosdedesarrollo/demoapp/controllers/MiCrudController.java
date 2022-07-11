package com.cursosdedesarrollo.demoapp.controllers;

import com.cursosdedesarrollo.demoapp.dtos.Dato;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dato")
public class MiCrudController {

    // Get / Listado
    @GetMapping("/")
    // @RequestMapping(value = "/dato/",method = RequestMethod.GET)
    public List<Dato> showDato(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        List<Dato> listado= new ArrayList<Dato>();
        for (int i = 0; i < 10; i++) {
            Dato dato= new Dato();
            dato.setId(new Long(i));
            dato.setCadena("Mi cadena "+i);
            listado.add(dato);
        }
        return listado;
    }
    // Post Body(dato) / Create
    @PostMapping("/")
    // @RequestMapping(value = "/dato/",method = RequestMethod.POST)
    public Dato addDato(@RequestBody Dato dato)
            throws ServletException, IOException {
        dato.setId(1L);
        return dato;
    }
    // Get /{id} - Read
    @GetMapping("/{id}")
    public Dato showDatoById(@PathVariable Long id)
            throws ServletException, IOException {
        Dato dato= new Dato();
        dato.setId(id);
        dato.setCadena("Mi cadena "+id);
        return dato;
    }
    // Post  /{id} Modifica todo
    // Put   /{id} Modifica todo
    // Patch /{id} Modifica parcialmente
    @PostMapping("/{id}")
    public Dato editDatoById(
            @PathVariable Long id,
            @RequestBody Dato dato)
            throws ServletException, IOException {
        // coger de la bbdd el objeto por su (id)
        //modificar el objeto
        //guardar el objeto
        dato.setId(id);
        //devolver el objeto
        return dato;
    }
    // Get /{id}/delete Borrado
    // Delete /{id} Borrado
    @DeleteMapping("/{id}")
    public Dato deleteDatoById(@PathVariable Long id)
            throws ServletException, IOException {
        Dato dato= new Dato();
        dato.setId(id);
        dato.setCadena("Mi cadena borrada");
        return dato;
    }

    @GetMapping("/{id}/{otro}")
    public Dato showDatoByIdAndByOtro(@PathVariable("id") Long id,@PathVariable("otro") String otro )
            throws ServletException, IOException {
        Dato dato= new Dato();
        dato.setId(id);
        dato.setCadena(otro);
        return dato;
    }

    // Get /{page}/{num} Buscar Paginado
    @GetMapping("/{page}/{num}")
    // @RequestMapping(value = "/dato/",method = RequestMethod.GET)
    public List<Dato> searchDato(@PathVariable("page") Long page, @PathVariable("num") Integer num)
            throws ServletException, IOException {
        List<Dato> listado= new ArrayList<Dato>();
        for (int i = 0; i < 10; i++) {
            Dato dato= new Dato();
            dato.setId(new Long(i));
            dato.setCadena("Mi cadena "+i);
            listado.add(dato);
        }
        return listado;
    }
}
