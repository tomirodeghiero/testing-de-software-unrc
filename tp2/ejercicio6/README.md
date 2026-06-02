# Ejercicio 6 — `repOK` y tests parametrizados para `BoundedQueue`

## Consigna

Implementar `repOK()` para `BoundedQueue`. Probar con tests parametrizados que el invariante se mantiene después de las operaciones fundamentales (`enQueue` y `deQueue`).

## La clase

`BoundedQueue` es una cola FIFO acotada, implementada como **buffer circular** sobre un arreglo `elements`. Los atributos:

- `elements`: arreglo de tamaño fijo.
- `size`: cantidad de elementos actuales.
- `front`: índice del próximo a desencolar.
- `back`: índice donde se escribe el próximo `enQueue`.
- `capacity`: el tamaño del arreglo, fijado en el constructor.

## Invariante de representación

`repOK()` chequea:

1. `elements != null` y `elements.length == capacity`.
2. `capacity >= 0`.
3. `0 <= size <= capacity`.
4. Caso especial `capacity == 0`: `size == 0`, `front == 0`, `back == 0`.
5. `0 <= front < capacity` y `0 <= back < capacity`.
6. **Buffer circular**: `back == (front + size) % capacity`.
7. **Zona ocupada sin huecos**: para todo `i` con `0 <= i < size`, `elements[(front + i) % capacity] != null`.
8. **Zona libre limpia**: las posiciones fuera de la zona ocupada contienen `null`.

Las cláusulas 6, 7 y 8 son las no triviales: 6 dice que la estructura es una cola circular consistente; 7 que no hay huecos en la zona activa; 8 que las celdas libres están realmente libres (para no filtrar referencias).

## Tests

Para no escribir un test por escenario armé un mini-DSL textual: `E:valor` para `enQueue(valor)`, `D` para `deQueue()`, todo separado por `;`. Cada caso pasa por `splitOperations` y `apply`, que ejecutan las operaciones sobre la cola y, paso a paso, chequean que `repOK` se siga cumpliendo.

### Escenarios válidos (`validScenarios`)

| capacidad | operaciones                  | contenido final | dequeued |
|-----------|------------------------------|-----------------|----------|
| 3         | `E:a;E:b;D;E:c`              | `[b, c]`        | `a`      |
| 3         | `E:x;E:y;D;E:z;E:w`          | `[y, z, w]`     | `x`      |
| 4         | `E:1;E:2;E:3;D;D;E:4;E:5`    | `[3, 4, 5]`     | `1,2`    |
| 2         | `E:p;E:q;D;E:r`              | `[q, r]`        | `p`      |
| 1         | `E:solo;D`                   | `[]`            | `solo`   |

Cubren situaciones representativas: llenar y vaciar, *wrap-around* (cuando `back` da la vuelta al final), capacidades chicas (1 y 2) donde la aritmética modular es más delicada.

### Escenarios inválidos (`invalidScenarios`)

Las operaciones inválidas deben lanzar la excepción correcta **y, además, el invariante debe seguir cumpliéndose después del error**. Una operación que falla no puede dejar la cola en un estado corrupto.

| capacidad | setup        | operación       | excepción esperada         |
|-----------|--------------|-----------------|----------------------------|
| 2         | (vacío)      | `D`             | `IllegalStateException`    |
| 2         | (vacío)      | `E:null`        | `NullPointerException`     |
| 2         | `E:a;E:b`    | `E:c`           | `IllegalStateException`    |

## Cómo correr

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=BoundedQueueParameterizedTest test
```

## Notas

- La clave del invariante es `back == (front + size) % capacity`: con esa cláusula basta saber `front` y `size` para reconstruir cualquier índice de la cola; sin ella, la representación sería ambigua.
- El chequeo de "zona libre limpia" no es estrictamente necesario para que la cola funcione (los métodos solo miran las celdas ocupadas), pero atrapa fugas: si por algún bug `deQueue` olvidara setear `elements[front] = null`, el test lo detectaría.

## Archivos

- [`BoundedQueue.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/queue/BoundedQueue.java) — implementación con `repOK()`.
- [`BoundedQueueParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/queue/BoundedQueueParameterizedTest.java) — escenarios válidos e inválidos con el mini-DSL.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
