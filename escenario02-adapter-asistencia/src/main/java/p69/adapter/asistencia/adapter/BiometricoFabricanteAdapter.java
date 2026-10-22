package p69.adapter.asistencia.adapter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import p69.adapter.asistencia.dominio.ProveedorAsistencia;
import p69.adapter.asistencia.dominio.RegistroAsistencia;
import p69.adapter.asistencia.fabricante.BibliotecaBiometricoXZ;
import p69.adapter.asistencia.fabricante.MarcacionFabricante;

/**
 * ADAPTER (de objetos): implementa el contrato institucional y traduce las
 * solicitudes hacia la biblioteca del fabricante, transformando parámetros y resultados.
 */
public class BiometricoFabricanteAdapter implements ProveedorAsistencia {

    private final BibliotecaBiometricoXZ biblioteca;
    private final ZoneId zona;

    public BiometricoFabricanteAdapter(BibliotecaBiometricoXZ biblioteca, ZoneId zona) {
        this.biblioteca = biblioteca;
        this.zona = zona;
    }

    @Override
    public RegistroAsistencia obtenerAsistencia(String idColaborador, LocalDate fecha) {
        // 1. Traducir parámetros: fecha -> rango de instantes
        long desde = fecha.atStartOfDay(zona).toInstant().toEpochMilli();
        long hasta = fecha.plusDays(1).atStartOfDay(zona).toInstant().toEpochMilli();

        // 2. Delegar en la operación del fabricante
        List<MarcacionFabricante> marcaciones = biblioteca.recuperarMarcaciones(idColaborador, desde, hasta);

        // 3. Traducir resultado: colección de marcaciones -> registro normalizado
        LocalTime ingreso = null;
        LocalTime salida = null;
        for (MarcacionFabricante m : marcaciones) {
            LocalTime hora = Instant.ofEpochMilli(m.getInstanteEpochMillis()).atZone(zona).toLocalTime();
            if (m.getEvento() == MarcacionFabricante.EVENTO_ENTRADA && (ingreso == null || hora.isBefore(ingreso))) {
                ingreso = hora;   // primera entrada del día
            }
            if (m.getEvento() == MarcacionFabricante.EVENTO_SALIDA && (salida == null || hora.isAfter(salida))) {
                salida = hora;    // última salida del día
            }
        }
        return new RegistroAsistencia(idColaborador, fecha, ingreso, salida);
    }
}
