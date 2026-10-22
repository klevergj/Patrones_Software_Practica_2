package p69.composite.presupuesto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * COMPOSITE: grupo que contiene partidas y otros grupos.
 * Delega recursivamente las operaciones comunes en sus hijos.
 */
public class GrupoPresupuestario extends ElementoPresupuesto {

    private final List<ElementoPresupuesto> hijos = new ArrayList<>();

    public GrupoPresupuestario(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    public void agregar(ElementoPresupuesto elemento) {
        hijos.add(elemento);
    }

    public void eliminar(ElementoPresupuesto elemento) {
        hijos.remove(elemento);
    }

    public List<ElementoPresupuesto> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    @Override
    public BigDecimal calcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ElementoPresupuesto hijo : hijos) {
            total = total.add(hijo.calcularValorTotal()); // recursión: hoja o grupo
        }
        return total;
    }

    @Override
    public void mostrarEstructura(int nivel) {
        System.out.printf("%s+ [%s] %s  (total: $%,.2f)%n",
                sangria(nivel), getCodigo(), getDescripcion(), calcularValorTotal());
        for (ElementoPresupuesto hijo : hijos) {
            hijo.mostrarEstructura(nivel + 1);
        }
    }
}
