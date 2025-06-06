package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.repositorios.CitaRepositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CitaServicio {
    private final CitaRepositorio citaRepositorio;


    public CitaServicio() {
        this.citaRepositorio = new CitaRepositorio();
    }

    public Cita agendarCita(Paciente paciente, LocalDateTime fecha, Servicio servicio) throws Exception{
        if(paciente == null) throw new Exception("No hay paciente seleccionado para la cita");
        if(fecha == null) throw new Exception("No hay fecha seleccionada");
        if(servicio == null) throw new Exception("No hay servicio seleccionada");
        if(fecha.isBefore(LocalDateTime.now())) throw new Exception("La fecha seleccionada no puede ser anterior a hoy");
        if(!pacienteDisponible(paciente)) throw new Exception("El paciente ya tiene una cita a esa hora");
        if(!horarioValidoCita(fecha, servicio)) throw new Exception("No hay horario disponible a esa hora");

        Factura factura = paciente.getSuscripcion().generarFacturaCobro(servicio);

        Cita cita = new Cita(paciente, UUID.randomUUID().toString(), fecha, servicio, factura);

        citaRepositorio.agregarCita(cita);

        return cita;
    }

    public boolean horarioValidoCita(LocalDateTime fecha, Servicio servicio)throws Exception{
        for(Cita cita: citaRepositorio.obtenerCitas()){
            if(fecha.equals(cita.getFecha()) && servicio.getTipoServicio().equals(cita.getServicio().getTipoServicio()) ){
                return false;
            }
        }
        return true;
    }

    public boolean pacienteDisponible(Paciente paciente){
        for(Cita cita: citaRepositorio.obtenerCitas()){
            if(cita.getPaciente().equals(paciente)) return false;
        }
        return true;
    }

    public void cancelarCita(String id) throws Exception {
        Cita cita = buscarCita(id);
        citaRepositorio.eliminarCita(cita);
    }

    public Cita buscarCita(String id) throws Exception {
        Cita cita = citaRepositorio.buscarCita(id);
        if(cita == null) throw new Exception("No hay citas con ese id");
        return cita;
    }

    public List<Cita> obtenerCitas() {
        return citaRepositorio.obtenerCitas();
    }
}
