/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.oracle.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.CarreraDAO;
import pe.edu.upeu.oracle.entity.Carrera;


/**
 *
 * @author Cristhian
 */
 public class CarreraDAOImpl implements CarreraDAO {

    @Override
    public void addCarrera(Carrera carrera) {
        String query = "INSERT INTO carrera (Nombre, Estado) VALUES (?, ?)";
        try (Connection connection = Conexion.getConexion();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, carrera.getNombre());
            pstmt.setString(2, carrera.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Carrera getCarrera(int id_carrera) {
        String query = "SELECT * FROM carrera WHERE id_carrera = ?";
        try (Connection connection = Conexion.getConexion();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id_carrera);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setId_carrera(rs.getInt("id_carrera"));
                carrera.setNombre(rs.getString("Nombre"));
                carrera.setEstado(rs.getString("Estado"));
                return carrera;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carrera> getAllCarreras() {
        List<Carrera> carreras = new ArrayList<>();
        String query = "SELECT * FROM carrera";
        try (Connection connection = Conexion.getConexion();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setId_carrera(rs.getInt("id_carrera"));
                carrera.setNombre(rs.getString("Nombre"));
                carrera.setEstado(rs.getString("Estado"));
                carreras.add(carrera);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }

    @Override
    public void updateCarrera(Carrera carrera) {
        String query = "UPDATE carrera SET Nombre = ?, Estado = ? WHERE id_carrera = ?";
        try (Connection connection = Conexion.getConexion();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, carrera.getNombre());
            pstmt.setString(2, carrera.getEstado());
            pstmt.setInt(3, carrera.getId_carrera());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarrera(int id_carrera) {
        String query = "DELETE FROM carrera WHERE id_carrera = ?";
        try (Connection connection = Conexion.getConexion();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id_carrera);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}   
