# Práctico 5 — Testing de Software

## Documentos principales

- Enunciado: [`practico5.pdf`](/pdfs/tp5/practico5.pdf)
- Resolución: [`resolucion_practico5.pdf`](/pdfs/tp5/resolucion_practico5.pdf)

## Ejercicios

- `ejercicio1/` — cobertura lógica sobre cinco predicados (cláusulas, tablas de verdad, CC/PC/CACC/RACC).
- `ejercicio2/` — `checkIt()` vs `checkItExpand()`, suite CACC (T1) y Edge Coverage (T2), implementación JUnit.
- `ejercicio3/` — `Thermostat.turnHeaterOn()`: tests para CC sin PC, PC sin CC y CACC.
- `ejercicio4/` — `TriTyp.triang()`: tests CACC con instrumentación de predicados.

## Material de referencia

Está todo en `material/`:

- [Capítulo 8 — *Introduction to Software Testing*](/pdfs/tp5/material/Capitulo%208%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 09 — Logic expressions](/pdfs/tp5/material/notas-09-logicExpr.pdf)
- [Notas 09 — Logic expressions (parte 2)](/pdfs/tp5/material/notas-09-logicExpr-02.pdf)

## Cómo correr los tests

El código vive en `assignment-5-rodeghiero/`. Hay que usar JDK 17. Desde la carpeta del proyecto:

```bash
cd tp5/assignment-5-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Para correr una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=ThermostatExercise3CaccTest test
```

El `-Djacoco.skip=true` evita el problema con el plugin JaCoCo `0.8.2` del template, que no se lleva bien con JDK 17.
