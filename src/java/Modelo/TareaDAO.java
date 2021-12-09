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
public class TareaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List TareasR(String idE) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion,  TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY') , TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance ='100' and t.id_empresa='" + idE + "'order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasP(String idE) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance <'100' and t.porcentaje_avance >'0' and t.id_empresa='" + idE + "' and t.reporte is null order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasRE(String idE) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.justificacion ,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0'  and t.justificacion is not null and t.id_empresa='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setJustificacion(rs.getString(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasES(String idE) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion,TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0' and t.justificacion is  null and t.id_empresa='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setId_usuario(rs.getString(6));
                t.setId_desenador(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasRED(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance ='100' and t.id_empresa='" + idD + "' and t.id_disennador='" + idE + "'order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasPD(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance <'100' and t.porcentaje_avance >'0' and t.id_empresa='" + idD + "'and t.id_disennador='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasRD(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.justificacion ,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0'  and t.justificacion is not null and t.id_empresa='" + idD + "' and t.id_disennador='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setJustificacion(rs.getString(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasESD(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0' and t.justificacion is  null  and t.id_empresa='" + idD + "' and t.id_disennador='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setId_usuario(rs.getString(6));
                t.setId_desenador(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasREF(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance ='100' and t.id_empresa='" + idD + "' and t.id_usuario='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasPF(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance <'100' and t.porcentaje_avance >'0' and t.id_empresa='" + idD + "' and t.id_usuario='" + idE + "'and t.reporte is null order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasRF(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.justificacion ,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0'  and t.justificacion is not null and t.id_empresa='" + idD + "' and t.id_usuario='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setJustificacion(rs.getString(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List TareasESF(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.Aceptacion ='0' and t.justificacion is  null and t.id_empresa='" + idD + "' and t.id_usuario='" + idE + "' order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setId_usuario(rs.getString(6));
                t.setId_desenador(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List TareasPF2(String idE, String idD) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT t.id_tarea, pt.descripcion, TO_CHAR(T.FECHA_INICIO,'DD-MM-YYYY'), TO_CHAR(t.fecha_termino,'DD-MM-YYYY'),t.estado_tarea, t.porcentaje_avance,t.id_usuario,t.id_disennador FROM TAREAS T join PLANTILLA_TAREA pt  on t.id_p_tarea= pt.id_p_tarea where t.porcentaje_avance <'100'  and t.id_empresa='" + idD + "' and t.id_usuario='" + idE + "'and t.reporte is null and t.JUSTIFICACION is null and t.aceptacion=1  order by t.fecha_termino desc";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId_tarea(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                t.setFecha_inicio(rs.getString(3));
                t.setFecha_termino(rs.getString(4));
                t.setEstado_tarea(rs.getInt(5));
                t.setPorcentaje_avance(rs.getInt(6));
                t.setId_usuario(rs.getString(7));
                t.setId_desenador(rs.getString(8));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
