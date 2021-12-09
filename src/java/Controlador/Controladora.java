/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.Tarea;
import Modelo.TareaDAO;
import Modelo.Empresa;
import Modelo.EmpresaDAO;

import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
public class Controladora extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario u = new Usuario();
    Tarea t = new Tarea();
    TareaDAO tdao = new TareaDAO();
    Empresa em = new Empresa();
    EmpresaDAO emDAO = new EmpresaDAO();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Ingresar":
                String id = request.getParameter("txtid");
                String contraseña = request.getParameter("txtcont");

                u.setId_usuario(id);
                u.setContraseña(contraseña);

                r = dao.validar(u);

                if (r == 1) {
                    request.getSession().setAttribute("id", id);
                    request.getSession().setAttribute("Nom", u.getNombre());
                    request.getSession().setAttribute("ape_P", u.getApe_paterno());
                    request.getSession().setAttribute("ape_M", u.getApe_materno());
                    request.getSession().setAttribute("fecha_N", u.getFecha_nacimiento());
                    request.getSession().setAttribute("Correo", u.getCorreo());
                    request.getSession().setAttribute("id_S", u.getId_superior());
                    request.getSession().setAttribute("id_U", u.getId_unidad());
                    request.getSession().setAttribute("id_e", u.getId_empresa());
                    request.getSession().setAttribute("Contraseña", contraseña);
                    request.getSession().setAttribute("rol", u.getId_rol());

                    if (request.getSession().getAttribute("rol").equals(1)) {
                        request.getRequestDispatcher("Controladora?accion=Listar").forward(request, response);
                    } else if (request.getSession().getAttribute("rol").equals(2)) {
                        request.getRequestDispatcher("Controladora?accion=Listar_t_f_d").forward(request, response);
                    } else if (request.getSession().getAttribute("rol").equals(3)) {
                        request.getRequestDispatcher("Controladora?accion=Listar_t_r_f").forward(request, response);
                    } else if (request.getSession().getAttribute("rol").equals(4)) {
                        request.getRequestDispatcher("Controladora?accion=Listar_em").forward(request, response);
                    }

                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "Listar_em":
                List<Empresa> empresa = emDAO.Empresas();
                request.setAttribute("datos", empresa);
                request.getRequestDispatcher("S_Admin.jsp").forward(request, response);
                break;
            //admin
            case "Listar":
                String idE = (String) request.getSession().getAttribute("id_e");
                List<Usuario> datos = dao.listarUS(idE);
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Admin.jsp").forward(request, response);
                break;
            case "Listar_t_r":
                String idE2 = (String) request.getSession().getAttribute("id_e");
                List<Tarea> tareas = tdao.TareasR(idE2);
                request.setAttribute("datos", tareas);
                request.getRequestDispatcher("A_tareas_realizadas.jsp").forward(request, response);
                break;
            case "Listar_t_p":
                String idE3 = (String) request.getSession().getAttribute("id_e");
                List<Tarea> tareasp = tdao.TareasP(idE3);
                request.setAttribute("datos", tareasp);
                request.getRequestDispatcher("A_tareas_proceso.jsp").forward(request, response);
                break;
            case "Listar_t_re":
                String idE4 = (String) request.getSession().getAttribute("id_e");
                List<Tarea> tareasre = tdao.TareasRE(idE4);
                request.setAttribute("datos", tareasre);
                request.getRequestDispatcher("A_tareas_rechazadas.jsp").forward(request, response);
                break;
            case "Listar_t_es":
                String idE5 = (String) request.getSession().getAttribute("id_e");
                List<Tarea> tareases = tdao.TareasES(idE5);
                request.setAttribute("datos", tareases);
                request.getRequestDispatcher("A_tareas_en_espera.jsp").forward(request, response);
                break;
            //diseñador
            case "Listar_t_f_d":
                String idE6 = (String) request.getSession().getAttribute("id_e");
                String idEM = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasFD = tdao.TareasRED(idEM, idE6);
                request.setAttribute("datos", tareasFD);
                request.getRequestDispatcher("D_tareas_finalizadas.jsp").forward(request, response);
                break;
            case "Listar_t_p_d":
                String idE7 = (String) request.getSession().getAttribute("id_e");
                String idEM2 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasPD = tdao.TareasPD(idEM2, idE7);
                request.setAttribute("datos", tareasPD);
                request.getRequestDispatcher("D_tareas_proceso.jsp").forward(request, response);
                break;
            case "Listar_t_r_d":
                String idE8 = (String) request.getSession().getAttribute("id_e");
                String idEM3 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasRD = tdao.TareasRD(idEM3, idE8);
                request.setAttribute("datos", tareasRD);
                request.getRequestDispatcher("D_tareas_rechazadas.jsp").forward(request, response);
                break;
            case "Listar_t_es_d":
                String idE9 = (String) request.getSession().getAttribute("id_e");
                String idEM4 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasESD = tdao.TareasESD(idEM4, idE9);
                request.setAttribute("datos", tareasESD);
                request.getRequestDispatcher("D_tareas_en_espera.jsp").forward(request, response);
                break;
            //funcionario
            case "Listar_t_r_f":
                String idE10 = (String) request.getSession().getAttribute("id_e");
                String idEM5 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasREF = tdao.TareasREF(idEM5, idE10);
                request.setAttribute("datos", tareasREF);
                request.getRequestDispatcher("F_tareas_realizadas.jsp").forward(request, response);
                break;
            case "Listar_t_p_f":
                String idE11 = (String) request.getSession().getAttribute("id_e");
                String idEM6 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasPF = tdao.TareasPF(idEM6, idE11);
                request.setAttribute("datos", tareasPF);
                request.getRequestDispatcher("F_tareas_proceso.jsp").forward(request, response);
                break;
            case "Listar_t_re_f":
                String idE12 = (String) request.getSession().getAttribute("id_e");
                String idEM7 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasRF = tdao.TareasRF(idEM7, idE12);
                request.setAttribute("datos", tareasRF);
                request.getRequestDispatcher("F_tareas_rechazadas.jsp").forward(request, response);
                break;
            case "Listar_t_es_f":
                String idE13 = (String) request.getSession().getAttribute("id_e");
                String idEM8 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasESF = tdao.TareasESF(idEM8, idE13);
                request.setAttribute("datos", tareasESF);
                request.getRequestDispatcher("F_tareas_en_espera.jsp").forward(request, response);
                break;
                
            case "Listar_t_p_f2":
                String idE14 = (String) request.getSession().getAttribute("id_e");
                String idEM9 = (String) request.getSession().getAttribute("id");
                List<Tarea> tareasPF2 = tdao.TareasPF2(idEM9, idE14);
                request.setAttribute("datos", tareasPF2);
                request.getRequestDispatcher("F_tareas_proceso.jsp").forward(request, response);
                break;
            case "Salir":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("index.jsp");

                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                String idE = (String) request.getSession().getAttribute("id_e");
                List<Usuario> datos = dao.listarUS(idE);
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Admin.jsp").forward(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
