package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import co.edu.uniquindio.clinica.modelo.factory.FactorySuscripcion;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import co.edu.uniquindio.clinica.servicios.interfaces.IClinicaServicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ClinicaServicio implements IClinicaServicio {
    private final CitaServicio citaServicio;
    private final PacienteServicio pacienteServicio;

    public ClinicaServicio() {
        citaServicio = new CitaServicio();
        pacienteServicio = new PacienteServicio();
    }


    @Override
    public void registrarPaciente(String telefono, String nombre, String cedula, String email, TipoSuscripcion tipoSuscripcion) throws Exception {
        Suscripcion suscripcion = FactorySuscripcion.crearSuscripcion(tipoSuscripcion);
        pacienteServicio.registrarPaciente(telefono, nombre, cedula, email, suscripcion);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteServicio.obtenerPacientes();
    }

    @Override
    public List<Cita> listarCitas() {
        return citaServicio.obtenerCitas();
    }


    @Override
    public void registrarCita(String cedulaPaciente, LocalDate fecha, LocalTime hora, TipoServicio tipoServicio) throws Exception {

        Paciente paciente = pacienteServicio.buscarPaciente(cedulaPaciente);
        LocalDateTime fechaCita = fecha.atTime(hora);
        Servicio servicioSeleccionado = null;
        for (Servicio servicio : paciente.getSuscripcion().getServiciosDisponibles()) {
            if (servicio.getTipoServicio().equals(tipoServicio)) {
                servicioSeleccionado = servicio;
            }
            citaServicio.agendarCita(paciente, fechaCita, servicio);
        }
    }

    @Override
    public Factura generarFacturaCobro(String cedulaPaciente, TipoServicio tipoServicio) throws Exception {
        Paciente paciente = pacienteServicio.buscarPaciente(cedulaPaciente);
        Servicio servicioSeleccionado = null;
        for (Servicio servicio : paciente.getSuscripcion().getServiciosDisponibles()) {
            if (servicio.getTipoServicio().equals(tipoServicio)) {
                servicioSeleccionado = servicio;
            }
        }
        return paciente.getSuscripcion().generarFacturaCobro(servicioSeleccionado);
    }


    @Override
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion) throws Exception {
        return suscripcion.getServiciosDisponibles();
    }

    @Override
    public void cancelarCita(String id) throws Exception {
        citaServicio.cancelarCita(id);
    }
}
