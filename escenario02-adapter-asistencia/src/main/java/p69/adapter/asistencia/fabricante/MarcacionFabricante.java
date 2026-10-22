package p69.adapter.asistencia.fabricante;

/** Tipo de dato propio del fabricante (no modificable). */
public class MarcacionFabricante {

    public static final int EVENTO_ENTRADA = 1;
    public static final int EVENTO_SALIDA = 2;

    private final String codigoEmpleado;
    private final long instanteEpochMillis;
    private final int evento;

    public MarcacionFabricante(String codigoEmpleado, long instanteEpochMillis, int evento) {
        this.codigoEmpleado = codigoEmpleado;
        this.instanteEpochMillis = instanteEpochMillis;
        this.evento = evento;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public long getInstanteEpochMillis() { return instanteEpochMillis; }
    public int getEvento() { return evento; }
}
