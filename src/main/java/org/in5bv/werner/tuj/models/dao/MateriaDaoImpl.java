package org.in5bv.werner.tuj.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.in5bv.werner.tuj.db.Conexion;
import org.in5bv.werner.tuj.models.domain.Materia;
import org.in5bv.werner.tuj.models.idao.IMateriaDAO;

/**
 *
 * @author Werner Obdulio Emmanuel Tuj Chacom
 * @date 30/09/2022
 * @time 07:21:03
 * 
 * Código técnico: IN5BV
 * Grupo: 2/2
 *
 **/
public class MateriaDaoImpl implements IMateriaDAO {

    private static final String SQL_SELECT = "SELECT id_materia, nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo FROM materia;";
    private static final String SQL_DELETE = "DELETE FROM materia WHERE id_materia = ?;";
    private static final String SQL_INSERT = "INSERT INTO materia(nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE materia SET nombre_materia = ? , ciclo_escolar = ?, horario_inicio = ?, horario_final = ?, catedratico = ?, salon = ?, cupo_maximo = ?, cupo_minimo = ? WHERE id_materia = ?;";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Materia materia = null;
    private ObservableList<Materia> listaMateria;

    @Override
    public ObservableList<Materia> getAll() {

        List<Materia> lista = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = Conexion.getInstance().getConexion().prepareStatement(SQL_SELECT);

            System.out.println(pstmt.toString());

            rs = pstmt.executeQuery();

            while (rs.next() == true) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setNombreMateria(rs.getString(2));
                materia.setCiclo(rs.getInt(3));
                materia.setHorarioInicio(rs.getTime(4));
                materia.setHorarioFinal(rs.getTime(5));
                materia.setCatedratico(rs.getString(6));
                materia.setSalon(rs.getString(7));
                materia.setCupoMaximo(rs.getInt(8));
                materia.setCupoMinimo(rs.getInt(9));
                lista.add(materia);
                System.out.println("\n" + materia.toString());
            }

            listaMateria = FXCollections.observableArrayList(lista);

        } catch (SQLException e) {
            System.err.println("\nSe produjo un error al intentar consultar la lista de Materia");
            System.out.println("Message: " + e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaMateria;
    }

    @Override
    public boolean add(Materia materia) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = Conexion.getInstance().getConexion().prepareStatement(SQL_INSERT);

            pstmt.setString(1, materia.getNombreMateria());
            pstmt.setInt(2, materia.getCiclo());
            pstmt.setTime(3, materia.getHorarioInicio());
            pstmt.setTime(4, materia.getHorarioFinal());
            pstmt.setString(5, materia.getCatedratico());
            pstmt.setString(6, materia.getSalon());
            pstmt.setInt(7, materia.getCupoMaximo());
            pstmt.setInt(8, materia.getCupoMinimo());

            System.out.println(pstmt.toString());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar " + materia.toString());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(Materia materia){
        PreparedStatement pstmt = null;

        try {
            pstmt = Conexion.getInstance().getConexion().prepareStatement(SQL_UPDATE);

            pstmt.setString(1, materia.getNombreMateria());
            pstmt.setInt(2, materia.getCiclo());
            pstmt.setTime(3, materia.getHorarioInicio());
            pstmt.setTime(4, materia.getHorarioFinal());
            pstmt.setString(5, materia.getCatedratico());
            pstmt.setString(6, materia.getSalon());
            pstmt.setInt(7, materia.getCupoMaximo());
            pstmt.setInt(8, materia.getCupoMinimo());
            pstmt.setInt(9, materia.getIdMateria());
            System.out.println(pstmt.toString());

            pstmt.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nSE PRODUJO UN ERROR AL INTENTAR"
                    + " INGRESAR EL SIGUIENTE REGISTRO: " + materia.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean delete(int idMateria) {
        System.out.println("Materia a elmininar con el id: " + idMateria);

        PreparedStatement pstmt = null;
        try {
            pstmt = Conexion.getInstance().getConexion().prepareStatement(SQL_DELETE);
            pstmt.setInt(1, idMateria);
            System.out.println(pstmt.toString());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con id: " + idMateria);
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;

    }

}
