package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface IClinicaServicio {
    public void registrarPaciente(String telefono, String nombre, String cedula, String email, TipoSuscripcion tipoSuscripcion)throws Exception;
    public List<Paciente> listarPacientes() throws Exception;
    public void registrarCita(String cedulaPaciente, LocalDate fecha, LocalTime hora, TipoServicio tipoServicio)throws Exception;
    public Factura generarFacturaCobro(String cedulaPaciente, TipoServicio tipoServicio)throws Exception;
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion)throws Exception;
    public void cancelarCita(String id) throws Exception;
    public List<Cita> listarCitas() throws Exception;

}
