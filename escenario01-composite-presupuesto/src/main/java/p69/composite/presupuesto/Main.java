package p69.composite.presupuesto;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Hojas
        ElementoPresupuesto licencias = new PartidaPresupuestaria("TI-01", "Licenciamiento de software", new BigDecimal("12000"));
        ElementoPresupuesto servidores = new PartidaPresupuestaria("TI-02-01", "Servidores", new BigDecimal("30000"));
        ElementoPresupuesto almacenamiento = new PartidaPresupuestaria("TI-02-02", "Almacenamiento", new BigDecimal("8500.50"));
        ElementoPresupuesto comunicaciones = new PartidaPresupuestaria("TI-02-03", "Comunicaciones", new BigDecimal("6200"));
        ElementoPresupuesto soporte = new PartidaPresupuestaria("TI-03", "Servicios de soporte", new BigDecimal("4300"));

        // Grupos (composites), con un grupo dentro de otro
        GrupoPresupuestario infraestructura = new GrupoPresupuestario("TI-02", "Infraestructura");
        infraestructura.agregar(servidores);
        infraestructura.agregar(almacenamiento);
        infraestructura.agregar(comunicaciones);

        GrupoPresupuestario ti = new GrupoPresupuestario("TI", "Tecnologías de la Información");
        ti.agregar(licencias);
        ti.agregar(infraestructura);
        ti.agregar(soporte);

        GrupoPresupuestario presupuesto = new GrupoPresupuestario("PRES-2026", "Presupuesto Institucional 2026");
        presupuesto.agregar(ti);

        // El cliente trata a todos por igual mediante ElementoPresupuesto
        System.out.println("=== Estructura del presupuesto ===");
        presupuesto.mostrarEstructura(0);

        System.out.println("\n=== Consultas uniformes ===");
        imprimir(licencias);        // hoja
        imprimir(infraestructura);  // grupo interno
        imprimir(presupuesto);      // grupo raíz

        // La estructura crece sin cambiar la lógica del cliente
        GrupoPresupuestario seguridad = new GrupoPresupuestario("TI-04", "Seguridad informática");
        seguridad.agregar(new PartidaPresupuestaria("TI-04-01", "Firewall", new BigDecimal("9000")));
        ti.agregar(seguridad);
        System.out.println("\n=== Tras agregar un nuevo grupo ===");
        imprimir(presupuesto);
    }

    /** Método cliente: no distingue entre partida y grupo. */
    private static void imprimir(ElementoPresupuesto e) {
        System.out.printf("%s - %s -> $%,.2f%n", e.getCodigo(), e.getDescripcion(), e.calcularValorTotal());
    }
}
