---
title: "Ejercicio 6"
sidebar_position: 6
slug: "/tp2/ejercicio6/"
description: "Contenido importado desde tp2/ejercicio6/README.md"
---

# Ejercicio 6 - `repOK` y tests parametrizados para `BoundedQueue`

## Consigna

Implementar `repOK()` para
`assignment2_exercises.queue.BoundedQueue`. Probar con tests
parametrizados que el invariante de representacion se mantiene luego
de realizar las operaciones fundamentales (`enQueue` y `deQueue`).

## Archivos

- `../src/main/java/assignment2_exercises/queue/BoundedQueue.java`
- `../src/test/java/assignment2_exercises/queue/BoundedQueueParameterizedTest.java`

## Modelo de la clase

`BoundedQueue` es una cola FIFO acotada, implementada como **buffer
circular** sobre un arreglo `elements` de tamano `capacity`. Los
atributos relevantes son:

- `elements`: arreglo de capacidad fija;
- `size`: cantidad de elementos actuales;
- `front`: indice del proximo elemento a desencolar;
- `back`: indice donde se escribe el proximo `enQueue`;
- `capacity`: tamano del arreglo, fijado en el constructor.

## Invariante de representacion

`repOK()` chequea las siguientes clausulas:

1. `elements != null` y `elements.length == capacity`.
2. `capacity >= 0`.
3. `0 <= size <= capacity`.
4. Caso especial `capacity == 0`: `size == 0`, `front == 0`,
   `back == 0`.
5. `0 <= front < capacity` y `0 <= back < capacity`.
6. **Relacion del buffer circular**: `back == (front + size) % capacity`.
7. **Zona ocupada sin huecos**: para todo `i` con `0 <= i < size`,
   `elements[(front + i) % capacity] != null`.
8. **Zona libre limpia**: las posiciones fuera de la zona ocupada
   contienen `null`.

Las clausulas 6 a 8 son las "no triviales": dicen que la estructura
es realmente una cola circular consistente y que no quedan
*dangling references* en las celdas libres (importante para no
filtrar memoria).

## Diseno de los tests parametrizados

Para no escribir un test por escenario se uso un mini-DSL textual de
operaciones: `E:valor` para `enQueue(valor)`, `D` para `deQueue()`,
todo separado por `;`. Cada caso parametrizado pasa por
`splitOperations` y `apply`, que ejecutan las operaciones sobre la
cola y, paso a paso, verifican que `repOK` se siga cumpliendo.

### Escenarios validos (`validScenarios`)

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
- capacidad chica (1 y 2), donde la aritmetica modular es mas
  delicada.

### Escenarios invalidos (`invalidScenarios`)

Las operaciones invalidas deben lanzar la excepcion correcta y, ademas,
**el invariante debe seguir satisfecho despues del error**: una
operacion que falla no debe dejar la cola en un estado corrupto.

| capacidad | setup        | operacion       | excepcion esperada         |
|-----------|--------------|-----------------|----------------------------|
| 2         | (vacio)      | `D`             | `IllegalStateException`    |
| 2         | (vacio)      | `E:null`        | `NullPointerException`     |
| 2         | `E:a;E:b`    | `E:c`           | `IllegalStateException`    |

## Como correr solo este ejercicio

Desde la raiz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=BoundedQueueParameterizedTest test
```

## Comentarios finales

- La clave del invariante es la clausula `back == (front + size) %
  capacity`: con ella basta saber `front` y `size` para reconstruir
  cualquier indice de la cola; sin ella, la representacion seria
  ambigua.
- El chequeo de "zona libre limpia" no es estrictamente necesario
  desde el punto de vista funcional (los metodos solo miran las
  celdas ocupadas), pero atrapa fugas: si por algun bug futuro
  `deQueue` olvidara setear `elements[front] = null`, el test lo
  detectaria.
- Esta separacion *escenarios validos vs invalidos* + verificacion
  paso a paso del invariante es la mejor practica que el capitulo 3
  del libro recomienda para clases con estado.
