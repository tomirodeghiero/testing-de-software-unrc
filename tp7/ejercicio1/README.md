# Ejercicio 1

Este ejercicio trabaja sobre la clase `NodeCachingLinkedList` que se provee dentro del paquete `assignment7_exercises.ncl`. Se trata de una lista doblemente enlazada y circular, con la particularidad de que mantiene un *pool* interno de nodos reutilizables (la *cache*) para evitar crear y descartar objetos todo el tiempo.

La consigna pide tres cosas:

1. leer con atención la implementación para entender cómo conviven la lista principal y la cache,
2. completar el método `repOK()` chequeando todos los invariantes de representación,
3. escribir tres propiedades con `jqwik`, cada una con sus generadores, que permitan validar el comportamiento de la estructura mediante *property-based testing*.

## Archivos relevantes

- Implementación: [NodeCachingLinkedList.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/ncl/NodeCachingLinkedList.java)
- Propiedades PBT: [NodeCachingLinkedListPropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/ncl/NodeCachingLinkedListPropertiesTest.java)

## Desarrollo de la resolución

### 1) Implementación de `repOK()`

El invariante de representación debe garantizar que, en cualquier momento de la ejecución, la estructura interna del objeto sea consistente. Para esta clase hay dos "mitades" que conviven y que tienen reglas distintas: la **lista principal** (circular y doblemente enlazada, con un nodo centinela `header`) y la **cache** (una lista simplemente enlazada de nodos reutilizables).

El chequeo que implementé arranca por las condiciones más baratas y va avanzando hacia las más costosas, de manera que si algo falla temprano no se recorre innecesariamente toda la estructura:

- **Validez básica del `header`**: no puede ser `null` y sus enlaces `next` y `previous` tampoco. Si alguno falla, la lista directamente está rota.
- **Consistencia de tamaños**: `size >= 0`, `cacheSize >= 0`, `maximumCacheSize >= 0` y `cacheSize <= maximumCacheSize`. Este último chequeo es clave porque la cache nunca puede exceder su capacidad máxima.
- **Constante `DEFAULT_MAXIMUM_CACHE_SIZE == 20`**: el enunciado exige que se verifique explícitamente, así que se incluye aunque sea una constante.
- **Recorrido de la lista principal**: se avanza desde `header` siguiendo `next` hasta volver al propio `header`. En cada paso se valida que los enlaces dobles sean coherentes (`node.next.previous == node` y `node.previous.next == node`), y se usa un `HashSet` para detectar ciclos prematuros (un nodo que se visita dos veces antes de cerrar el círculo indica corrupción).
- **Coherencia de `size`**: al terminar el recorrido, la cantidad de nodos visitados menos uno (por el centinela) debe coincidir exactamente con el campo `size`.
- **Recorrido de la cache**: se avanza desde `firstCachedNode` siguiendo `next` hasta llegar a `null`. En cada nodo se verifica que:
  - `previous == null` y `value == null` (es el estado "limpio" que se les deja al entrar a la cache),
  - no forme ciclos (otra vez con `HashSet`),
  - no pertenezca también a la lista principal (comparando contra el `HashSet` del recorrido anterior; un mismo nodo en las dos estructuras rompería todo).
- **Coherencia de `cacheSize`**: la cantidad de nodos recorridos en la cache debe ser exactamente `cacheSize`.

La combinación de estos chequeos garantiza que cualquier operación que rompa alguna de las reglas anteriores sea detectada por `repOK()`.

### 2) Inicialización del `maximumCacheSize`

Analizando el constructor original noté que `maximumCacheSize` quedaba en `0`, lo que dejaba la cache permanentemente deshabilitada (si `cacheSize >= maximumCacheSize` siempre es cierto, nunca se cachean nodos). Eso iba en contra de la idea misma de la estructura: el nombre *Node Caching Linked List* presupone que por defecto existe cache.

Por eso, en el constructor se inicializa `maximumCacheSize = DEFAULT_MAXIMUM_CACHE_SIZE`. Así, recién creada, la lista ya tiene capacidad para almacenar hasta 20 nodos en la cache, que es el comportamiento esperado.

### 3) Propiedades con `jqwik`

Se implementaron las tres propiedades pedidas. En todos los casos el generador arma listas válidas agregando elementos con `addFirst` y, cuando corresponde, fuerza el estado de cache que necesita la propiedad. De esa manera se evitan casos triviales o inválidos (por ejemplo, intentar remover de una lista vacía) sin tener que apoyarse en filtros que descarten ejecuciones.

**Propiedad 1 — Al remover un elemento, la cache crece en uno.**
Se genera una lista con entre 1 y 15 elementos y un índice válido dentro de ese rango. Antes de remover, se chequea `repOK()` y se guarda el tamaño actual de la cache. Luego de `removeIndex`, se verifica que el elemento retornado no sea `null` y que la cache haya aumentado exactamente en 1. Esto se cumple mientras no se supere `maximumCacheSize`, condición garantizada por el rango de tamaños elegido (≤ 15 < 20).

**Propiedad 2 — Con cache no vacía, agregar conserva la suma total de nodos.**
Es la propiedad más interesante: cuando la cache tiene nodos, un `addFirst` no crea un nodo nuevo sino que reutiliza uno de la cache. Por lo tanto `size + cacheSize` debe quedar igual: sube `size` en 1, baja `cacheSize` en 1. Para garantizar la precondición, el generador primero arma una lista y después remueve un elemento: eso deja la cache con al menos 1 nodo. Recién ahí ejecuta el `addFirst` y compara la suma antes y después.

**Propiedad 3 — Remover un elemento preserva `repOK()`.**
Una de las propiedades clásicas de los invariantes de representación: cualquier operación pública sobre un objeto válido debe dejarlo en un estado igualmente válido. Se valida `repOK()` antes de remover, se ejecuta `removeIndex`, y se vuelve a validar `repOK()`. Si alguna de las operaciones internas (manejo de enlaces, paso de nodo a cache, decremento de `size`, etc.) dejara la estructura inconsistente, esta propiedad lo detectaría.

Cada propiedad corre **200 iteraciones** (`tries = 200`), lo que da buena cobertura sin volver la suite lenta.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: **BUILD SUCCESS** con las tres propiedades ejecutándose correctamente.

## Nota sobre el entorno

El template originalmente usa `jacoco-maven-plugin 0.8.2`, que es incompatible con Java 25 (falla al instrumentar clases). Por eso, para validar localmente se fijó `JAVA_HOME` a Java 17 y se desactivó Jacoco con `-Djacoco.skip=true`. Esto no afecta la corrida de los tests: solo evita que el plugin de cobertura rompa el build en un entorno más nuevo.
