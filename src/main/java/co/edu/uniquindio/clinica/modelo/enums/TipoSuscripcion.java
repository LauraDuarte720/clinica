package co.edu.uniquindio.clinica.modelo.enums;


import lombok.Getter;

@Getter
public enum TipoSuscripcion {
    BASICA ("Básica"),
    PREMIUM ("Premium"),
    MENORES("Menores");


    private final String nombre;

    TipoSuscripcion(String nombre) {
        this.nombre = nombre;
    }
}
