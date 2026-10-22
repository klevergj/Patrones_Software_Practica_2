# PDS – Actividad 02: Patrones de diseño estructurales

Maestría en Software – Patrones de Diseño de Software (UPS).

| Escenario | Patrón | Carpeta |
|---|---|---|
| 01 – Estructura jerárquica de un presupuesto | **Composite** | `escenario01-composite-presupuesto` |
| 02 – Asistencia con dispositivos biométricos de otro fabricante | **Adapter** (de objetos) | `escenario02-adapter-asistencia` |

Los diagramas de clases UML están en `diagramas/` (PNG y fuente Graphviz `.dot`).

## Requisitos
- JDK 17 o superior (se usa `record`). Probado con JDK 21. Sin dependencias externas.

## Compilar y ejecutar

### Escenario 01 – Composite
```bash
cd escenario01-composite-presupuesto
mkdir out -Force
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out p69.composite.presupuesto.Main
```

### Escenario 02 – Adapter
```bash
cd escenario02-adapter-asistencia
mkdir out -Force
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out p69.adapter.asistencia.Main
```
(En Windows/PowerShell conviene abrir cada carpeta como proyecto en IntelliJ IDEA, Eclipse o VS Code y ejecutar `Main.java`.)

## Participantes de cada patrón
**Composite:** Component = `ElementoPresupuesto`, Hoja = `PartidaPresupuestaria`, Composite = `GrupoPresupuestario`, Cliente = `Main`.

**Adapter:** Target = `ProveedorAsistencia`, Cliente = `SistemaAsistencia`, Adaptee = `BibliotecaBiometricoXZ`, Adapter = `BiometricoFabricanteAdapter`.

La salida esperada de cada `Main` está en `salida.txt` de su carpeta.
