# Ejercicio 4 — Instrumentación de `patternIndex` y reporte de caminos

Trabajo sobre `patternIndex()` (en `assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndex.java`).

## Instrumentación

Para poder analizar los caminos ejecutados agregué instrumentación a nivel de nodos del CFG dentro del método. En cada invocación se registra la secuencia exacta de nodos por los que pasa la ejecución.

Nodos instrumentados:

- `S` — inicio del método.
- `W` — condición del `while` principal.
- `I` — `if` que compara el primer carácter del patrón.
- `M` — bloque que se ejecuta cuando hay match inicial y se inicializan las variables.
- `FT` — condición verdadera del `for` interno.
- `IFM` — `if` de mismatch dentro del `for`.
- `MIS` — bloque de mismatch seguido de `break`.
- `FI` — paso de iteración del `for` cuando no hubo mismatch.
- `FF` — finalización del `for` sin haber ejecutado un `break`.
- `INC` — incremento `iSub++`.
- `R` — `return`.

El registro de los caminos se delega a `PatternIndexPathTracker`, que va anotando los nodos `hit` y al final genera una `Invocation` con `subject`, `pattern`, resultado y la lista de nodos recorridos.

## Suite

Suite en `PatternIndexInstrumentationCoverageTest.java`. Ejecuta los 10 casos de la tabla del enunciado:

1. `("a", "bc")` → `-1`
2. `("ab", "a")` → `0`
3. `("ab", "ab")` → `0`
4. `("ab", "ac")` → `-1`
5. `("ab", "b")` → `1`
6. `("ab", "c")` → `-1`
7. `("abc", "abc")` → `0`
8. `("abc", "abd")` → `-1`
9. `("abc", "ba")` → `-1`
10. `("abc", "bc")` → `1`

Después de correr la tabla, `@AfterClass` genera un reporte con:

- la secuencia de nodos por cada caso,
- la cobertura de arcos sobre el CFG instrumentado,
- la cobertura de prime paths,
- la lista de requisitos cubiertos y faltantes.

El reporte queda en `target/patternindex-path-report.txt`.

## Cómo correr

```bash
cd tp4/assignmnet-4-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 \
    -Dtest=PatternIndexInstrumentationCoverageTest test
```

## Resultados

Sobre el CFG instrumentado de `patternIndex`:

- **Cobertura de arcos**: `15 / 15` (100%).
- **Cobertura de prime paths**: `22 / 39`.

**Interpretación:**

- Los 10 casos de la tabla son suficientes para ejercitar todas las decisiones del método (EC al 100%).
- PPC no se completa, lo cual es esperable: PPC es estrictamente más fuerte que EC, así que una suite que satura EC no necesariamente cubre todos los prime paths. Los requisitos faltantes corresponden a combinaciones de iteraciones del bucle externo y del `for` interno que esos diez casos no llegan a ejercitar.

## Archivos

- [`PatternIndex.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndex.java) — método instrumentado.
- [`PatternIndexPathTracker.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndexPathTracker.java) — registro de caminos.
- [`PatternIndexInstrumentationCoverageTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp4/assignmnet-4-rodeghiero/src/test/java/assignment4_exercises/PatternIndexInstrumentationCoverageTest.java) — suite + reporte.

## Enlaces

- Enunciado: [`practico4.pdf`](/pdfs/tp4/practico4.pdf)
- Resolución: [`resolucion_practico4.pdf`](/pdfs/tp4/resolucion_practico4.pdf)
