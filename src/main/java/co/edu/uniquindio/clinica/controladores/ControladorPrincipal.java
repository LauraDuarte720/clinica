package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import co.edu.uniquindio.clinica.servicios.ClinicaServicio;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
public class ControladorPrincipal {


    private static ControladorPrincipal instancia;


    private final ClinicaServicio clinica;


    private ControladorPrincipal(){
        clinica = new ClinicaServicio();
    }


    public static ControladorPrincipal getInstancia(){
        if(instancia == null){
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }


    public void cerrarVentana(Node node){
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setHeight(300);
        alert.setWidth(500);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }




}
