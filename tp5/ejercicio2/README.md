# Ejercicio 2 — `checkIt()` vs `checkItExpand()`: CACC y Edge Coverage

Trabajo sobre el predicado del método `checkIt()`:

```
p = a && (b || c)
```

## a) Expandir a `checkItExpand()` con instrumentación

La transformación pedida busca que cada decisión del `if` use **una sola variable booleana**.

Versión original:

```java
if (a && (b || c)) {
    // P true
} else {
    // P false
}
```

Versión expandida (`checkItExpand`), con la misma semántica:

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

### Instrumentación

`checkItExpand()` devuelve un `ExecutionTrace` con:

1. los nodos recorridos (`getNodes()`),
2. las aristas recorridas (`getEdges()`), armadas como pares consecutivos `N_i -> N_{i+1}`.

Nodos definidos: `START`, `A`, `B`, `C`, `TRUE`, `FALSE`, `END`.

Con eso se puede verificar cobertura de aristas directamente en los tests.

## b) Derivar T1 (CACC sobre `checkIt`) y T2 (Edge Coverage sobre `checkItExpand`)

### T1 para CACC

Para CACC, cada cláusula tiene que actuar como mayor al menos una vez, con un par de casos donde al cambiarla cambia `p`.

Suite:

- `t1 = (T, T, F)`
- `t2 = (F, T, F)`
- `t3 = (T, F, F)`
- `t4 = (T, F, T)`

Justificación:

- **mayor `a`** → par `(t1, t2) = (T,T,F)` vs `(F,T,F)`. Menores `b=T`, `c=F`. `p` pasa de `T` a `F`.
- **mayor `b`** → par `(t1, t3) = (T,T,F)` vs `(T,F,F)`. Menores `a=T`, `c=F`. `p` pasa de `T` a `F`.
- **mayor `c`** → par `(t4, t3) = (T,F,T)` vs `(T,F,F)`. Menores `a=T`, `b=F`. `p` pasa de `T` a `F`.

Conclusión: T1 satisface CACC.

### T2 para Edge Coverage

Suite:

- `e1 = (F, F, F)`
- `e2 = (T, T, F)`
- `e3 = (T, F, T)`
- `e4 = (T, F, F)`

Aristas del CFG expandido:

1. `START -> A`
2. `A -> B`
3. `A -> FALSE`
4. `B -> TRUE`
5. `B -> C`
6. `C -> TRUE`
7. `C -> FALSE`
8. `TRUE -> END`
9. `FALSE -> END`

`e1..e4` cubren las 9 aristas, así que T2 satisface Edge Coverage.

### ¿T2 satisface CACC sobre `checkIt`?

**No.** Para que `a` determine `p` hace falta que `b || c = true`. En T2 hay casos con `a=true` y `b||c=true` (`e2`, `e3`), pero no hay ningún caso con `a=false` y `b||c=true`. Falta el par correlacionado para la cláusula mayor `a`, así que T2 no satisface CACC.

## c) Implementación de T1 y T2 como suites JUnit

- `CheckItT1CaccTest` valida los tres pares CACC (uno por cláusula mayor).
- `CheckItT2EdgeCoverageTest` valida que la unión de aristas recorridas por `e1..e4` coincida con el conjunto total, y además verifica explícitamente que esa suite **no** cumple CACC para la cláusula `a`.

Por ejemplo:

```java
@Test
public void t1ContainsAValidCaccPairForMajorA() {
    boolean pWhenATrue = CheckIt.checkIt(true, true, false);
    boolean pWhenAFalse = CheckIt.checkIt(false, true, false);
    assertTrue(pWhenATrue);
    assertFalse(pWhenAFalse);
}
```

### Ejecución

```bash
cd tp5/assignment-5-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: `BUILD SUCCESS`, `Tests run: 5, Failures: 0, Errors: 0, Skipped: 0`.

## Archivos

- [`CheckIt.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/main/java/assignment5_exercises/checkit/CheckIt.java) — implementación con `checkIt`, `checkItExpand` y `ExecutionTrace`.
- [`CheckItT1CaccTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/checkit/CheckItT1CaccTest.java) — T1 (CACC).
- [`CheckItT2EdgeCoverageTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/checkit/CheckItT2EdgeCoverageTest.java) — T2 (Edge Coverage).

## Enlaces

- Enunciado: [`practico5.pdf`](/pdfs/tp5/practico5.pdf)
- Resolución: [`resolucion_practico5.pdf`](/pdfs/tp5/resolucion_practico5.pdf)
