module co.edu.uniquindio.clinica {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires org.simplejavamail.core;
    requires org.simplejavamail;


    opens co.edu.uniquindio.clinica to javafx.fxml;
    exports co.edu.uniquindio.clinica;
    exports co.edu.uniquindio.clinica.controladores;
    opens co.edu.uniquindio.clinica.controladores to javafx.fxml;
}
