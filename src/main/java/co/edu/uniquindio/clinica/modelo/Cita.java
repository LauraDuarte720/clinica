package co.edu.uniquindio.clinica.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor

public class Cita {

    private Paciente paciente;
    private String id;
    private LocalDateTime fecha;
    private Servicio servicio;
    private Factura factura;

    public String obtenerFechaCadena(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(formatter);
    }


}
