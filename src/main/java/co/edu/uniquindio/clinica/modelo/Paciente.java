package co.edu.uniquindio.clinica.modelo;

import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.Builder;
import lombok.Getter;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.Setter;

@Getter
@Setter
@Builder

public class Paciente {
    private String telefono;
    private String nombre;
    private String cedula;
    private String email;
    private Suscripcion suscripcion;
}


