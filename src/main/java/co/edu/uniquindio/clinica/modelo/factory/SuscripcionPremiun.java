package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoServicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SuscripcionPremiun implements Suscripcion {

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
                        .precio(TipoServicio.PSICOLOGIA.getPrecio())
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.ODONTOLOGIA.getNombre())
                        .tipoServicio(TipoServicio.ODONTOLOGIA)
                        .precio(TipoServicio.ODONTOLOGIA.getPrecio() * 0.40)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.PEDIATRIA.getNombre())
                        .tipoServicio(TipoServicio.PEDIATRIA)
                        .precio(TipoServicio.PEDIATRIA.getPrecio() * 0.50)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.TERAPIAFISICA.getNombre())
                        .tipoServicio(TipoServicio.TERAPIAFISICA)
                        .precio(TipoServicio.TERAPIAFISICA.getPrecio() * 0.65)
                        .build(),

                Servicio.builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(TipoServicio.VACUNACION.getNombre())
                        .tipoServicio(TipoServicio.VACUNACION)
                        .precio(TipoServicio.VACUNACION.getPrecio() * 0.30)
                        .build()
        );
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        return new Factura(LocalDateTime.now(), UUID.randomUUID().toString(),servicio.getPrecio(), servicio.getTipoServicio().getPrecio());
    }
}
