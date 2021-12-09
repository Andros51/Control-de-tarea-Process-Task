/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



public class Usuario {
    
    String id_usuario;
    String nombre;
    String ape_paterno;
    String ape_materno;
    String fecha_nacimiento;
    String correo;
    String contraseña;
    String id_superior;
    String id_unidad;
    String id_empresa;
    int id_rol;

    public Usuario() {
    }

    public Usuario(String id_usuario, String nombre, String ape_paterno, String ape_materno, String fecha_nacimiento, String correo, String contraseña, String id_superior, String id_unidad, String id_empresa, int id_rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contraseña = contraseña;
        this.id_superior = id_superior;
        this.id_unidad = id_unidad;
        this.id_empresa = id_empresa;
        this.id_rol = id_rol;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getId_superior() {
        return id_superior;
    }

    public void setId_superior(String id_superior) {
        this.id_superior = id_superior;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

   

    
    
   
}
