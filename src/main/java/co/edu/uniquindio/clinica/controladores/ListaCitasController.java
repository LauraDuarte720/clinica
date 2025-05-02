package co.edu.uniquindio.clinica.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaCitasController {

    @FXML
    private Button btnCancelar;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPaciente;

    @FXML
    private TableColumn<?, ?> colServicio;

    @FXML
    private TableColumn<?, ?> colTelefono;

    @FXML
    private TableView<?> tablaPacientes;

    @FXML
    void onActionCancelarCita(ActionEvent event) {

    }

}
