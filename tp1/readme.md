# Práctico 1 — Testing de Software

Resolución del primer práctico de la materia. El TP introduce el vocabulario básico del testing de software (*fault*, *error* y *failure*), el modelo RIPR como criterio para razonar sobre la detectabilidad de un defecto, y arranca con las primeras pruebas en JUnit siguiendo el patrón *Arrange–Act–Assert*. Sobre el final aparece el caso clásico de Bloch (`Point` y `ColorPoint`) que ilustra los problemas de mantener el contrato de `equals` en jerarquías por herencia.

## Documentos principales

- **Enunciado:** [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- **Resolución (PDF):** [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- **Resumen teórico (PDF):** [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
- **Fuente LaTeX:** `resolucion_practico1.tex`, `resumen-teorico-testing-tp1.tex`

## Ejercicios

- `ejercicio1/` — lectura de los capítulos 1 y 2 de *Introduction to Software Testing* (Ammann & Offutt).
- `ejercicio2/` — diferencia entre *fault* y *failure*, y el rol del *error* como estado interno intermedio.
- `ejercicio3/` — cuatro programas defectuosos: identificación del defecto, reparación y casos según RIPR.
- `ejercicio4/` — traslado de las pruebas del Ejercicio 3 a JUnit y análisis con el modelo RIPR.
- `ejercicio5/` — análisis del ejemplo de Bloch: `Point`, `ColorPoint` y el contrato de `equals`.
- `ejercicio6/` — reconstrucción de `Point` y `PointTest`, consistencia entre `equals` y `hashCode`.
- `ejercicio7/` — `PointSet` apoyado en `HashSet<Point>`, tests con el patrón Arrange–Act–Assert.

## Material de referencia

Los apuntes y capítulos usados están en `material/`:

- `Capitulos 1 y 2 - Introduction to Software Testing.pdf` — Ammann & Offutt, capítulos 1 y 2.
- `notas-00-testing-de-software.pdf`, `notas-01-testing-de-software.pdf`, `notas-02-ts.pdf` — notas de la cátedra para las primeras unidades.

## Cómo ejecutar la suite

Los ejercicios con código (3 al 7) viven dentro de proyectos Maven autocontenidos. Para correrlos:

```bash
cd ejercicio4         # o el ejercicio que corresponda
mvn -Dmaven.repo.local=.m2 test
```

El flag `-Dmaven.repo.local=.m2` mantiene el repositorio Maven dentro de la carpeta del ejercicio para no contaminar `~/.m2/` del sistema.
