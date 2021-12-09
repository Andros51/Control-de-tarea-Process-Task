/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class UsuarioDAO implements Validar {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public int validar(Usuario usr) {
        int r = 0;
        String sql = "Select * from USUARIO where ID_USUARIO=? and CONTRASENNA=?";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getId_usuario());
            ps.setString(2, usr.getContraseña());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                usr.setId_usuario(rs.getString("ID_USUARIO"));
                usr.setNombre(rs.getString("NOMBRE"));
                usr.setApe_paterno(rs.getString("APELLIDO_PATERNO"));
                usr.setApe_materno(rs.getString("APELLIDO_MATERNO"));
                usr.setFecha_nacimiento(rs.getString("FECHA_NACIMIENTO"));
                usr.setCorreo(rs.getString("CORREO"));
                usr.setContraseña(rs.getString("CONTRASENNA"));
                usr.setId_superior(rs.getString("ID_SUPERIOR"));
                usr.setId_unidad(rs.getString("ID_UNIDAD"));
                usr.setId_empresa(rs.getString("ID_EMPRESA"));
                usr.setId_rol(rs.getInt("ID_ROL"));

            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }

    }

    public List listarUS(String idE) {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select u.id_usuario, u.nombre, u.apellido_paterno, u.apellido_materno,TO_CHAR(u.fecha_nacimiento,'DD-MM-YYYY'), u.correo,uni.nombre unidad , u.id_superior from usuario U JOIN Unidades uni on u.id_unidad = uni.id_unidad where u.id_empresa='"+idE+"'";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getString(1));
                u.setNombre(rs.getString(2));
                u.setApe_paterno(rs.getString(3));
                u.setApe_materno(rs.getString(4));
                u.setFecha_nacimiento(rs.getString(5));
                u.setCorreo(rs.getString(6));
                u.setId_unidad(rs.getString(7));
                u.setId_superior(rs.getString(8));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

   

   
}
