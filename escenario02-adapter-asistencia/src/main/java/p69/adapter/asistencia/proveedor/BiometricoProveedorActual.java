package p69.adapter.asistencia.proveedor;

import java.time.LocalDate;
import java.time.LocalTime;

import p69.adapter.asistencia.dominio.ProveedorAsistencia;
import p69.adapter.asistencia.dominio.RegistroAsistencia;

/**
 * Proveedor histórico: ya cumple el contrato, no necesita adaptación.
 * (Simulado con un dato fijo para la demostración.)
 */
public class BiometricoProveedorActual implements ProveedorAsistencia {

    @Override
    public RegistroAsistencia obtenerAsistencia(String idColaborador, LocalDate fecha) {
        return new RegistroAsistencia(idColaborador, fecha, LocalTime.of(8, 0), LocalTime.of(17, 0));
    }
}
