---
title: "Ejercicio 3"
sidebar_position: 3
slug: "/tp1/ejercicio3/"
description: "Contenido importado desde tp1/ejercicio3/README.md"
---

# Ejercicio 3 — Análisis de programas defectuosos y cadena RIPR

## Consigna

El enunciado presenta cuatro programas defectuosos (`findLast`, `lastZero`, `countPositive`, `oddOrPos`) junto con un caso de test que produce falla en cada uno. Para cada programa hay que:

- **a)** Identificar el defecto y proponer una corrección.
- **b)** Si es posible, dar una entrada que **no ejecute** el defecto.
- **c)** Dar una entrada que ejecute el defecto **pero no produzca falla observable**.
- **d)** Dar una entrada que ejecute el defecto **y produzca falla**.

La separación entre los puntos b, c y d sigue la cadena RIPR: alcanzar el defecto, infectar el estado, propagarlo hasta la salida.

## Archivos

- `DefectivePrograms.java` — los cuatro programas tal como aparecen en el enunciado.
- `FixedPrograms.java` — una corrección posible para cada uno.
- `Exercise3Runner.java` — runner por consola para correr los casos sobre la versión defectuosa o la corregida.

## Cómo compilar y ejecutar

Desde esta carpeta:

```bash
cd tp1/ejercicio3
javac *.java
```

Versión defectuosa, los cuatro programas:

```bash
java Exercise3Runner faulty all
```

Versión corregida, los cuatro programas:

```bash
java Exercise3Runner fixed all
```

Un programa puntual:

```bash
java Exercise3Runner faulty findLast
java Exercise3Runner fixed findLast
java Exercise3Runner faulty lastZero
java Exercise3Runner fixed lastZero
java Exercise3Runner faulty countPositive
java Exercise3Runner fixed countPositive
java Exercise3Runner faulty oddOrPos
java Exercise3Runner fixed oddOrPos
```

## Resolución

### 1. `findLast(int[] x, int y)`

#### a) Defecto y corrección

El defecto está en la condición del `for`:

```java
for (int i = x.length - 1; i > 0; i--)
```

El ciclo debería seguir mientras `i >= 0`, no mientras `i > 0`. Tal como está escrito, nunca revisa la posición `0` del arreglo.

Corrección:

```java
for (int i = x.length - 1; i >= 0; i--)
```

#### b) Caso que no ejecute el defecto

No se puede, al menos usando entradas válidas. El defecto está en la condición del `for`, y esa condición se evalúa siempre que se llama al método. Lo que sí puede pasar es que el defecto se ejecute pero no se note, si justo no hace falta revisar la posición `0`.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [5, 2, 3], y = 2
resultado esperado = 1
```

El defecto se ejecuta, pero como el valor buscado no está en la posición `0`, el resultado sigue siendo correcto.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [2, 3, 5], y = 2
resultado esperado = 0
resultado defectuoso = -1
```

Falla porque el programa no revisa la posición `0`.

### 2. `lastZero(int[] x)`

#### a) Defecto y corrección

El defecto es conceptual: el método debe devolver el último índice cuyo valor es `0`, pero recorre el arreglo de izquierda a derecha y retorna apenas encuentra el primer cero.

Código defectuoso:

```java
for (int i = 0; i < x.length; i++) {
    if (x[i] == 0) {
        return i;
    }
}
```

Una corrección simple es recorrer desde el final:

```java
for (int i = x.length - 1; i >= 0; i--) {
    if (x[i] == 0) {
        return i;
    }
}
```

#### b) Caso que no ejecute el defecto

Para arreglos no nulos, no es posible. La estrategia defectuosa de recorrer desde el inicio siempre se utiliza.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [1, 0, 2]
resultado esperado = 1
```

El método está mal, pero como solo hay un cero, el primer cero coincide con el último.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [0, 1, 0]
resultado esperado = 2
resultado defectuoso = 0
```

Falla porque devuelve el primer cero, no el último.

### 3. `countPositive(int[] x)`

#### a) Defecto y corrección

El comentario indica que debe contar elementos positivos, pero el código cuenta elementos mayores o iguales que cero:

```java
if (x[i] >= 0) {
    count++;
}
```

Eso incluye al `0`, que no es positivo.

Corrección:

```java
if (x[i] > 0) {
    count++;
}
```

#### b) Caso que no ejecute el defecto

```text
x = []
resultado esperado = 0
```

Como el arreglo está vacío, no entra al cuerpo del `for` y la condición defectuosa no se evalúa.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [-4, 2, 2]
resultado esperado = 2
```

La condición defectuosa se ejecuta, pero como no hay ceros, contar `>= 0` o `> 0` da el mismo resultado.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [-4, 2, 0, 2]
resultado esperado = 2
resultado defectuoso = 3
```

Falla porque el `0` se cuenta como positivo.

### 4. `oddOrPos(int[] x)`

#### a) Defecto y corrección

El método debe contar valores impares o positivos. El defecto está en usar:

```java
x[i] % 2 == 1
```

En Java, los impares negativos no cumplen esa condición. Por ejemplo:

```text
-3 % 2 == -1
```

Por eso los impares negativos quedan afuera aunque deberían contarse.

Una corrección simple es:

```java
if (x[i] % 2 != 0 || x[i] > 0) {
    count++;
}
```

#### b) Caso que no ejecute el defecto

```text
x = []
resultado esperado = 0
```

El cuerpo del `for` no se ejecuta.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [2, 4, -2]
resultado esperado = 2
```

El defecto se ejecuta, pero no hay impares negativos. Entonces el resultado coincide con el esperado.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [-3, -2, 0, 1, 4]
resultado esperado = 3
resultado defectuoso = 2
```

Los valores que deberían contarse son `-3`, `1` y `4`, pero el programa defectuoso no cuenta `-3`.

## Síntesis

- `findLast`: no revisa el índice `0`.
- `lastZero`: devuelve el primer cero en vez del último.
- `countPositive`: cuenta el `0` como positivo.
- `oddOrPos`: no reconoce impares negativos por la semántica del operador `%` en Java.

## Enlaces relacionados

- Enunciado del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
