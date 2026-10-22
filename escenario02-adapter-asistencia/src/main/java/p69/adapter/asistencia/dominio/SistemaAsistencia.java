package p69.adapter.asistencia.dominio;

import java.time.LocalDate;

/** CLIENTE: sistema institucional. Solo conoce ProveedorAsistencia. */
public class SistemaAsistencia {

    private final ProveedorAsistencia proveedor;

    public SistemaAsistencia(ProveedorAsistencia proveedor) {
        this.proveedor = proveedor;
    }

    public void consultar(String idColaborador, LocalDate fecha) {
        RegistroAsistencia r = proveedor.obtenerAsistencia(idColaborador, fecha);
        System.out.println("   Colaborador: " + r.idColaborador()
                + " | Fecha: " + r.fecha()
                + " | Ingreso: " + (r.horaIngreso() == null ? "--" : r.horaIngreso())
                + " | Salida: " + (r.horaSalida() == null ? "--" : r.horaSalida()));
    }
}
