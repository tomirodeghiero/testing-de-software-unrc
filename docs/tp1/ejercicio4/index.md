---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp1/ejercicio4/"
description: "Contenido importado desde tp1/ejercicio4/README.md"
---

# Ejercicio 4 — Reparación de programas y pruebas JUnit

## Consigna

Tomando los cuatro programas del Ejercicio 3, hay que:

- Aplicar las reparaciones identificadas.
- Trasladar los casos de prueba a **JUnit**, de modo que las correcciones queden verificadas empíricamente.
- Explicar, para cada caso, **por qué el test detecta la falla** usando el modelo **RIPR** (*Reachability*, *Infection*, *Propagation*, *Revealability*).

## Archivos

- `src/main/java/OriginalPrograms.java` — versión original con los defectos.
- `src/main/java/RepairedPrograms.java` — versión reparada.
- `src/test/java/RepairedProgramsTest.java` — tests JUnit con los casos que en el Ejercicio 3 hacían fallar a la versión defectuosa.

## Cómo correr los tests

Desde `tp1/ejercicio4`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

Solo esta clase de tests:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=RepairedProgramsTest test
```

## Reparaciones aplicadas

### 1. `findLast(int[] x, int y)`

El problema era que el ciclo terminaba en `i > 0`, así que nunca revisaba la posición `0`. La reparación fue cambiar la condición a `i >= 0`.

### 2. `lastZero(int[] x)`

El método tenía que devolver el último cero, pero recorría el arreglo desde el inicio y devolvía el primero. La reparación fue recorrer desde el final.

### 3. `countPositive(int[] x)`

Estaba contando valores `>= 0`, o sea que el `0` entraba como positivo. La reparación fue contar solo los valores `> 0`.

### 4. `oddOrPos(int[] x)`

El código usaba `x[i] % 2 == 1`, pero eso en Java no reconoce a los impares negativos. La reparación fue usar `x[i] % 2 != 0`.

## Tests implementados

Se implementaron como tests JUnit los mismos casos que en el enunciado mostraban la falla:

- `findLast([2,3,5], 2)` debe devolver `0`.
- `lastZero([0,1,0])` debe devolver `2`.
- `countPositive([-4,2,0,2])` debe devolver `2`.
- `oddOrPos([-3,-2,0,1,4])` debe devolver `3`.

Sobre `OriginalPrograms`, esos casos detectan la falla. Sobre `RepairedPrograms`, los mismos tests pasan.

## Análisis con el modelo RIPR

### 1. `findLast`

- **Reachability**: el test ejecuta el `for` y llega a la condición defectuosa `i > 0`.
- **Infection**: cuando el recorrido debería considerar `i = 0`, el estado interno queda mal porque esa posición no se revisa.
- **Propagation**: como el valor buscado está justo en `x[0]`, el error interno afecta al valor de retorno.
- **Revealability**: el test compara el resultado obtenido con el esperado (`-1` contra `0`) y la falla queda visible.

### 2. `lastZero`

- **Reachability**: el test entra al recorrido de izquierda a derecha.
- **Infection**: el programa toma como candidato válido al primer cero encontrado, aunque todavía queda otro cero más adelante.
- **Propagation**: ese índice incorrecto se devuelve directamente.
- **Revealability**: el test espera `2` y recibe `0`, así que la diferencia se observa en la aserción.

### 3. `countPositive`

- **Reachability**: el test ejecuta la condición `x[i] >= 0`.
- **Infection**: cuando el recorrido llega al `0`, el contador aumenta aunque no debería.
- **Propagation**: ese conteo de más afecta el valor final retornado.
- **Revealability**: el test espera `2`, pero el programa defectuoso devuelve `3`.

### 4. `oddOrPos`

- **Reachability**: el test evalúa la condición `x[i] % 2 == 1 || x[i] > 0`.
- **Infection**: al llegar a `-3`, el método no lo cuenta aunque es impar.
- **Propagation**: el contador queda una unidad por debajo de lo correcto.
- **Revealability**: el test espera `3` y el programa defectuoso da `2`, por eso la falla se detecta.

## Resultado esperado

Corriendo `mvn -Dmaven.repo.local=.m2 test` sobre esta carpeta los tests pasan, porque se ejecutan contra `RepairedPrograms`.

## Enlaces relacionados

- Enunciado del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
