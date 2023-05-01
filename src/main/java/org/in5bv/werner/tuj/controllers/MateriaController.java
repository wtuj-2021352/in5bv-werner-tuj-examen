package org.in5bv.werner.tuj.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import org.in5bv.werner.tuj.system.Principal;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.in5bv.werner.tuj.models.dao.MateriaDaoImpl;
import org.in5bv.werner.tuj.models.domain.Materia;

/**
 *
 * @author Werner Obdulio Emmanuel Tuj Chacom
 * @date 29/09/2022
 * @time 20:59:32
 *
 * Código técnico: IN5BV Grupo: 2/2
 *
 *
 */
public class MateriaController implements Initializable {

    private enum Operacion {
        NINGUNO, GUARDAR, ACTUALIZAR
    }
    private Operacion operacion = Operacion.NINGUNO;
    private final String PAQUETE_IMAGE = "org/in5bv/werner/tuj/resources/images/";
    private final String PAQUETE_VIEW = "../views/";
    private Principal escenarioPrincipal;
    private ObservableList<Materia> listaMateria;

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    @FXML
    private Button btnNuevo;

    @FXML
    private ImageView imgNuevo;

    @FXML
    private Button btnModificar;

    @FXML
    private ImageView imgModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ImageView imgEliminar;

    @FXML
    private TextField txtContador;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMateria;

    @FXML
    private Spinner<Integer> spnCiclo;

    @FXML
    private TextField txtCatedratico;

    @FXML
    private TextField txtSalon;

    @FXML
    private JFXTimePicker tmpHorarioInicio;

    @FXML
    private JFXTimePicker tmpHorarioFinal;

    @FXML
    private Spinner<Integer> spnCupoMin;

    @FXML
    private Spinner<Integer> spnCupoMax;

    @FXML
    private TableView tblMaterias;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colMateria;

    @FXML
    private TableColumn colCiclo;

    @FXML
    private TableColumn colHorarioInicio;

    @FXML
    private TableColumn colHorarioFinal;

    @FXML
    private TableColumn colCatedratico;

    @FXML
    private TableColumn colSalon;

    @FXML
    private TableColumn colCupoMin;

    @FXML
    private TableColumn colCupoMax;
    
    private SpinnerValueFactory<Integer> valueFactoryCupoMinimo;

    private SpinnerValueFactory<Integer> valueFactoryCupoMaximo;
    
    private SpinnerValueFactory<Integer> valueFactoryCiclo;

    public boolean validacionDatos() {
        return (txtMateria.getText().isEmpty() || txtCatedratico.getText().isEmpty() || txtSalon.getText().isEmpty()
                || spnCiclo.getValue().equals("") || spnCupoMax.getValue().equals("") || spnCupoMin.getValue().equals("")
                || tmpHorarioInicio.getEditor().getText().equals("")
                || tmpHorarioFinal.getEditor().getText().equals(""));
    }

    public void contador() {
        MateriaDaoImpl materia = new MateriaDaoImpl();
        int contador;
        contador = materia.getAll().size();
        txtContador.setText(String.valueOf(contador));
    }

