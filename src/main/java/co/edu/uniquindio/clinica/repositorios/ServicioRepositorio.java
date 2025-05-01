package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.Servicio;

import java.util.List;

public class ServicioRepositorio {
    private List<Servicio>servicios;

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public void eliminarServicio(Servicio servicio) {
        servicios.remove(servicio);
    }

    public void actualizarServicio(Servicio servicio) {
        servicios.set(servicios.indexOf(servicio), servicio);
    }

    public Servicio buscarServicio(String id) {
        return servicios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Servicio> obtenerServicios() {
        return servicios;
    }

}
