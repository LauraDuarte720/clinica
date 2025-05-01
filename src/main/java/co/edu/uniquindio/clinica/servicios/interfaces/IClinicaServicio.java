package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;

import java.time.LocalDateTime;
import java.util.List;

public interface IClinicaServicio {
    public void registrarPaciente(String telefono,String nombre, String cedula, String email)throws Exception;
    public List<Servicio> getServiciosDisponibles()throws Exception;
    public List<Paciente> listarPacientes() throws Exception;
    public void registrarServicio(double precio, String id, String nombre)throws Exception;
    public void registrarCita(Paciente paciente, String id, LocalDateTime fecha, Servicio servicio, Factura factura)throws Exception;
    public Factura generarFacturaCobro(Paciente paciente,Servicio servicio)throws Exception;
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion)throws Exception;
    public void cancelarCita(String id) throws Exception;

}
