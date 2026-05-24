# Ejercicio 6 — `repOK` y tests parametrizados para `BoundedQueue`

## Consigna

Implementar `repOK()` para `assignment2_exercises.queue.BoundedQueue`. Probar con tests parametrizados que el invariante de representación se mantiene luego de realizar las operaciones fundamentales (`enQueue` y `deQueue`).

## Modelo de la clase

`BoundedQueue` es una cola FIFO acotada, implementada como **buffer circular** sobre un arreglo `elements` de tamaño `capacity`. Los atributos relevantes son:

- `elements`: arreglo de capacidad fija.
- `size`: cantidad de elementos actuales.
- `front`: índice del próximo elemento a desencolar.
- `back`: índice donde se escribe el próximo `enQueue`.
- `capacity`: tamaño del arreglo, fijado en el constructor.

## Invariante de representación

`repOK()` chequea las siguientes cláusulas:

1. `elements != null` y `elements.length == capacity`.
2. `capacity >= 0`.
3. `0 <= size <= capacity`.
4. Caso especial `capacity == 0`: `size == 0`, `front == 0`, `back == 0`.
5. `0 <= front < capacity` y `0 <= back < capacity`.
6. **Relación del buffer circular**: `back == (front + size) % capacity`.
7. **Zona ocupada sin huecos**: para todo `i` con `0 <= i < size`, `elements[(front + i) % capacity] != null`.
8. **Zona libre limpia**: las posiciones fuera de la zona ocupada contienen `null`.

Las cláusulas 6 a 8 son las "no triviales": dicen que la estructura es realmente una cola circular consistente y que no quedan *dangling references* en las celdas libres (importante para no filtrar memoria).

## Diseño de los tests parametrizados

Para no escribir un test por escenario se usó un mini-DSL textual de operaciones: `E:valor` para `enQueue(valor)`, `D` para `deQueue()`, todo separado por `;`. Cada caso parametrizado pasa por `splitOperations` y `apply`, que ejecutan las operaciones sobre la cola y, paso a paso, verifican que `repOK` se siga cumpliendo.

### Escenarios válidos (`validScenarios`)

| capacidad | operaciones                  | contenido final | dequeued |
|-----------|------------------------------|-----------------|----------|
| 3         | `E:a;E:b;D;E:c`              | `[b, c]`        | `a`      |
| 3         | `E:x;E:y;D;E:z;E:w`          | `[y, z, w]`     | `x`      |
| 4         | `E:1;E:2;E:3;D;D;E:4;E:5`    | `[3, 4, 5]`     | `1,2`    |
| 2         | `E:p;E:q;D;E:r`              | `[q, r]`        | `p`      |
| 1         | `E:solo;D`                   | `[]`            | `solo`   |

Estos casos cubren situaciones representativas:

- llenado y vaciado de la cola,
- *wrap-around* (cuando `back` da la vuelta al final del arreglo),
- capacidad chica (1 y 2), donde la aritmética modular es más delicada.

### Escenarios inválidos (`invalidScenarios`)

Las operaciones inválidas deben lanzar la excepción correcta y, además, **el invariante debe seguir satisfecho después del error**: una operación que falla no debe dejar la cola en un estado corrupto.

| capacidad | setup        | operación       | excepción esperada         |
|-----------|--------------|-----------------|----------------------------|
| 2         | (vacío)      | `D`             | `IllegalStateException`    |
| 2         | (vacío)      | `E:null`        | `NullPointerException`     |
| 2         | `E:a;E:b`    | `E:c`           | `IllegalStateException`    |

## Cómo ejecutar

Desde la raíz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=BoundedQueueParameterizedTest test
```

## Comentarios finales

- La clave del invariante es la cláusula `back == (front + size) % capacity`: con ella basta saber `front` y `size` para reconstruir cualquier índice de la cola; sin ella, la representación sería ambigua.
- El chequeo de "zona libre limpia" no es estrictamente necesario desde el punto de vista funcional (los métodos solo miran las celdas ocupadas), pero atrapa fugas: si por algún bug futuro `deQueue` olvidara setear `elements[front] = null`, el test lo detectaría.
- Esta separación *escenarios válidos vs inválidos* + verificación paso a paso del invariante es la mejor práctica que el capítulo 3 del libro recomienda para clases con estado.

## Código

- [`BoundedQueue.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/queue/BoundedQueue.java) — implementación con `repOK()`.
- [`BoundedQueueParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/queue/BoundedQueueParameterizedTest.java) — escenarios válidos e inválidos con el mini-DSL textual.

## Enlaces relacionados

- Enunciado del práctico: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución completa: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- Resumen teórico: [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
