# Ejercicio 3

En este ejercicio arme una suite de tests para todos los metodos de `StackAr`
usando JUnit 5, con fixture compartido por `@BeforeEach` y marcando en cada
test las partes `arrange`, `act` y `assert`.

## Archivos tocados

- `../src/main/java/assignment2_exercises/stack/StackAr.java`
- `../src/test/java/assignment2_exercises/stack/StackArTest.java`

## Cobertura de tests

Se agregaron tests para:

- constructor con capacidad invalida
- `size`
- `isEmpty`
- `isFull`
- `push`
- `pop`
- `top`
- `makeEmpty`
- `equals`
- `hashCode`
- `toString`
- `repOk`

Tambien se agregaron tests negativos adicionales, por ejemplo:

- `push` en pila llena
- `push(null)`
- `pop` en pila vacia
- `top` en pila vacia

## Cambios en la implementacion

1. Se completo `repOk()` con las condiciones pedidas en la consigna.
2. Se corrigio `pop()` para que:
   - devuelva realmente el elemento que estaba en el tope
   - limpie la posicion desapilada (`elems[sp] = null`)
3. Se agrego validacion en `push` para rechazar `null`, porque el invariante
   pide que para todo `i <= sp`, `elems[i] != null`.

## Como ejecutar solo este ejercicio

Desde `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Inconvenientes que aparecieron

- Para testear casos invalidos de `repOk` (por ejemplo `sp` fuera de rango o
  huecos internos), no alcanza con la API publica porque la clase protege su
  estado interno. Para eso use reflexion en los tests.
- Al implementar `repOk` aparecio una inconsistencia en `pop`: no limpiaba la
  celda desapilada y ademas devolvia el nuevo tope en lugar del elemento
  removido. Se corrigio para que respete LIFO y el invariante.
