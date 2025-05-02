package co.edu.uniquindio.clinica.modelo.enums;

import lombok.Getter;

@Getter

public enum TipoServicio {
    CONSULTAGENERAL("Consulta general", 8000),
    PSICOLOGIA("Psicologia", 6000),
    ODONTOLOGIA("Odontología", 4000),
    PEDIATRIA ("Pediatría", 14000),
    TERAPIAFISICA("Terapia física", 11000),
    VACUNACION("Vacunación", 6400);


    private final String nombre;
    private final double precio;

    TipoServicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

}
