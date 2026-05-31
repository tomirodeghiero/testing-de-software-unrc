# Ejercicio 3 — Programas defectuosos y cadena RIPR

## Consigna

El enunciado da cuatro programas defectuosos (`findLast`, `lastZero`, `countPositive`, `oddOrPos`) y, para cada uno, un caso de test que produce falla. Para cada programa hay que:

- a) identificar el defecto y proponer una corrección;
- b) si es posible, dar una entrada que **no ejecute** el defecto;
- c) dar una entrada que ejecute el defecto **pero no produzca falla**;
- d) dar una entrada que ejecute el defecto **y sí produzca falla**.

Los puntos b, c y d se corresponden con la cadena RIPR: llegar al defecto, infectar el estado, propagarlo hasta la salida.

## Archivos

- [`DefectivePrograms.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio3/DefectivePrograms.java) — los cuatro programas como aparecen en el enunciado.
- [`FixedPrograms.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio3/FixedPrograms.java) — una corrección posible para cada uno.
- [`Exercise3Runner.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio3/Exercise3Runner.java) — runner por consola para probar los casos.

## Cómo compilar y correr

```bash
cd tp1/ejercicio3
javac *.java

java Exercise3Runner faulty all     # los cuatro defectuosos
java Exercise3Runner fixed all      # los cuatro corregidos
java Exercise3Runner faulty findLast   # uno puntual
```

## Resolución

### 1. `findLast(int[] x, int y)`

**Defecto.** El `for` itera mientras `i > 0`, así que nunca toca la posición `0`. Debería ser `i >= 0`.

**b)** No hay entrada válida que evite ejecutar el defecto: la condición del `for` se evalúa siempre. Lo que sí puede pasar es que se ejecute pero no se note.

**c)** `x = [5, 2, 3]`, `y = 2`. Resultado esperado `1`. El defecto se ejecuta pero el valor buscado no está en la posición `0`, así que el resultado sale bien.

**d)** `x = [2, 3, 5]`, `y = 2`. Esperado `0`, devuelve `-1`. La falla aparece porque el `2` está justo en la posición que el recorrido no visita.

### 2. `lastZero(int[] x)`

**Defecto.** Debería devolver el último índice con valor `0`, pero recorre de izquierda a derecha y retorna apenas encuentra el primero. Una corrección simple es recorrer desde el final.

**b)** Con arreglos no nulos, no se puede evitar el recorrido defectuoso.

**c)** `x = [1, 0, 2]`, esperado `1`. Como hay un solo cero, el primero y el último coinciden.

**d)** `x = [0, 1, 0]`, esperado `2`, devuelve `0`.

### 3. `countPositive(int[] x)`

**Defecto.** El comentario dice "positivos" pero el código compara `x[i] >= 0`, así que cuenta también al `0`. Corregir a `> 0`.

**b)** `x = []`. El cuerpo del `for` no se ejecuta.

**c)** `x = [-4, 2, 2]`, esperado `2`. La condición defectuosa se evalúa, pero como no hay ceros, contar `>= 0` o `> 0` da lo mismo.

**d)** `x = [-4, 2, 0, 2]`, esperado `2`, devuelve `3`. El cero se cuenta como positivo.

### 4. `oddOrPos(int[] x)`

**Defecto.** Tiene que contar impares o positivos, y usa `x[i] % 2 == 1`. El problema es que en Java `-3 % 2 == -1`, así que los impares negativos no entran. Una corrección es `x[i] % 2 != 0 || x[i] > 0`.

**b)** `x = []`.

**c)** `x = [2, 4, -2]`, esperado `2`. Se ejecuta la condición defectuosa pero no hay impares negativos que la disparen.

**d)** `x = [-3, -2, 0, 1, 4]`, esperado `3`, devuelve `2`. El `-3` no se cuenta.

## Síntesis

- `findLast`: no revisa el índice `0`.
- `lastZero`: devuelve el primer cero en vez del último.
- `countPositive`: cuenta el `0` como positivo.
- `oddOrPos`: la semántica de `%` en Java deja afuera a los impares negativos.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
