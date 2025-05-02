package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;

public class FactorySuscripcion {


    public static Suscripcion crearSuscripcion(TipoSuscripcion tipoSuscripcion) {
        Suscripcion suscripcion = null;
        if(tipoSuscripcion != null) {
            switch (tipoSuscripcion) {
                case BASICA -> suscripcion = new SuscripcionBasica();
                case PREMIUM -> suscripcion = new SuscripcionPremiun();
            }
        }
        return suscripcion;
    }



}
