# Ejercicio 2

En este ejercicio trabajé con el predicado del método `checkIt()`:

`p = a && (b || c)`

La idea fue resolver lo que pide cada inciso y, además, dejar implementadas las suites JUnit en el proyecto.

## a) Transformar `checkIt()` a `checkItExpand()` e instrumentar

La transformación pedida busca que cada decisión del `if` use exactamente una variable booleana.

Versión original (conceptual):

```java
if (a && (b || c)) {
    // P true
} else {
    // P false
}
```

Versión expandida (`checkItExpand`), manteniendo la misma semántica:

```java
if (a) {
    if (b) {
        // P true
    } else {
        if (c) {
            // P true
        } else {
            // P false
        }
    }
} else {
    // P false
}
```

Implementación en el proyecto:

- [CheckIt.java](../assignment-5-rodeghiero/src/main/java/assignment5_exercises/checkit/CheckIt.java)

Instrumentación que agregué:

- `checkItExpand()` devuelve un `ExecutionTrace` con:
1. nodos recorridos (`getNodes()`)
2. aristas recorridas (`getEdges()`), armadas como pares consecutivos `N_i -> N_{i+1}`

Nodos definidos para el análisis:

- `START`
- `A` (decisión sobre `a`)
- `B` (decisión sobre `b`)
- `C` (decisión sobre `c`)
- `TRUE`
- `FALSE`
- `END`

Con esto se puede verificar cobertura de aristas directamente en los tests.

## b) Derivar T1 (CACC para `checkIt`) y T2 (Edge Coverage para `checkItExpand`)

### T1 para CACC sobre `p = a && (b || c)`

Para CACC, cada cláusula debe actuar como cláusula mayor al menos una vez, y tiene que existir un par de casos donde al cambiar esa cláusula cambie el valor de `p`.

Suite propuesta:

- `t1 = (T, T, F)`
- `t2 = (F, T, F)`
- `t3 = (T, F, F)`
- `t4 = (T, F, T)`

Justificación por cláusula mayor:

1. Mayor `a`:
- Par `(t1, t2)` = `(T,T,F)` vs `(F,T,F)`
- Cláusulas menores fijas: `b=T`, `c=F`
- `p` cambia de `T` a `F`

2. Mayor `b`:
- Par `(t1, t3)` = `(T,T,F)` vs `(T,F,F)`
- Cláusulas menores fijas: `a=T`, `c=F`
- `p` cambia de `T` a `F`

3. Mayor `c`:
- Par `(t4, t3)` = `(T,F,T)` vs `(T,F,F)`
- Cláusulas menores fijas: `a=T`, `b=F`
- `p` cambia de `T` a `F`

Conclusión: `T1` satisface CACC.

### T2 para Edge Coverage sobre `checkItExpand`

Suite propuesta:

- `e1 = (F, F, F)`
- `e2 = (T, T, F)`
- `e3 = (T, F, T)`
- `e4 = (T, F, F)`

Aristas esperadas del CFG expandido:

1. `START->A`
2. `A->B`
3. `A->FALSE`
4. `B->TRUE`
5. `B->C`
6. `C->TRUE`
7. `C->FALSE`
8. `TRUE->END`
9. `FALSE->END`

Con `e1..e4` se cubren las 9 aristas, así que `T2` satisface Edge Coverage para `checkItExpand()`.

### ¿`T2` satisface CACC sobre `checkIt`?

No.

Para que `a` determine `p`, hace falta que `b || c = true`.
En `T2` hay casos con `a=true` y `b||c=true` (`e2`, `e3`), pero no hay ningún caso con `a=false` y `b||c=true`.

Por ese motivo falta el par correlacionado para cláusula mayor `a`, entonces `T2` no satisface CACC.

## c) Implementación de T1 y T2 como suites JUnit

Tests implementados:

- [CheckItT1CaccTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/checkit/CheckItT1CaccTest.java)
- [CheckItT2EdgeCoverageTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/checkit/CheckItT2EdgeCoverageTest.java)

Qué valida cada suite:

1. `CheckItT1CaccTest`
- verifica los tres pares CACC (una vez por cada cláusula mayor)

2. `CheckItT2EdgeCoverageTest`
- verifica que la unión de aristas recorridas por `e1..e4` coincide con el conjunto total esperado
- verifica explícitamente que esa suite no cumple CACC para la cláusula `a`

Ejecución:

Desde `tp5/assignment-5-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado obtenido en este entorno:

- `BUILD SUCCESS`
- `Tests run: 5, Failures: 0, Errors: 0, Skipped: 0`

Nota:

Se usa `-Djacoco.skip=true` porque el plugin JaCoCo del template (`0.8.2`) no es compatible con la JVM disponible y corta el fork de Surefire.
