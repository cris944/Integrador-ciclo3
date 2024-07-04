/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.oracle.controller;
import pe.edu.upeu.oracle.dao.CarreraDAO;
import pe.edu.upeu.oracle.daoImpl.CarreraDAOImpl;
import pe.edu.upeu.oracle.entity.Carrera;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Cristhian
 */
@WebServlet("/carreras")
public class CarreraController extends HttpServlet {
    private CarreraDAO carreraDAO;

    @Override
    public void init() {
        carreraDAO = new CarreraDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertCarrera(request, response);
                break;
            case "delete":
                deleteCarrera(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCarrera(request, response);
                break;
            default:
                listCarreras(request, response);
                break;
        }
    }

    private void listCarreras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Carrera> carreras = carreraDAO.getAllCarreras();
        request.setAttribute("carreras", carreras);
        request.getRequestDispatcher("/carrera-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/carrera-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        Carrera existingCarrera = carreraDAO.getCarrera(id_carrera);
        request.setAttribute("carrera", existingCarrera);
        request.getRequestDispatcher("/carrera-form.jsp").forward(request, response);
    }

    private void insertCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String estado = request.getParameter("estado");
        Carrera newCarrera = new Carrera();
        newCarrera.setNombre(nombre);
        newCarrera.setEstado(estado);
        carreraDAO.addCarrera(newCarrera);
        response.sendRedirect("carreras");
    }

    private void updateCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        String nombre = request.getParameter("nombre");
        String estado = request.getParameter("estado");

        Carrera carrera = new Carrera();
        carrera.setId_carrera(id_carrera);
        carrera.setNombre(nombre);
        carrera.setEstado(estado);

        carreraDAO.updateCarrera(carrera);
        response.sendRedirect("carreras");
    }

    private void deleteCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        carreraDAO.deleteCarrera(id_carrera);
        response.sendRedirect("carreras");
    }
}
