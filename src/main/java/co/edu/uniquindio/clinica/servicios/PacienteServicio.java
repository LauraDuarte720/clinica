package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import co.edu.uniquindio.clinica.repositorios.PacienteRepositorio;

import java.util.List;

public class PacienteServicio {

    private final PacienteRepositorio pacienteRepositorio;

    public PacienteServicio() {
        this.pacienteRepositorio = new PacienteRepositorio();
    }

    public Paciente registrarPaciente(String telefono, String nombre, String cedula, String email, Suscripcion suscripcion) throws Exception{
        if(telefono == null || telefono.isEmpty()) throw new Exception("El télefono es obligatorio");
        if (!telefono.trim().matches("^3\\d{9}$")) throw new Exception("El telefono debe tener 10 digitos e iniciar en 3");
        if(nombre == null || nombre.isEmpty()) throw new Exception("El nombre es obligatorio");
        if(cedula == null || cedula.isEmpty()) throw new Exception("El cédula es obligatorio");
        if(email == null || email.isEmpty()) throw new Exception("El email es obligatorio");
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) throw new Exception("Email inválido");
        if(suscripcion == null) throw new Exception("La suscripcion es obligatoria");
        if(pacienteRepositorio.buscarPaciente(cedula) != null ) throw new Exception("El paciente ya existe");



        Paciente paciente = new Paciente(telefono, nombre, cedula, email, suscripcion);
        pacienteRepositorio.agregarPaciente(paciente);
        
        return paciente;
    }
//
    public void eliminarPaciente(String cedula) throws Exception{
        Paciente paciente = buscarPaciente(cedula);
        pacienteRepositorio.eliminarPaciente(paciente);
    }

    public Paciente buscarPaciente(String cedula) throws Exception {
        Paciente paciente = pacienteRepositorio.buscarPaciente(cedula);

        if(paciente == null) throw new Exception("El paciente no existe");
        if(!paciente.getCedula().equals(cedula)) throw new Exception("La cedula es incorrecta");

        return paciente;
    }

    public List<Paciente> obtenerPacientes(){
        return pacienteRepositorio.obtenerPacientes();
    }
}
