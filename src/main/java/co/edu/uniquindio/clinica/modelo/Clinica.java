package co.edu.uniquindio.clinica.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class Clinica {
    private List<Servicio> servicios;
    private List<Cita> citas;
    private List <Paciente> pacientes;

}
