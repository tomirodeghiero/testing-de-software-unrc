# Ejercicio 3 — Tests para `StackAr` y `repOk`

## Consigna

Probar todos los métodos de `StackAr`, marcando en cada test las fases `arrange`, `act` y `assert`, usando `@BeforeEach` para preparar un fixture compartido y agregando al menos dos tests negativos. Completar `repOk()` con el invariante:

- `elems != null`
- `sp >= -1` y `sp < elems.length`
- para todo `i > sp`, `elems[i] == null`
- para todo `0 <= i <= sp`, `elems[i] != null`

Después testear `repOk` y describir los inconvenientes encontrados.

## Resolución

### Fixture compartido

Todos los tests parten de una pila de capacidad 3 creada por `@BeforeEach`. Cada test arranca con estado fresco y no se duplica código.

### Cobertura de la API

Probé todos los métodos públicos: constructor (con capacidad válida e inválida), `size`, `isEmpty`, `isFull`, `push`, `pop`, `top`, `makeEmpty`, `equals`, `hashCode`, `toString` y `repOk`.

### Tests negativos

Además de los dos mínimos que pedía la consigna agregué:

- `push` con la pila llena → `IllegalStateException`
- `push(null)` → `IllegalArgumentException`
- `pop` con la pila vacía → `IllegalStateException`
- `top` con la pila vacía → `IllegalStateException`
- comparar con un objeto de otro tipo en `equals`

### Arrange / Act / Assert

Cada test tiene las tres fases marcadas con comentarios `// arrange`, `// act`, `// assert`. Sigue la recomendación del capítulo 3 de Ammann & Offutt.

### `repOk`

Chequea las cuatro cláusulas del invariante. Para los casos en que la violación no es alcanzable desde la API pública (`sp` con un valor imposible, un `null` "intercalado" en la zona activa), los tests usan **reflexión** para corromper el estado interno de forma controlada y verificar que `repOk` devuelva `false`.

### Cambios sobre `StackAr`

1. Completé `repOk` con el invariante de la consigna.
2. `pop()` ahora respeta LIFO: guarda el tope, limpia la celda (`elems[sp] = null`), decrementa `sp` y devuelve el elemento removido.
3. `push(Object o)` rechaza `null` con `IllegalArgumentException` (el invariante exige `elems[i] != null` para celdas ocupadas).

## Cómo correr

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Inconvenientes que aparecieron

- **No se puede romper el invariante desde la API pública.** Para probar los caminos negativos de `repOk` (huecos en zona activa, basura en zona inactiva, `sp` fuera de rango) hizo falta reflexión.
- **La versión inicial de `pop` no era LIFO.** Recién apareció cuando implementé `repOk`: el método dejaba la celda con su valor anterior y devolvía el nuevo tope en lugar del removido. El test `popDebeRetornarUltimoElementoYReducirSize` lo detectó. Ilustra un concepto importante que es el de agregar el invariante como oráculo amplifica el poder de detección.
- **`hashCode` depende de toda la longitud de `elems`**, no solo de los elementos válidos. Dos pilas con misma estructura lógica pero capacidades distintas no son iguales para `equals`. No lo considero un defecto (la clase define igualdad por estructura), pero conviene tenerlo presente al diseñar tests.

## Archivos

- [`Stack.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/stack/Stack.java) — interfaz `Stack` provista por la cátedra.
- [`StackAr.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/stack/StackAr.java) — implementación con `repOk()` y los ajustes a `pop` y `push(null)`.
- [`StackArTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/stack/StackArTest.java) — suite con fixture, AAA explícito y tests negativos.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
