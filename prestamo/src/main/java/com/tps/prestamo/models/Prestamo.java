package com.tps.prestamo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_solicitante;
    private Long id_prestamista;
    private Long id_bookitem;
    private Date fecha_inicio;
    private Date fecha_termino;
    

    public void setIdSolicitante( Long id_solicitante){
        this.id_solicitante = id_solicitante;   
    }
    public void setIdPrestamista (Long id_prestamista){
        this.id_prestamista = id_prestamista;
    }
    public void setIdBookItem( Long id_bookitem){
        this.id_bookitem = id_bookitem;
    }
    public void setFechaInicio (Date fecha_inicio){
        this.fecha_inicio = fecha_inicio;
    }
    public void setFechaTermino (Date fecha_termino){
        this.fecha_termino = fecha_termino;
    }

    public Long getIdSolicitante(){
        return this.id_solicitante;
    }
    public Long getIdPrestamista(){
        return this.id_prestamista;
    }
    public Long getIdBookItem(){
        return this.id_bookitem;
    }
    public Date getFechaInicio(){
        return this.fecha_inicio;
    }
    public Date getFechaTermino(){
        return this.fecha_termino;
    }
}