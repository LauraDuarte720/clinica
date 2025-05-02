package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;


public class PacienteRepositorio {
    private List<Paciente> pacientes;

    public PacienteRepositorio() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void eliminarPaciente(Paciente paciente){
        pacientes.remove(paciente);
    }

    public void actualizarPaciente(Paciente paciente){
        pacientes.set(pacientes.indexOf(paciente), paciente);
    }

    public Paciente buscarPaciente(String id) {
        return pacientes.stream()
                .filter(u -> u.getCedula().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }
}
