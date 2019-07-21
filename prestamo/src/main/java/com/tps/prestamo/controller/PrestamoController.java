package com.tps.prestamo.controller;
import com.tps.prestamo.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tps.prestamo.models.Prestamo; 
import java.sql.*;

@Controller
@RequestMapping(path = "/borrow")
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping(path= "/add")
    public @ResponseBody String addNewPrestamo(@RequestParam Integer id_solicitante,
    @RequestParam Integer id_prestamista,@RequestParam Integer id_bookitem,  @RequestParam Date fecha_inicio, @RequestParam Date fecha_termino){
        Prestamo prestamo = new Prestamo();
        prestamo.setIdPrestamista(id_prestamista);
        prestamo.setIdSolicitante(id_solicitante);
        prestamo.setIdBookItem(id_bookitem);
        prestamo.setFechaInicio(fecha_inicio);
        prestamo.setFechaTermino(fecha_termino);
        prestamoRepository.save(prestamo);
        return "Prestamo Almacenado";
    }

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Prestamo> GetAllPrestamos(){
        return prestamoRepository.findAll();
    }
}