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
public class MiController {
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
    @GetMapping("/dato/")
    // @RequestMapping(value = "/dato/",method = RequestMethod.GET)
    public List<Dato> showDato(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        List<Dato> listado= new ArrayList<Dato>();
        for (int i = 0; i < 10; i++) {
            Dato dato= new Dato();
            dato.setCadena("Mi cadena "+i);
            listado.add(dato);
        }
        return listado;
    }
    @PostMapping("/dato/")
    // @RequestMapping(value = "/dato/",method = RequestMethod.POST)
    public Dato addDato(@RequestBody Dato dato)
            throws ServletException, IOException {
        return dato;
    }


}
