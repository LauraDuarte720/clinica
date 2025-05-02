package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.Cita;

import java.util.ArrayList;
import java.util.List;

public class CitaRepositorio {
    private List<Cita> citas;

    public CitaRepositorio() {
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public void eliminarCita(Cita cita) {
        citas.remove(cita);
    }

    public void actualizarCita(Cita cita) {
        citas.set(citas.indexOf(cita), cita);
    }

    public Cita buscarCita(String id) {
        return citas.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Cita> obtenerCitas() {
        return citas;
    }
}


