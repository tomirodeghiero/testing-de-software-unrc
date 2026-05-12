# Ejercicio 3 - Tests para `StackAr` y `repOk`

## Consigna

Probar todos los metodos de `StackAr`, marcando en cada test las
secciones `arrange`, `act` y `assert`, usando `@BeforeEach` para
preparar un fixture compartido. Agregar al menos dos tests negativos
adicionales. Completar `repOk()` para que devuelva `true` solo si la
estructura es valida segun el invariante:

- `elems != null`
- `sp >= -1` y `sp < elems.length`
- para todo `i > sp`, `elems[i] == null`
- para todo `0 <= i <= sp`, `elems[i] != null`

Por ultimo, testear `repOk` y describir los inconvenientes encontrados.

## Archivos

- `../src/main/java/assignment2_exercises/stack/StackAr.java`
- `../src/test/java/assignment2_exercises/stack/StackArTest.java`

## Que se hizo

### Fixture compartido

Todos los tests parten de una pila de capacidad 3 creada por
`@BeforeEach`. Esto evita repetir codigo y mantiene la independencia
entre tests (cada uno arranca con estado fresco).

### Cobertura de la API

Se prueban todos los metodos publicos de `StackAr`:
constructor (con capacidad valida e invalida), `size`, `isEmpty`,
`isFull`, `push`, `pop`, `top`, `makeEmpty`, `equals`, `hashCode`,
`toString` y `repOk`.

### Tests negativos agregados

Mas alla de los exigidos por la consigna (dos minimos), se incluyen:

- `push` con la pila llena -> `IllegalStateException`
- `push(null)` -> `IllegalArgumentException`
- `pop` con la pila vacia -> `IllegalStateException`
- `top` con la pila vacia -> `IllegalStateException`
- comparar con un objeto de otro tipo en `equals`

### Arrange / Act / Assert

Cada test esta dividido por comentarios `// arrange`, `// act` y
`// assert` para que el patron AAA quede explicito. Esto sigue la
recomendacion del capitulo 3 de Ammann & Offutt (seccion sobre test
automation) y facilita la lectura.

## Implementacion de `repOk`

`repOk()` chequea las cuatro clausulas del invariante de
representacion. Para los casos donde el invariante esta violado y la
violacion no es alcanzable desde la API publica (por ejemplo `sp` con
un valor imposible o un `null` "intercalado" en la zona activa), los
tests usan **reflexion** para corromper el estado interno de manera
controlada y verificar que `repOk` devuelve `false`.

## Cambios sobre `StackAr`

1. Se completo `repOk` con el invariante de la consigna.
2. `pop()` ahora:
   - guarda el elemento del tope antes de actualizar el puntero,
   - limpia la celda desapilada (`elems[sp] = null`),
   - decrementa `sp` y retorna el elemento removido (semantica LIFO
     correcta).
3. `push(Object o)` rechaza `null` con `IllegalArgumentException`,
   porque el invariante exige `elems[i] != null` para toda celda
   ocupada.

## Como ejecutar solo este ejercicio

Desde la raiz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Inconvenientes encontrados

- **No se puede romper el invariante desde la API publica.** Para
  testear los caminos negativos de `repOk` (huecos en zona activa,
  basura en zona inactiva, `sp` fuera de rango) hizo falta usar
  reflexion. Esta es una observacion tipica del capitulo 3: cuando
  el codigo bajo prueba esconde su estado, una opcion es agregar
  *test hooks* o, como aca, usar la reflexion del lenguaje.
- **La version inicial de `pop` no era LIFO.** Al implementar `repOk`
  aparecio el problema: el metodo dejaba la celda desapilada con su
  valor anterior y, ademas, devolvia el nuevo tope (no el elemento
  removido). El test `popDebeRetornarUltimoElementoYReducirSize` fue
  el que lo detecto. Esto ilustra una idea importante de la materia:
  agregar el invariante de representacion como oraculo amplifica el
  poder de deteccion de los tests.
- **`hashCode` depende de toda la longitud de `elems`**, no solo de
  los elementos validos. Eso significa que dos pilas "logicamente
  iguales" creadas con capacidades distintas no son iguales segun
  `equals`. No se considera un defecto porque la clase define la
  igualdad por estructura, pero conviene tenerlo presente al disenar
  los tests.
