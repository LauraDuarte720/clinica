package co.edu.uniquindio.clinica.modelo;

import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class Servicio {
    private double precio;
    private String id;
    private String nombre;
    private TipoServicio tipoServicio;
}
