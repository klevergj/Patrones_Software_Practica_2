package p69.composite.presupuesto;

import java.math.BigDecimal;

/**
 * COMPONENT: abstracción común para partidas individuales y grupos.
 * El cliente trabaja solo con este tipo.
 */
public abstract class ElementoPresupuesto {

    private final String codigo;
    private final String descripcion;

    protected ElementoPresupuesto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /** Valor total del elemento (propio o acumulado de sus hijos). */
    public abstract BigDecimal calcularValorTotal();

    /** Muestra la estructura con sangría según el nivel jerárquico. */
    public abstract void mostrarEstructura(int nivel);

    protected String sangria(int nivel) {
        return "    ".repeat(nivel);
    }
}
