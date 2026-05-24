# Ejercicio 3 — Tests para `StackAr` y `repOk`

## Consigna

Probar todos los métodos de `StackAr`, marcando en cada test las secciones `arrange`, `act` y `assert`, y usando `@BeforeEach` para preparar un fixture compartido. Agregar al menos dos tests negativos adicionales. Completar `repOk()` para que devuelva `true` solo si la estructura es válida según el invariante:

- `elems != null`
- `sp >= -1` y `sp < elems.length`
- para todo `i > sp`, `elems[i] == null`
- para todo `0 <= i <= sp`, `elems[i] != null`

Por último, testear `repOk` y describir los inconvenientes encontrados.

## Resolución

### Fixture compartido

Todos los tests parten de una pila de capacidad 3 creada por `@BeforeEach`. Esto evita repetir código y mantiene la independencia entre tests (cada uno arranca con estado fresco).

### Cobertura de la API

Se prueban todos los métodos públicos de `StackAr`: constructor (con capacidad válida e inválida), `size`, `isEmpty`, `isFull`, `push`, `pop`, `top`, `makeEmpty`, `equals`, `hashCode`, `toString` y `repOk`.

### Tests negativos agregados

Más allá de los exigidos por la consigna (dos mínimos), se incluyen:

- `push` con la pila llena → `IllegalStateException`
- `push(null)` → `IllegalArgumentException`
- `pop` con la pila vacía → `IllegalStateException`
- `top` con la pila vacía → `IllegalStateException`
- comparar con un objeto de otro tipo en `equals`

### Arrange / Act / Assert

Cada test está dividido por comentarios `// arrange`, `// act` y `// assert` para que el patrón AAA quede explícito. Esto sigue la recomendación del capítulo 3 de Ammann & Offutt (sección sobre *test automation*) y facilita la lectura.

### Implementación de `repOk`

`repOk()` chequea las cuatro cláusulas del invariante de representación. Para los casos donde el invariante está violado y la violación no es alcanzable desde la API pública (por ejemplo `sp` con un valor imposible o un `null` "intercalado" en la zona activa), los tests usan **reflexión** para corromper el estado interno de manera controlada y verificar que `repOk` devuelva `false`.

### Cambios sobre `StackAr`

1. Se completó `repOk` con el invariante de la consigna.
2. `pop()` ahora:
   - guarda el elemento del tope antes de actualizar el puntero,
   - limpia la celda desapilada (`elems[sp] = null`),
   - decrementa `sp` y retorna el elemento removido (semántica LIFO correcta).
3. `push(Object o)` rechaza `null` con `IllegalArgumentException`, porque el invariante exige `elems[i] != null` para toda celda ocupada.

## Cómo ejecutar

Desde la raíz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Inconvenientes encontrados

- **No se puede romper el invariante desde la API pública.** Para testear los caminos negativos de `repOk` (huecos en zona activa, basura en zona inactiva, `sp` fuera de rango) hizo falta usar reflexión. Es una observación típica del capítulo 3: cuando el código bajo prueba esconde su estado, una opción es agregar *test hooks* o, como acá, usar la reflexión del lenguaje.
- **La versión inicial de `pop` no era LIFO.** Al implementar `repOk` apareció el problema: el método dejaba la celda desapilada con su valor anterior y, además, devolvía el nuevo tope (no el elemento removido). El test `popDebeRetornarUltimoElementoYReducirSize` fue el que lo detectó. Esto ilustra una idea importante de la materia: agregar el invariante de representación como oráculo amplifica el poder de detección de los tests.
- **`hashCode` depende de toda la longitud de `elems`**, no solo de los elementos válidos. Eso significa que dos pilas "lógicamente iguales" creadas con capacidades distintas no son iguales según `equals`. No se considera un defecto porque la clase define la igualdad por estructura, pero conviene tenerlo presente al diseñar los tests.

## Código

- [`Stack.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/stack/Stack.java) — interfaz `Stack` provista por la cátedra.
- [`StackAr.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/stack/StackAr.java) — implementación con `repOk()` y los ajustes a `pop` y `push(null)`.
- [`StackArTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/stack/StackArTest.java) — suite con fixture, AAA explícito y tests negativos.

## Enlaces relacionados

- Enunciado del práctico: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución completa: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- Resumen teórico: [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
