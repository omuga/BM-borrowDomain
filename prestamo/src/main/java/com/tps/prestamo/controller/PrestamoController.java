package com.tps.prestamo.controller;
import com.tps.prestamo.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.tps.prestamo.models.Prestamo; 
import java.sql.Date;


@Controller
@RequestMapping(path = "/borrow")
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping(path= "/add")
    public @ResponseBody String addNewPrestamo(@RequestParam Long id_solicitante,
    @RequestParam Long id_prestamista,@RequestParam Long id_bookitem,  @RequestParam Date fecha_inicio, @RequestParam Date fecha_termino){
        if (id_prestamista.equals(id_solicitante)){
            return "Error, id solicitante e id de prestamista son identicas";
        }
        Prestamo prestamo = new Prestamo();
        prestamo.setIdPrestamista(id_prestamista);
        prestamo.setIdSolicitante(id_solicitante);
        prestamo.setIdBookItem(id_bookitem);
        prestamo.setFechaInicio(fecha_inicio);
        prestamo.setFechaTermino(fecha_termino);
        prestamoRepository.save(prestamo);
        return "Prestamo Almacenado";
    }

    @GetMapping(path = "/prestamo/{id}")
    public @RequestMapping Optional<Prestamo> GetPrestamoById(@RequestParam("id") Long id){
        return prestamoRepository.findById(id);
    }
    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Prestamo> GetAllPrestamos(){
        return prestamoRepository.findAll();
    }

    

}