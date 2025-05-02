package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Servicio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javafx.collections.FXCollections.observableList;

public class ListaCitasController {

    @FXML
    private Button btnCancelar;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colId;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colServicio;

    @FXML
    private TableView<Cita> tablaCitas;

    private Cita citaSeleccionada;
    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    public void initialize() {

        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().obtenerFechaCadena()));
        colId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        colPaciente.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPaciente().getNombre()));
        colServicio.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getServicio().getTipoServicio().getNombre()));
        agregarListener();
        setCitas();
    }

    @FXML
    void onActionCancelarCita(ActionEvent event) {
        if (citaSeleccionada==null){
            controladorPrincipal.crearAlerta("No se ha seleccionado ninguna cita", Alert.AlertType.ERROR);
            return;
        }

        String idCita = citaSeleccionada.getId();
        try{
            controladorPrincipal.getClinica().cancelarCita(idCita);
            controladorPrincipal.crearAlerta("La cita fue cancelada exitosamente", Alert.AlertType.INFORMATION);
            setCitas();
        }
        catch (Exception e){
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    private void agregarListener(){
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            citaSeleccionada = (Cita) newValue;
        });
    }

    public void setCitas(){
        tablaCitas.setItems(observableList(controladorPrincipal.getClinica().listarCitas()));
        tablaCitas.refresh();

    }

}