    public void cargarDatos() {
        MateriaDaoImpl materiaDaoImpl = new MateriaDaoImpl();
        tblMaterias.setItems(materiaDaoImpl.getAll());
        colId.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("idMateria"));
        colMateria.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("nombreMateria"));
        colCiclo.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("ciclo"));
        colHorarioInicio.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("horarioInicio"));
        colHorarioFinal.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("horarioFinal"));
        colCatedratico.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("catedratico"));
        colSalon.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("salon"));
        colCupoMin.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("cupoMinimo"));
        colCupoMax.setCellValueFactory(new PropertyValueFactory<Materia, Integer>("cupoMaximo"));
    }

    private void deshabilitarCampos() {
        txtId.setEditable(false);
        txtId.setDisable(true);

        txtMateria.setEditable(false);
        txtMateria.setDisable(true);

        spnCiclo.setEditable(false);
        spnCiclo.setDisable(true);

        tmpHorarioInicio.setDisable(true);
        tmpHorarioFinal.setDisable(true);

        txtCatedratico.setEditable(false);
        txtCatedratico.setDisable(true);

        txtSalon.setEditable(false);
        txtSalon.setDisable(true);

        spnCupoMax.setEditable(false);
        spnCupoMax.setDisable(true);

        spnCupoMin.setEditable(false);
        spnCupoMin.setDisable(true);
    }

    private void habilitarCampos() {
        txtId.setEditable(false);
        txtId.setDisable(true);

        txtMateria.setEditable(true);
        txtMateria.setDisable(false);

        spnCiclo.setEditable(true);
        spnCiclo.setDisable(false);

        tmpHorarioInicio.setDisable(false);
        tmpHorarioFinal.setDisable(false);

        txtCatedratico.setEditable(true);
        txtCatedratico.setDisable(false);

        txtSalon.setEditable(true);
        txtSalon.setDisable(false);

        spnCupoMax.setEditable(true);
        spnCupoMax.setDisable(false);

        spnCupoMin.setEditable(true);
        spnCupoMin.setDisable(false);
    }

    private void limpiarCampos() {
        txtId.clear();
        txtMateria.setText("");
        spnCiclo.getValueFactory().setValue(2022);
        tmpHorarioInicio.getEditor().clear();
        tmpHorarioFinal.getEditor().clear();
        txtCatedratico.setText("");
        txtSalon.setText("");
        spnCupoMax.getValueFactory().setValue(20);
        spnCupoMin.getValueFactory().setValue(5);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valueFactoryCupoMaximo = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 80, 0);
        spnCupoMax.setValueFactory(valueFactoryCupoMaximo);

        valueFactoryCupoMinimo = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 50, 0);
        spnCupoMin.setValueFactory(valueFactoryCupoMinimo);
        
        valueFactoryCiclo = new SpinnerValueFactory.IntegerSpinnerValueFactory(2000, 2022, 0);
        spnCiclo.setValueFactory(valueFactoryCiclo);

        cargarDatos();
        contador();
    }

    private boolean agregarMateria() {
        MateriaDaoImpl materiaDao = new MateriaDaoImpl();
        Materia materia = new Materia();

        materia.setNombreMateria(txtMateria.getText());
        materia.setCiclo(spnCiclo.getValue());
        materia.setHorarioInicio(Time.valueOf(tmpHorarioInicio.getValue()));
        materia.setHorarioFinal(Time.valueOf(tmpHorarioFinal.getValue()));
        materia.setCatedratico(txtCatedratico.getText());
        materia.setSalon(txtSalon.getText());
        materia.setCupoMaximo(spnCupoMax.getValue());
        materia.setCupoMinimo(spnCupoMin.getValue());
        return materiaDao.add(materia);
    }

    @FXML
    void clicNuevo(ActionEvent event) {
        switch (operacion) {
            case NINGUNO: //Primer Clic Nuevo
                habilitarCampos();
                tblMaterias.getSelectionModel().clearSelection();
                tblMaterias.setDisable(true);

                limpiarCampos();

                btnNuevo.setText("Guardar");
                imgNuevo.setImage(new Image(PAQUETE_IMAGE + "guardar.png"));

                btnModificar.setText("Cancelar");
                imgModificar.setImage(new Image(PAQUETE_IMAGE + "cancelar.png"));

                btnEliminar.setDisable(true);
                btnEliminar.setVisible(false);
                imgEliminar.setVisible(false);

                operacion = Operacion.GUARDAR;
                
                break;

            case GUARDAR:
                if (validacionDatos()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Control Materia");
                    alert.setContentText("Antes de finalizar la insersión debe ingresar los datos"
                            + " solicitados en cada uno de los campos");

                    Image icon = new Image(PAQUETE_IMAGE + "/curso.png");

                    Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                    stageAlert.getIcons().add(icon);
                    alert.showAndWait();
                } else {
                    if (agregarMateria()) {
                        cargarDatos();
                        limpiarCampos();
                        deshabilitarCampos();
                        tblMaterias.setDisable(false);
                        btnNuevo.setText("Nuevo");
                        imgNuevo.setImage(new Image(PAQUETE_IMAGE + "agregar.png"));

                        btnModificar.setText("Editar");
                        imgModificar.setImage(new Image(PAQUETE_IMAGE + "modificar.png"));

                        btnEliminar.setText("Eliminar");
                        imgEliminar.setImage(new Image(PAQUETE_IMAGE + "eliminar.png"));

                        btnEliminar.setDisable(false);
                        btnEliminar.setVisible(true);
                        imgEliminar.setVisible(true);
                        contador();

                        operacion = Operacion.NINGUNO;
                    }
                }
                break;
        }
    }
    
    private boolean editarMateria() {
        MateriaDaoImpl materiaDao = new MateriaDaoImpl();
        Materia materia = new Materia();

        materia.setNombreMateria(txtMateria.getText());
        materia.setCiclo(spnCiclo.getValue());
        materia.setHorarioInicio(Time.valueOf(tmpHorarioInicio.getValue()));
        materia.setHorarioFinal(Time.valueOf(tmpHorarioFinal.getValue()));
        materia.setCatedratico(txtCatedratico.getText());
        materia.setSalon(txtSalon.getText());
        materia.setCupoMaximo(spnCupoMax.getValue());
        materia.setCupoMinimo(spnCupoMin.getValue());
        materia.setIdMateria(Integer.parseInt(txtId.getText()));
        return materiaDao.update(materia);
    }
    
    public boolean existeElementoSeleccionado() {
        return (tblMaterias.getSelectionModel().getSelectedItem() != null);

    }
    
    @FXML
    void clicModificar(ActionEvent event) {
        switch (operacion) {
            case NINGUNO: //editar una inserción
                if (existeElementoSeleccionado()) {
                    habilitarCampos();

                    btnNuevo.setDisable(true);
                    btnNuevo.setVisible(false);
                    imgNuevo.setVisible(false);

                    btnModificar.setText("Guardar");
                    imgModificar.setImage(new Image(PAQUETE_IMAGE + "guardar.png"));

                    btnEliminar.setText("Cancelar");
                    imgEliminar.setImage(new Image(PAQUETE_IMAGE + "cancelar.png"));
                    operacion = Operacion.ACTUALIZAR;
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Control Materia");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image(PAQUETE_IMAGE + "curso.png"));
                    alert.setContentText("Antes de continuar, seleccione un registro.");
                    alert.show();
                }
                break;
            case GUARDAR: //Cancela la inserción
                btnNuevo.setText("Nuevo");
                imgNuevo.setImage(new Image(PAQUETE_IMAGE + "agregar.png"));

                btnModificar.setText("Editar");
                imgModificar.setImage(new Image(PAQUETE_IMAGE + "modificar.png"));

                btnEliminar.setDisable(false);
                btnEliminar.setVisible(true);
                imgEliminar.setVisible(true);

                limpiarCampos();
                deshabilitarCampos();

                tblMaterias.setDisable(false);

                operacion = Operacion.NINGUNO;
                break;
            case ACTUALIZAR:

                if (validacionDatos()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Control Materia");
                    alert.setContentText("Antes de finalizar la edición rellene los campos.");

                    Image icon = new Image(PAQUETE_IMAGE + "/curso.png");

                    Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                    stageAlert.getIcons().add(icon);
                    alert.showAndWait();
                } else {

                    if (existeElementoSeleccionado()) {

                        if (editarMateria()) {
                            cargarDatos();
                            limpiarCampos();

                            tblMaterias.setDisable(false);
                            tblMaterias.getSelectionModel().clearSelection();

                            btnNuevo.setText("Nuevo");
                            btnNuevo.setDisable(false);
                            btnNuevo.setVisible(true);
                            imgNuevo.setVisible(true);
                            imgNuevo.setImage(new Image(PAQUETE_IMAGE + "agregar.png"));

                            btnModificar.setText("Editar");
                            imgModificar.setImage(new Image(PAQUETE_IMAGE + "modificar.png"));

                            btnEliminar.setText("Eliminar");
                            imgEliminar.setImage(new Image(PAQUETE_IMAGE + "eliminar.png"));

                            btnEliminar.setDisable(false);
                            btnEliminar.setVisible(true);
                            imgEliminar.setVisible(true);

                            deshabilitarCampos();

                            operacion = Operacion.NINGUNO;
                        }
                    }
                }
                break;
        }
    }
    
    public boolean eliminarMateria() {
        MateriaDaoImpl materiaDao = new MateriaDaoImpl();
        int id = Integer.parseInt(txtId.getText());
        return materiaDao.delete(id);
    }

    @FXML
    void clicEliminar(ActionEvent event) {
        switch (operacion) {
            case ACTUALIZAR: //Cancelar una modificación.
                btnNuevo.setDisable(false);
                btnNuevo.setVisible(true);
                imgNuevo.setVisible(true);

                btnModificar.setText("Editar");
                imgModificar.setImage(new Image(PAQUETE_IMAGE + "modificar.png"));

                btnEliminar.setText("Eliminar");
                imgEliminar.setImage(new Image(PAQUETE_IMAGE + "eliminar.png"));

                limpiarCampos();
                deshabilitarCampos();

                tblMaterias.getSelectionModel().clearSelection();

                operacion = Operacion.NINGUNO;
                break;
            case NINGUNO:
                if (existeElementoSeleccionado()) {

                    Alert alertNew = new Alert(Alert.AlertType.CONFIRMATION);
                    alertNew.setHeaderText(null);
                    alertNew.setTitle("KINAL \"CONTROL MATERIAS\"");
                    alertNew.setContentText(null);
                    alertNew.setContentText("¿Desea eliminar el registro?");

                    Stage stage = (Stage) alertNew.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image(PAQUETE_IMAGE + "curso.png"));

                    Optional<ButtonType> result = alertNew.showAndWait();

                    if (result.get().equals(ButtonType.OK)) {

                        if (eliminarMateria()) {
                            cargarDatos();

                            System.out.println("\n");
                            limpiarCampos();
                            cargarDatos();
                            contador();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("KINAL \"CONTROL ACÁDEMICO\"");
                            alert.setContentText("Registro eliminado exitosamente");
                            Image icon = new Image(PAQUETE_IMAGE + "curso.png");
                            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                            stageAlert.getIcons().add(icon);
                            alert.show();
                        } else if (result.get().equals(ButtonType.CANCEL)) {
                            System.out.println("\nCancelando Operación");
                            tblMaterias.getSelectionModel().clearSelection();
                            limpiarCampos();
                        }
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("Antes de seguir selecciona un registro");
                    Image icon = new Image(PAQUETE_IMAGE + "curso.png");
                    Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                    stageAlert.getIcons().add(icon);
                    alert.show();
                }
                break;
        }
    }
    
    @FXML
    public void seleccionarElemento() {
        if (existeElementoSeleccionado()) {
            String id = String.valueOf(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getIdMateria());
            
            txtId.setText(id);
            txtMateria.setText(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getNombreMateria());
            spnCiclo.getValueFactory().setValue(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getCiclo());
            tmpHorarioInicio.setValue(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getHorarioInicio().toLocalTime());
            tmpHorarioFinal.setValue(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getHorarioFinal().toLocalTime());
            txtCatedratico.setText(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getCatedratico());
            txtSalon.setText(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getSalon());
            spnCupoMax.getValueFactory().setValue(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getCupoMaximo());
            spnCupoMin.getValueFactory().setValue(((Materia) tblMaterias.getSelectionModel().getSelectedItem()).getCupoMinimo());

        }
    }
}
