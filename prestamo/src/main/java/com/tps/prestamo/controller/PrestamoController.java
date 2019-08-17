package com.tps.prestamo.controller;
import com.tps.prestamo.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.tps.prestamo.models.Prestamo; 


@Controller
@RequestMapping(path = "/borrow")
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public PrestamoController(PrestamoRepository prestamoRepository){
        this.prestamoRepository = prestamoRepository;
    }

    @PostMapping(path= "/prestamo")
    public @ResponseBody String addNewPrestamo(@RequestBody Prestamo prestamo){
        Long id_prest = prestamo.getIdPrestamista();
        Long id_sol = prestamo.getIdSolicitante();
        if (id_prest.equals(id_sol)){
            return "ID de solicitante y prestamista son iguales";
        }
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