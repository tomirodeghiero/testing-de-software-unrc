# Ejercicio 1

Se considera el siguiente grafo dirigido:

- `N = {1, 2, 3, 4}`
- `N0 = {1}` (nodo inicial)
- `Nf = {4}` (nodo final)
- `E = {(1,2), (2,3), (3,2), (2,4)}`

Antes de analizar las coberturas conviene observar la estructura del grafo, ya que esto simplifica mucho el razonamiento posterior:

- Desde `1` la única salida posible es hacia `2`.
- Desde `2` se puede ir a `3` o a `4`.
- Desde `3` la única salida es volver a `2`.
- `4` es nodo final y no tiene aristas salientes.

Como consecuencia, todo camino de test válido (el que arranca en `1` y termina en `4`) tiene necesariamente la siguiente forma:

- `1 -> 2 -> (ciclo 2 <-> 3 repetido cero o más veces) -> 4`

Algunos ejemplos de caminos de test válidos son:

- `[1, 2, 4]`
- `[1, 2, 3, 2, 4]`
- `[1, 2, 3, 2, 3, 2, 4]`
- y así sucesivamente.

Para razonar las coberturas que se piden, conviene listar previamente los requisitos alcanzables en cada criterio:

- **NC** (cobertura de nodos): `{1, 2, 3, 4}`
- **EC** (cobertura de arcos): `{(1,2), (2,3), (3,2), (2,4)}`
- **EPC** (cobertura de pares de arcos, es decir, caminos de longitud 2):
  - `[1, 2, 3]`
  - `[1, 2, 4]`
  - `[2, 3, 2]`
  - `[3, 2, 3]`
  - `[3, 2, 4]`

### (a) Cobertura de Nodos pero no Cobertura de Arcos

**No es posible** construir un conjunto de tests que satisfaga NC sin satisfacer también EC.

La razón es la siguiente: cumplir NC obliga a visitar los cuatro nodos `1`, `2`, `3` y `4`, y dada la topología del grafo cada una de esas visitas fuerza el uso de un arco específico:

1. Visitar `1` obliga a usar `(1,2)`, ya que es la única arista saliente de `1`.
2. Visitar `3` obliga a usar `(2,3)`, porque es la única arista que entra a `3`.
3. Una vez en `3`, para poder seguir avanzando hacia un nodo final hay que tomar `(3,2)`, que es la única arista de salida de `3`.
4. Para terminar en el nodo final `4` se debe usar `(2,4)`, ya que es la única arista que entra a `4`.

Estos cuatro arcos son exactamente los elementos de EC, por lo que cualquier conjunto de tests que cumpla NC termina inevitablemente cubriendo también EC. Es decir, en este grafo no existe un conjunto que satisfaga NC y a la vez falle EC.

### (b) Cobertura de Arcos pero no Cobertura de Pares de Arcos

**Sí es posible** encontrar un conjunto que cumpla EC pero no EPC.

Un ejemplo concreto es:

- `t1 = [1, 2, 3, 2, 4]`

Verificación de EC con `t1`:

- En el paso `1 -> 2` se recorre `(1,2)`.
- En el paso `2 -> 3` se recorre `(2,3)`.
- En el paso `3 -> 2` se recorre `(3,2)`.
- En el paso `2 -> 4` se recorre `(2,4)`.

Por lo tanto, EC queda completamente satisfecha con un único test.

Sin embargo, si se analizan los pares de arcos cubiertos (mirando ventanas deslizantes de tres nodos consecutivos en el camino), se obtiene:

- `[1, 2, 3]`
- `[2, 3, 2]`
- `[3, 2, 4]`

Quedan sin cubrir al menos los siguientes pares alcanzables:

- `[1, 2, 4]`
- `[3, 2, 3]`

Esto muestra que `t1` cumple EC pero no EPC, que es justamente lo que se buscaba.

### (c) Caminos para satisfacer Cobertura de Pares de Arcos

Un conjunto mínimo que satisface EPC es:

- `t1 = [1, 2, 4]`
- `t2 = [1, 2, 3, 2, 3, 2, 4]`

Pares cubiertos por cada test:

- `t1 = [1, 2, 4]` cubre: `[1, 2, 4]`.
- `t2 = [1, 2, 3, 2, 3, 2, 4]` cubre: `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 3]` y `[3, 2, 4]`.

Uniendo ambos tests se obtiene la siguiente cobertura:

- `[1, 2, 3]`
- `[1, 2, 4]`
- `[2, 3, 2]`
- `[3, 2, 3]`
- `[3, 2, 4]`

Estos son exactamente los cinco pares alcanzables que habíamos listado al principio, por lo que EPC queda satisfecha.

**Por qué este conjunto es mínimo (es decir, por qué no alcanza con un solo test):**

1. Para cubrir `[1, 2, 4]` el test debe pasar de `2` directamente a `4`.
2. Para cubrir `[1, 2, 3]` el test debe pasar de `2` directamente a `3`.
3. Ambas condiciones son incompatibles dentro del mismo prefijo, porque al estar en `1, 2` solo se puede elegir una salida (o `3` o `4`).
4. Como cualquier test termina al llegar a `4`, una vez tomada esa rama no se puede "volver atrás" para cubrir la otra alternativa.

Por lo tanto, hacen falta al menos dos tests. El conjunto propuesto utiliza exactamente dos, por lo que es mínimo.
