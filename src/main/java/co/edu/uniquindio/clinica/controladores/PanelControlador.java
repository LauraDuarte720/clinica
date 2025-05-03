package co.edu.uniquindio.clinica.controladores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;


public class PanelControlador {


    @FXML
    private StackPane panelPrincipal;

    @FXML
    public void mostrarRegistroPaciente(ActionEvent actionEvent) {
        Parent node = cargarPanel("/registroPaciente.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }

    @FXML
    public void mostrarListaPacientes(ActionEvent actionEvent) {
        Parent node = cargarPanel("/listaPacientes.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }


    public void mostrarRegistroCita(ActionEvent actionEvent) {
        Parent node = cargarPanel("/registroCitas.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }


    public void mostrarListaCitas(ActionEvent actionEvent) {
        Parent node = cargarPanel("/listaCitas.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }


    private Parent cargarPanel(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent node = loader.load();
            return node;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
