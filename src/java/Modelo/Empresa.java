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
public class Empresa {
    String id_empresa;
    String razon_social;
    String fono_contacto;
    String correo;

    public Empresa() {
    }

    public Empresa(String id_empresa, String razon_social, String fono_contacto, String correo) {
        this.id_empresa = id_empresa;
        this.razon_social = razon_social;
        this.fono_contacto = fono_contacto;
        this.correo = correo;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getFono_contacto() {
        return fono_contacto;
    }

    public void setFono_contacto(String fono_contacto) {
        this.fono_contacto = fono_contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
