---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp5/ejercicio4/"
description: "Contenido importado desde tp5/ejercicio4/README.md"
---

# Ejercicio 4

En este ejercicio escribí tests JUnit para `TriTyp.triang()` buscando satisfacer cobertura correlacionada de cláusulas activas (CACC).

Archivo bajo test:

- [TriTyp.java](../assignment-5-rodeghiero/src/main/java/assignment5_exercises/triangle/TriTyp.java)

## Predicados considerados

Dentro de `triang()` tomé estos predicados para el análisis:

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

- en predicados con varias cláusulas (`P1`, `P6`, `P8`, `P9`, `P10`) verifiqué pares por cláusula mayor;
- en predicados de una sola cláusula (`P2`, `P3`, `P4`, `P5`, `P7`) pedí cubrir `true` y `false`.

## Suite usada

Casos de prueba `(s1,s2,s3)`:

- `(-1,1,1)`, `(1,-1,1)`, `(1,1,-1)`, `(1,1,1)`
- `(1,2,3)`, `(2,3,4)`, `(3,1,2)`, `(1,3,2)`
- `(1,2,1)`, `(2,2,1)`, `(1,1,2)`, `(2,1,2)`, `(1,2,2)`, `(2,1,1)`

## Justificación CACC (pares principales)

### P1

- Cláusula mayor `c1`: `(-1,1,1)` vs `(1,1,1)`
- Cláusula mayor `c2`: `(1,-1,1)` vs `(1,1,1)`
- Cláusula mayor `c3`: `(1,1,-1)` vs `(1,1,1)`

### P6

- Cláusula mayor `d1`: `(1,2,3)` vs `(2,3,4)`
- Cláusula mayor `d2`: `(3,1,2)` vs `(2,3,4)`
- Cláusula mayor `d3`: `(1,3,2)` vs `(2,3,4)`

### P8

- Cláusula mayor `e1`: `(1,2,1)` vs `(2,2,1)`
- Cláusula mayor `e2`: `(2,2,1)` vs `(1,1,2)`

### P9

- Cláusula mayor `f1`: `(1,1,2)` vs `(2,1,2)`
- Cláusula mayor `f2`: `(1,2,1)` vs `(2,1,2)`

### P10

- Cláusula mayor `g1`: `(1,1,2)` vs `(1,2,2)`
- Cláusula mayor `g2`: `(2,1,1)` vs `(1,2,2)`

Además, la misma suite cubre `true/false` para `P2`, `P3`, `P4`, `P5` y `P7`.

## Implementación

Tests y soporte:

- [TriTypExercise4CaccTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/triangle/TriTypExercise4CaccTest.java)
- [TriTypTraceSupport.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/triangle/TriTypTraceSupport.java)

`TriTypTraceSupport` instrumenta en tests los predicados y cláusulas, y además valida que la traza tenga la misma salida que `TriTyp.triang()`. De esa manera, el modelo de trazas no se despega del código real.

## Ejecución

Desde `tp5/assignment-5-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```
