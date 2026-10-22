package p69.composite.presupuesto;

import java.math.BigDecimal;

/** HOJA: partida individual. No tiene hijos; su total es su valor asignado. */
public class PartidaPresupuestaria extends ElementoPresupuesto {

    private final BigDecimal valorAsignado;

    public PartidaPresupuestaria(String codigo, String descripcion, BigDecimal valorAsignado) {
        super(codigo, descripcion);
        this.valorAsignado = valorAsignado;
    }

    @Override
    public BigDecimal calcularValorTotal() {
        return valorAsignado;
    }

    @Override
    public void mostrarEstructura(int nivel) {
        System.out.printf("%s- [%s] %s: $%,.2f%n",
                sangria(nivel), getCodigo(), getDescripcion(), valorAsignado);
    }
}
