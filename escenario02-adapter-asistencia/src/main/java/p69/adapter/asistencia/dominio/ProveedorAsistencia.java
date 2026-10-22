package p69.adapter.asistencia.dominio;

import java.time.LocalDate;

/** TARGET: contrato estable que utiliza el sistema institucional. */
public interface ProveedorAsistencia {

    RegistroAsistencia obtenerAsistencia(String idColaborador, LocalDate fecha);
}
