# Ejercicio 4 — `TriTyp.triang()` con CACC

Tests JUnit para `TriTyp.triang()` que satisfacen cobertura correlacionada de cláusulas activas (CACC).

## Predicados considerados

Dentro de `triang()` tomé estos predicados:

1. `P1`: `(s1<=0) || (s2<=0) || (s3<=0)`
2. `P2`: `(s1==s2)`
3. `P3`: `(s1==s3)`
4. `P4`: `(s2==s3)`
5. `P5`: `(triOut==0)`
6. `P6`: `(s1+s2<=s3) || (s2+s3<=s1) || (s1+s3<=s2)`
7. `P7`: `(triOut>3)`
8. `P8`: `(triOut==1) && (s1+s2>s3)`
9. `P9`: `(triOut==2) && (s1+s3>s2)`
10. `P10`: `(triOut==3) && (s2+s3>s1)`

Para CACC:

- en los predicados con varias cláusulas (`P1`, `P6`, `P8`, `P9`, `P10`) verifiqué pares por cláusula mayor;
- en los predicados de una sola cláusula (`P2`, `P3`, `P4`, `P5`, `P7`) alcanza con cubrir `true` y `false`.

## Suite

Casos de prueba `(s1, s2, s3)`:

- `(-1,1,1)`, `(1,-1,1)`, `(1,1,-1)`, `(1,1,1)`
- `(1,2,3)`, `(2,3,4)`, `(3,1,2)`, `(1,3,2)`
- `(1,2,1)`, `(2,2,1)`, `(1,1,2)`, `(2,1,2)`, `(1,2,2)`, `(2,1,1)`

## Justificación CACC (pares por predicado)

### P1 — `(s1<=0) || (s2<=0) || (s3<=0)`

- mayor `c1`: `(-1,1,1)` vs `(1,1,1)`
- mayor `c2`: `(1,-1,1)` vs `(1,1,1)`
- mayor `c3`: `(1,1,-1)` vs `(1,1,1)`

### P6 — `(s1+s2<=s3) || (s2+s3<=s1) || (s1+s3<=s2)`

- mayor `d1`: `(1,2,3)` vs `(2,3,4)`
- mayor `d2`: `(3,1,2)` vs `(2,3,4)`
- mayor `d3`: `(1,3,2)` vs `(2,3,4)`

### P8 — `(triOut==1) && (s1+s2>s3)`

- mayor `e1`: `(1,2,1)` vs `(2,2,1)`
- mayor `e2`: `(2,2,1)` vs `(1,1,2)`

### P9 — `(triOut==2) && (s1+s3>s2)`

- mayor `f1`: `(1,1,2)` vs `(2,1,2)`
- mayor `f2`: `(1,2,1)` vs `(2,1,2)`

### P10 — `(triOut==3) && (s2+s3>s1)`

- mayor `g1`: `(1,1,2)` vs `(1,2,2)`
- mayor `g2`: `(2,1,1)` vs `(1,2,2)`

La misma suite cubre `true/false` para `P2`, `P3`, `P4`, `P5` y `P7`.

## Cómo lo verifico en código

`TriTypTraceSupport` instrumenta los predicados y cláusulas en los tests, y además valida que la traza dé la misma salida que `TriTyp.triang()`. Eso evita que el modelo de trazas se despegue del código real.

## Ejecución

```bash
cd tp5/assignment-5-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

## Archivos

- [`TriTyp.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/main/java/assignment5_exercises/triangle/TriTyp.java)
- [`TriTypExercise4CaccTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/triangle/TriTypExercise4CaccTest.java) — suite CACC.
- [`TriTypTraceSupport.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/triangle/TriTypTraceSupport.java) — instrumentación.

## Enlaces

- Enunciado: [`practico5.pdf`](/pdfs/tp5/practico5.pdf)
- Resolución: [`resolucion_practico5.pdf`](/pdfs/tp5/resolucion_practico5.pdf)
