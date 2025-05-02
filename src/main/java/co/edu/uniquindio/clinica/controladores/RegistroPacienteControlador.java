package co.edu.uniquindio.clinica.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroPacienteControlador {

    @FXML
    private ComboBox<?> cmbSuscripcion;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void registrarse(ActionEvent event) {
        System.out.println();
    }

}
