package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static javafx.collections.FXCollections.observableList;

public class ListaPacientesControlador {

    @FXML
    private TableColumn<Paciente, String> colCorreo;

    @FXML
    private TableColumn<Paciente, String> colIdentificacion;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, TipoSuscripcion> colSuscripcion;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableView<Paciente> tablaPacientes;

    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    public void initialize() {
        colCorreo.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>((cellData.getValue().getEmail())));
        colIdentificacion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCedula()));
        colNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        colSuscripcion.setCellValueFactory(cellData ->
                new SimpleObjectProperty((cellData.getValue().getSuscripcion())));
        colTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));
        setTablaPacientes();
    }

    public void setTablaPacientes(){
        tablaPacientes.setItems(observableList(controladorPrincipal.getClinica().listarPacientes()));
        tablaPacientes.refresh();

    }
}

