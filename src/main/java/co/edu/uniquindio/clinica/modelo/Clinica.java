package co.edu.uniquindio.clinica.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class Clinica {
    private List<Servicio> servicios;
    private List<Cita> citas;
    private List <Paciente> pacientes;

}
