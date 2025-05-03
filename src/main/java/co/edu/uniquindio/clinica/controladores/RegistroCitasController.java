package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
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
    private TextField txtCedula;

    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    public void initialize() {
        cmbHora.setItems(observableList(generarHorariosCada20Min()));

        cmbServicio.setItems(FXCollections.observableArrayList(TipoServicio.values()));
        dateFecha.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #EEEEEE;"); // Opcional: color gris claro
                }
            }
        });

        dateFecha.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                if (newDate.isEqual(LocalDate.now())) {
                    LocalTime ahora = LocalTime.now();
                    cmbHora.setItems(observableList(filtrarHorasPosteriores(generarHorariosCada20Min(), ahora)));
                } else {
                    cmbHora.setItems(observableList(generarHorariosCada20Min()));
                }
            }
        });
    }

    @FXML
    void crearCita(ActionEvent event) throws Exception {
        try {
            controladorPrincipal.getClinica().registrarCita(txtCedula.getText(), dateFecha.getValue(), cmbHora.getValue(), cmbServicio.getValue());
            limpiarCampos();
            controladorPrincipal.crearAlerta("La cita fue registrada exitosamente", Alert.AlertType.INFORMATION);
        }
        catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);

        }
    }

    public void limpiarCampos(){
        txtCedula.clear();
        dateFecha.setValue(null);
        cmbHora.setValue(null);
        cmbServicio.setValue(null);
    }

    public List<LocalTime> filtrarHorasPosteriores(List<LocalTime> horasOrdenadas, LocalTime horaActual) {
        int index = 0;
        while (index < horasOrdenadas.size() && horasOrdenadas.get(index).isBefore(horaActual)) {
            index++;
        }
        return horasOrdenadas.subList(index, horasOrdenadas.size());
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
