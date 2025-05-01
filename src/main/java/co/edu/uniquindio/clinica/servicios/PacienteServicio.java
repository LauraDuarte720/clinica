package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.repositorios.PacienteRepositorio;

public class PacienteServicio {

    private final PacienteRepositorio pacienteRepositorio;

    public PacienteServicio() {
        this.pacienteRepositorio = new PacienteRepositorio();
    }

    public Paciente registrarPaciente(String telefono, String nombre, String cedula, String email) throws Exception{
        if(telefono == null || telefono.isEmpty()) throw new Exception("El telefono es obligatorio");
        if(nombre == null || nombre.isEmpty()) throw new Exception("El nombre es obligatorio");
        if(cedula == null || cedula.isEmpty()) throw new Exception("El cedula es obligatorio");
        cedula
    }
}
