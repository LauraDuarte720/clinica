package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static javafx.collections.FXCollections.observableList;

public class RegistroCitasController {

    @FXML
    private ComboBox<LocalTime> cmbHora;

    @FXML
    private ComboBox<TipoServicio> cmbServicio;

    @FXML
    private DatePicker dateFecha;

    @FXML
    private TextField cedula;

    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML

    public void initialize() {
        cmbHora.setItems(observableList(generarHorariosCada20Min()));
        cmbServicio.setItems(FXCollections.observableArrayList(TipoServicio.values()));
    }

    @FXML
    void CrearCita(ActionEvent event) throws Exception {
        try {
            controladorPrincipal.getClinica().registrarCita(cedula.getText(), dateFecha.getValue(), cmbHora.getValue(), cmbServicio.getValue());
        }
        catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);

        }
    }


    public List<LocalTime> generarHorariosCada20Min() {
        List<LocalTime> horarios = new ArrayList<>();

        LocalTime inicio = LocalTime.of(7, 0);
        LocalTime fin = LocalTime.of(19, 0); // 7 PM

        while (!inicio.isAfter(fin)) {
            horarios.add(inicio);
            inicio = inicio.plusMinutes(20);
        }

        return horarios;
    }

}
