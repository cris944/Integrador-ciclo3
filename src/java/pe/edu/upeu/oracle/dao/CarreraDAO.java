/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.oracle.dao;
import java.util.List;
import pe.edu.upeu.oracle.entity.Carrera;
/**
 *
 * @author Cristhian
 */
public interface CarreraDAO {
    void addCarrera(Carrera carrera);
    Carrera getCarrera(int id_carrera);
    List<Carrera> getAllCarreras();
    void updateCarrera(Carrera carrera);
    void deleteCarrera(int id_carrera);
}
