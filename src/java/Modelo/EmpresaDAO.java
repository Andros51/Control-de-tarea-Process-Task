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
public class EmpresaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List Empresas() {
        List<Empresa> lista = new ArrayList<>();
        String sql = "select * from empresa";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empresa em = new Empresa();
                em.setId_empresa(rs.getString(1));
                em.setRazon_social(rs.getString(2));
                em.setFono_contacto(rs.getString(3));
                em.setCorreo(rs.getString(4));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
