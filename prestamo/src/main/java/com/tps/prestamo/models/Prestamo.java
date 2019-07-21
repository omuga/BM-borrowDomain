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
    private Integer id;
    private Integer id_solicitante;
    private Integer id_prestamista;
    private Integer id_bookitem;
    private Date fecha_inicio;
    private Date fecha_termino;
    

    public void setIdSolicitante( Integer id_solicitante){
        this.id_solicitante = id_solicitante;   
    }
    public void setIdPrestamista (Integer id_prestamista){
        this.id_prestamista = id_prestamista;
    }
    public void setIdBookItem( Integer id_bookitem){
        this.id_bookitem = id_bookitem;
    }
    public void setFechaInicio (Date fecha_inicio){
        this.fecha_inicio = fecha_inicio;
    }
    public void setFechaTermino (Date fecha_termino){
        this.fecha_termino = fecha_termino;
    }

    public Integer getIdSolicitante(){
        return this.id_solicitante;
    }
    public Integer getIdPrestamista(){
        return this.id_prestamista;
    }
    public Integer getIdBookItem(){
        return this.id_bookitem;
    }
    public Date getFechaInicio(){
        return this.fecha_inicio;
    }
    public Date getFechaTermino(){
        return this.fecha_termino;
    }
}