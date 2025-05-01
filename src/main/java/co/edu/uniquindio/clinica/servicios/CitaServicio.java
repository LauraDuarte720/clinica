package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.repositorios.CitaRepositorio;

import java.time.LocalDateTime;
import java.util.UUID;

public class CitaServicio {
    private final CitaRepositorio citaRepositorio;


    public CitaServicio() {
        this.citaRepositorio = new CitaRepositorio();
    }

    public void agendarCita(Paciente paciente, LocalDateTime fecha, Servicio servicio) throws Exception{
        if(paciente == null) throw new Exception("No hay paciente seleccionado para la cita");
        if(fecha == null) throw new Exception("No hay fecha seleccionada");
        if(servicio == null) throw new Exception("No hay servicio seleccionada");

        Factura factura = new Factura(fecha, UUID.randomUUID().toString(), servicio.getPrecio(), servicio.getPrecio());

        Cita cita = new Cita(paciente, UUID.randomUUID().toString(), fecha, servicio, factura);

        citaRepositorio.agregarCita(cita);
    }

    public void cancelarCita(String id) throws Exception {
        Cita cita = citaRepositorio.buscarCita(id);
        if(cita == null) throw new Exception("No hay citas con ese id");
        citaRepositorio.eliminarCita(cita);
    }


}
