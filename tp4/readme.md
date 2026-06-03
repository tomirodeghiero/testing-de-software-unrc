# Práctico 4 — Testing de Software

## Documentos principales

- Enunciado: [`practico4.pdf`](/pdfs/tp4/practico4.pdf)
- Resolución: [`resolucion_practico4.pdf`](/pdfs/tp4/resolucion_practico4.pdf)

## Ejercicios

- `ejercicio1/` — cobertura sobre grafo de 4 nodos (NC, EC, EPC).
- `ejercicio2/` — cobertura sobre grafo de 7 nodos, *sidetrips* y PPC.
- `ejercicio3/` — CFG de `fmtRewrap` y suites para NC, EC y PPC con *Best Effort Touring*.
- `ejercicio4/` — instrumentación de `patternIndex` y reporte de caminos ejecutados.

## Material de referencia

- [Capítulo 7 — *Introduction to Software Testing*](/pdfs/tp4/materiales/Capitulo%207%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 07 — Graph intro](/pdfs/tp4/materiales/notas-07-graph-intro.pdf)
- [Notas 08 — Graph from source code](/pdfs/tp4/materiales/notas-08-graph-from%20source-code.pdf)

## Cómo correr los tests

El código se encuentra en `assignmnet-4-rodeghiero/`. Hay que usar JDK 17 porque la build se apoya en JaCoCo para reportar cobertura. Desde la carpeta del proyecto:

```bash
cd tp4/assignmnet-4-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 test
```

Para correr una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 \
    -Dtest=FmtRewrapNodeCoverageTest test
```
