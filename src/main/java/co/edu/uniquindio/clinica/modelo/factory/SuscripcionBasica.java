package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SuscripcionBasica implements Suscripcion {

    @Override
    public List<Servicio> getServiciosDisponibles() {

        return List.of(
                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.CONSULTAGENERAL.getNombre())
                        .tipoServicio(TipoServicio.CONSULTAGENERAL)
                        .precio(TipoServicio.CONSULTAGENERAL.getPrecio() * 0.60)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.PSICOLOGIA.getNombre())
                        .tipoServicio(TipoServicio.PSICOLOGIA)
                        .precio(TipoServicio.PSICOLOGIA.getPrecio() * 0.90)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.ODONTOLOGIA.getNombre())
                        .tipoServicio(TipoServicio.ODONTOLOGIA)
                        .precio(TipoServicio.ODONTOLOGIA.getPrecio() * 0.90)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.PEDIATRIA.getNombre())
                        .tipoServicio(TipoServicio.PEDIATRIA)
                        .precio(TipoServicio.PEDIATRIA.getPrecio())
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.TERAPIAFISICA.getNombre())
                        .tipoServicio(TipoServicio.TERAPIAFISICA)
                        .precio(TipoServicio.TERAPIAFISICA.getPrecio())
                        .build(),


                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.VACUNACION.getNombre())
                        .tipoServicio(TipoServicio.VACUNACION)
                        .precio(TipoServicio.VACUNACION.getPrecio() * 0.95)
                        .build()
        );
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        return new Factura(LocalDateTime.now(), UUID.randomUUID().toString(),servicio.getPrecio(), servicio.getTipoServicio().getPrecio());
    }
}
