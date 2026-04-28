# Ejercicio 4

Se trabajó sobre el método ubicado en:

- `tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndex.java`

### Instrumentación agregada

Para poder analizar los caminos ejecutados, se agregó una instrumentación a nivel de nodos del CFG dentro del método `patternIndex()`. Esta instrumentación registra, en cada invocación, la secuencia exacta de nodos por la que pasa la ejecución.

Los nodos instrumentados son los siguientes:

- `S` (inicio del método).
- `W` (condición del `while` principal).
- `I` (`if` que compara el primer carácter del patrón).
- `M` (bloque que se ejecuta cuando se detecta un match inicial y se inicializan las variables auxiliares).
- `FT` (condición verdadera del `for` interno).
- `IFM` (`if` de mismatch dentro del `for`).
- `MIS` (bloque de mismatch seguido de `break`).
- `FI` (paso de iteración del `for` cuando no hubo mismatch).
- `FF` (finalización del `for` sin haber ejecutado un `break`).
- `INC` (incremento `iSub++`).
- `R` (sentencia `return`).

El registro de los caminos ejecutados se delega a una clase auxiliar creada específicamente para este ejercicio:

- `tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndexPathTracker.java`

### Suite JUnit pedida por la tabla del enunciado

La suite se implementó en:

- `tp4/assignmnet-4-rodeghiero/src/test/java/assignment4_exercises/PatternIndexInstrumentationCoverageTest.java`

Esta suite ejecuta exactamente los 10 casos indicados por la tabla del enunciado, junto con su valor esperado:

1. `("a", "bc")  -> -1`
2. `("ab", "a")  ->  0`
3. `("ab", "ab") ->  0`
4. `("ab", "ac") -> -1`
5. `("ab", "b")  ->  1`
6. `("ab", "c")  -> -1`
7. `("abc", "abc") ->  0`
8. `("abc", "abd") -> -1`
9. `("abc", "ba")  -> -1`
10. `("abc", "bc")  ->  1`

### Reporte de caminos ejecutados

La misma suite genera automáticamente un reporte de salida que contiene:

- la secuencia de nodos ejecutada por cada caso de test,
- la cobertura de arcos sobre el CFG instrumentado,
- la cobertura de caminos principales (prime paths),
- y la lista de requisitos cubiertos y faltantes para cada criterio.

Ubicación del reporte generado:

- `tp4/assignmnet-4-rodeghiero/target/patternindex-path-report.txt`

### Ejecución

Comando utilizado para correr la suite:

- `JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexInstrumentationCoverageTest test`

### Resultados de cobertura

Sobre el CFG instrumentado de `patternIndex`, la suite de la tabla obtiene:

- **Cobertura de arcos:** `15 / 15` (100%).
- **Cobertura de caminos principales:** `22 / 39`.

**Interpretación de los resultados:**

- La suite alcanza cobertura completa de arcos, lo que indica que los 10 casos de la tabla son suficientes para ejercitar todas las decisiones del método.
- En cambio, no se logra cobertura completa de caminos principales, lo cual era esperable: PPC es un criterio estrictamente más fuerte que EC, así que una suite que satura EC no necesariamente cubre todos los prime paths. Los requisitos faltantes corresponden a combinaciones de iteraciones del bucle externo y del `for` interno que esos diez casos puntuales no llegan a ejercitar.
