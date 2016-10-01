package com.multimedios.proyecto.certamen2_2016;

/**
 * Created by nicolas on 30-09-2016.
 */
public class Repos {
    // Atributos
    private String titulo;
    private String descripcion;
    private String fecha_actualizacion;

    public Repos() {
        this.titulo = "titulo de prueba";
        this.descripcion = "descripcion de prueba";
        this.fecha_actualizacion = "01/01/2016";
    }

    public Repos(String titulo, String descripcion, String fecha_actualizacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_actualizacion(){
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion){
        this.fecha_actualizacion = fecha_actualizacion;
    }
}