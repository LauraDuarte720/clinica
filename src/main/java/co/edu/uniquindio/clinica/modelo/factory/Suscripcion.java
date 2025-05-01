package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import java.util.List;

public interface Suscripcion {
    public List<Servicio> getServiciosDisponibles();
    public Factura generarFacturaCobro(Servicio servicio);

}
