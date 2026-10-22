package p69.adapter.asistencia.fabricante;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * ADAPTEE: biblioteca del nuevo fabricante. Su interfaz NO coincide con el contrato
 * institucional: recupera marcaciones por rango de instantes, no la asistencia diaria.
 * No se puede modificar (se simula el dispositivo con datos en memoria).
 */
public class BibliotecaBiometricoXZ {

    private final List<MarcacionFabricante> almacen = new ArrayList<>();

    public BibliotecaBiometricoXZ() {
        ZoneId zona = ZoneId.of("America/Guayaquil");
        cargar("C-100", LocalDateTime.of(2026, 9, 24, 7, 55), MarcacionFabricante.EVENTO_ENTRADA, zona);
        cargar("C-100", LocalDateTime.of(2026, 9, 24, 13, 0), MarcacionFabricante.EVENTO_SALIDA, zona);  // salida a almuerzo
        cargar("C-100", LocalDateTime.of(2026, 9, 24, 14, 0), MarcacionFabricante.EVENTO_ENTRADA, zona);
        cargar("C-100", LocalDateTime.of(2026, 9, 24, 17, 10), MarcacionFabricante.EVENTO_SALIDA, zona);
        cargar("C-200", LocalDateTime.of(2026, 9, 24, 9, 5), MarcacionFabricante.EVENTO_ENTRADA, zona);  // sin salida
    }

    private void cargar(String cod, LocalDateTime t, int evento, ZoneId zona) {
        almacen.add(new MarcacionFabricante(cod, t.atZone(zona).toInstant().toEpochMilli(), evento));
    }

    /** Operación propia del fabricante. */
    public List<MarcacionFabricante> recuperarMarcaciones(String codigoEmpleado, long desdeMillis, long hastaMillis) {
        List<MarcacionFabricante> resultado = new ArrayList<>();
        for (MarcacionFabricante m : almacen) {
            if (m.getCodigoEmpleado().equals(codigoEmpleado)
                    && m.getInstanteEpochMillis() >= desdeMillis
                    && m.getInstanteEpochMillis() < hastaMillis) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
