---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp4/ejercicio4/"
description: "Contenido importado desde tp4/ejercicio4/README.md"
---

# Ejercicio 4

Se trabajo sobre:

- `tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndex.java`

### Instrumentacion agregada

Se agrego una instrumentacion de nodos CFG dentro de `patternIndex()` para registrar el camino ejecutado por cada invocacion.

Nodos instrumentados:

- `S` (inicio)
- `W` (condicion del while)
- `I` (if del primer caracter)
- `M` (se detecta match inicial y se setean variables)
- `FT` (for cond true)
- `IFM` (if de mismatch dentro del for)
- `MIS` (bloque de mismatch + break)
- `FI` (paso de iteracion del for sin mismatch)
- `FF` (for finaliza sin break)
- `INC` (`iSub++`)
- `R` (return)

Archivo nuevo para tracking:

- `tp4/assignmnet-4-rodeghiero/src/main/java/assignment4_exercises/PatternIndexPathTracker.java`

### Suite JUnit pedida por la tabla

Se implemento en:

- `tp4/assignmnet-4-rodeghiero/src/test/java/assignment4_exercises/PatternIndexInstrumentationCoverageTest.java`

La suite ejecuta exactamente estos 10 casos:

1. `("a", "bc") -> -1`
2. `("ab", "a") -> 0`
3. `("ab", "ab") -> 0`
4. `("ab", "ac") -> -1`
5. `("ab", "b") -> 1`
6. `("ab", "c") -> -1`
7. `("abc", "abc") -> 0`
8. `("abc", "abd") -> -1`
9. `("abc", "ba") -> -1`
10. `("abc", "bc") -> 1`

### Reporte de caminos ejecutados

La misma suite genera automaticamente un reporte con:

- caminos ejecutados por cada caso de test,
- cobertura de arcos del CFG instrumentado,
- cobertura de caminos principales (prime paths),
- lista de requisitos cubiertos/faltantes.

Ubicacion del reporte:

- `tp4/assignmnet-4-rodeghiero/target/patternindex-path-report.txt`

### Ejecucion

Comando usado:

- `JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexInstrumentationCoverageTest test`

### Resultado de cobertura (con la suite de la tabla)

Sobre el CFG instrumentado de `patternIndex`:

- Cobertura de arcos: `15 / 15` (100%)
- Cobertura de caminos principales: `22 / 39`

Interpretacion:

- La suite de la tabla alcanza cobertura completa de arcos.
- No alcanza cobertura completa de caminos principales (quedan requisitos faltantes), lo cual es esperable porque PPC es mas fuerte que EC.
