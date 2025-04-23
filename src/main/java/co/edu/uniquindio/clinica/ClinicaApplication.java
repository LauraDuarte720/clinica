package co.edu.uniquindio.clinica;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.File;
import java.util.List;

public class ClinicaApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(ClinicaApplication.class.getResource("view/ViewContactos.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent, 800, 360);
        stage.setScene(scene);
        stage.setTitle("UQ Notas");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {

        launch(ClinicaApplication.class, args);
    }

    public static void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setMinHeight(300); // Aumenta el alto

        alert.showAndWait();
    }

}
