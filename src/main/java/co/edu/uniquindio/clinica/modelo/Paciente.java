package co.edu.uniquindio.clinica.modelo;

import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import co.edu.uniquindio.clinica.modelo.factory.SuscripcionBasica;
import co.edu.uniquindio.clinica.modelo.factory.SuscripcionPremiun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Paciente {
    private String telefono;
    private String nombre;
    private String cedula;
    private String email;
    private Suscripcion suscripcion;

    public TipoSuscripcion obtenerTipoSuscripcion() {
        TipoSuscripcion tipoSuscripcion = null;
        if (suscripcion instanceof SuscripcionBasica) {
            tipoSuscripcion = TipoSuscripcion.BASICA;
        } else if (suscripcion instanceof SuscripcionPremiun) {
            tipoSuscripcion = TipoSuscripcion.PREMIUM;
        }
        return tipoSuscripcion;
    }
}


