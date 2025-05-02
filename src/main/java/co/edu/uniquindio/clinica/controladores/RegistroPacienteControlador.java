package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import static javafx.collections.FXCollections.observableList;

public class RegistroPacienteControlador {

    @FXML
    private ComboBox<TipoSuscripcion> cmbSuscripcion;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    public void initialize() {
        cmbSuscripcion.setItems(FXCollections.observableArrayList(TipoSuscripcion.values()));
    }

    @FXML
    void registrarse(ActionEvent event) {
        try {
            controladorPrincipal.getClinica().registrarPaciente(txtTelefono.getText(), txtNombre.getText(), txtCedula.getText(), txtEmail.getText(), cmbSuscripcion.getValue());
            controladorPrincipal.crearAlerta("El paciente fue registrado exitosamente", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void limpiarCampos(){
        txtCedula.clear();
        txtEmail.clear();
        txtNombre.clear();
        txtTelefono.clear();
        cmbSuscripcion.setValue(null);
    }
}
