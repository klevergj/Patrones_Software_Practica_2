package p69.adapter.asistencia;

import java.time.LocalDate;
import java.time.ZoneId;

import p69.adapter.asistencia.adapter.BiometricoFabricanteAdapter;
import p69.adapter.asistencia.dominio.ProveedorAsistencia;
import p69.adapter.asistencia.dominio.SistemaAsistencia;
import p69.adapter.asistencia.fabricante.BibliotecaBiometricoXZ;
import p69.adapter.asistencia.proveedor.BiometricoProveedorActual;

public class Main {

    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2026, 9, 24);

        ProveedorAsistencia actual = new BiometricoProveedorActual();
        ProveedorAsistencia nuevo = new BiometricoFabricanteAdapter(
                new BibliotecaBiometricoXZ(), ZoneId.of("America/Guayaquil"));

        // El sistema institucional es el mismo; solo cambia el proveedor inyectado.
        System.out.println("== Proveedor actual (ya compatible) ==");
        new SistemaAsistencia(actual).consultar("C-100", fecha);

        System.out.println("== Nuevo fabricante (mediante Adapter) ==");
        SistemaAsistencia sistema = new SistemaAsistencia(nuevo);
        sistema.consultar("C-100", fecha);
        sistema.consultar("C-200", fecha);  // solo tiene ingreso
        sistema.consultar("C-300", fecha);  // sin marcaciones
    }
}
