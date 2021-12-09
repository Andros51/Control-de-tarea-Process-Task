/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Tarea {

    int id_tarea;
    String fecha_inicio;
    String fecha_termino;
    int estado_tarea;//1-0
    int porcentaje_avance;
    int aceptacion;//1-0
    String justificacion;
    String reporte;
    String id_desenador;
    int id_p_tarea;
    int id_proceso;
    String id_usuario;
    int id_p_proceso;
    int id_unidad;
    String id_empresa;
    String descripcion;

    public Tarea() {
    }

    public Tarea(int id_tarea, String fecha_inicio, String fecha_termino, int estado_tarea, int porcentaje_avance, int aceptacion, String justificacion, String reporte, String id_desenador, int id_p_tarea, int id_proceso, String id_usuario, int id_p_proceso, int id_unidad, String id_empresa, String descripcion) {
        this.id_tarea = id_tarea;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.estado_tarea = estado_tarea;
        this.porcentaje_avance = porcentaje_avance;
        this.aceptacion = aceptacion;
        this.justificacion = justificacion;
        this.reporte = reporte;
        this.id_desenador = id_desenador;
        this.id_p_tarea = id_p_tarea;
        this.id_proceso = id_proceso;
        this.id_usuario = id_usuario;
        this.id_p_proceso = id_p_proceso;
        this.id_unidad = id_unidad;
        this.id_empresa = id_empresa;
        this.descripcion = descripcion;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public int getEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(int estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public int getPorcentaje_avance() {
        return porcentaje_avance;
    }

    public void setPorcentaje_avance(int porcentaje_avance) {
        this.porcentaje_avance = porcentaje_avance;
    }

    public int getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(int aceptacion) {
        this.aceptacion = aceptacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getId_desenador() {
        return id_desenador;
    }

    public void setId_desenador(String id_desenador) {
        this.id_desenador = id_desenador;
    }

    public int getId_p_tarea() {
        return id_p_tarea;
    }

    public void setId_p_tarea(int id_p_tarea) {
        this.id_p_tarea = id_p_tarea;
    }

    public int getId_proceso() {
        return id_proceso;
    }

    public void setId_proceso(int id_proceso) {
        this.id_proceso = id_proceso;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_p_proceso() {
        return id_p_proceso;
    }

    public void setId_p_proceso(int id_p_proceso) {
        this.id_p_proceso = id_p_proceso;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
