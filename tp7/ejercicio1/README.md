# Ejercicio 1 — `NodeCachingLinkedList`: `repOK()` y propiedades

Trabajo sobre `NodeCachingLinkedList` (paquete `assignment7_exercises.ncl`): una lista doblemente enlazada y circular, con un *pool* interno de nodos reutilizables (la *cache*) para evitar crear y descartar objetos todo el tiempo.

La consigna pide:

1. leer la implementación para entender cómo conviven la lista principal y la cache,
2. completar `repOK()` con los invariantes de representación,
3. escribir tres propiedades con `jqwik` (con sus generadores) que validen el comportamiento.

## `repOK()`

La estructura tiene dos "mitades" con reglas distintas: la **lista principal** (circular, doblemente enlazada, con centinela `header`) y la **cache** (lista simplemente enlazada de nodos reutilizables). El chequeo arranca por las condiciones baratas y avanza hacia las más costosas:

- **Validez básica del `header`**: no puede ser `null` y sus enlaces `next`/`previous` tampoco.
- **Consistencia de tamaños**: `size >= 0`, `cacheSize >= 0`, `maximumCacheSize >= 0`, y `cacheSize <= maximumCacheSize`.
- **Constante `DEFAULT_MAXIMUM_CACHE_SIZE == 20`**: el enunciado pide verificarla explícitamente.
- **Recorrido de la lista principal**: avanzar desde `header` siguiendo `next` hasta volver al `header`. En cada paso valido que los enlaces dobles sean coherentes (`node.next.previous == node` y `node.previous.next == node`) y uso un `HashSet` para detectar ciclos prematuros.
- **Coherencia de `size`**: al terminar, la cantidad de nodos visitados menos uno (por el centinela) debe coincidir con `size`.
- **Recorrido de la cache**: avanzar desde `firstCachedNode` siguiendo `next` hasta `null`. En cada nodo verifico que:
  - `previous == null` y `value == null` (estado "limpio" al entrar a la cache),
  - no forme ciclos,
  - no pertenezca también a la lista principal.
- **Coherencia de `cacheSize`**: la cantidad de nodos recorridos en la cache debe coincidir con `cacheSize`.

## Bug que detecté: inicialización de `maximumCacheSize`

El constructor original dejaba `maximumCacheSize = 0`, lo que en la práctica deshabilitaba la cache (si `cacheSize >= maximumCacheSize` siempre es cierto, nunca se cachean nodos). Eso va en contra de la idea misma de la estructura: el nombre *Node Caching Linked List* presupone que por defecto existe cache.

La corrección fue inicializar `maximumCacheSize = DEFAULT_MAXIMUM_CACHE_SIZE` en el constructor:

```java
public NodeCachingLinkedList() {
    header = new LinkedListNode();
    header.setValue(null);
    header.setNext(header);
    header.setPrevious(header);
    maximumCacheSize = DEFAULT_MAXIMUM_CACHE_SIZE;
}
```

## Propiedades con `jqwik`

### 1) Al remover un elemento, la cache crece en uno

```java
@Property(tries = 200)
void luegoDeRemoverUnElementoSeIncrementaEnUnoElTamanoDeCache(
    @ForAll("escenariosRemocion") EscenarioRemocion escenario
) {
    NodeCachingLinkedList ncl = escenario.lista;
    assertTrue(ncl.repOK());
    int cacheAntes = ncl.getCacheSize();

    Integer removido = ncl.removeIndex(escenario.index);

    assertNotNull(removido);
    assertEquals(cacheAntes + 1, ncl.getCacheSize());
}
```

El generador `escenariosRemocion` arma una lista con entre 1 y 15 elementos y elige un índice válido. Se cumple mientras no se supere `maximumCacheSize`, condición garantizada por el rango de tamaños (≤ 15 < 20).

### 2) Con cache no vacía, agregar conserva la suma total de nodos

Cuando la cache tiene nodos, un `addFirst` no crea un nodo nuevo: reutiliza uno de la cache. Por lo tanto `size + cacheSize` queda constante: sube `size` en 1, baja `cacheSize` en 1.

El generador primero arma una lista y después remueve un elemento (para garantizar que la cache tenga al menos un nodo). Recién ahí ejecuta el `addFirst` y compara la suma antes y después.

### 3) Remover un elemento preserva `repOK()`

Una de las propiedades clásicas de los invariantes de representación: cualquier operación pública sobre un objeto válido debe dejarlo en un estado válido. Si alguna operación interna (manejo de enlaces, paso a cache, decremento de `size`) dejara la estructura inconsistente, esta propiedad lo detectaría.

Las tres propiedades corren con `tries = 200`.

## Cómo correr

```bash
cd tp7/assignmnet-7-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=NodeCachingLinkedListPropertiesTest test
```

Resultado: `BUILD SUCCESS` con las tres propiedades en verde.

## Archivos

- [`NodeCachingLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/ncl/NodeCachingLinkedList.java) — implementación con `repOK()` y la corrección del constructor.
- [`LinkedListNode.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/ncl/LinkedListNode.java)
- [`NodeCachingLinkedListPropertiesTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/ncl/NodeCachingLinkedListPropertiesTest.java) — las tres propiedades + generadores.

## Enlaces

- Resolución: [`resolucion_practico7.pdf`](/pdfs/tp7/resolucion_practico7.pdf)
