# Ejercicio 1

Para el grafo:

- `N = {1,2,3,4}`
- `N0 = {1}`
- `Nf = {4}`
- `E = {(1,2), (2,3), (3,2), (2,4)}`

Primero, una observacion clave sobre la estructura del grafo:

- Desde `1` solo se puede ir a `2`.
- Desde `2` se puede ir a `3` o a `4`.
- Desde `3` solo se puede volver a `2`.
- `4` es final y no tiene salidas.

Entonces, cualquier camino de test valido (empieza en `1` y termina en `4`) tiene esta forma:

- `1 -> 2 -> (ciclo 2 <-> 3 repetido cero o mas veces) -> 4`

Ejemplos de caminos de test validos:

- `[1,2,4]`
- `[1,2,3,2,4]`
- `[1,2,3,2,3,2,4]`
- etc.

Para razonar mejor las coberturas, listamos los requisitos alcanzables:

- NC (nodos): `{1,2,3,4}`
- EC (arcos): `{(1,2), (2,3), (3,2), (2,4)}`
- EPC (pares de arcos / caminos de longitud 2):
- `[1,2,3]`
- `[1,2,4]`
- `[2,3,2]`
- `[3,2,3]`
- `[3,2,4]`

### (a) Cobertura de Nodos pero no Cobertura de Arcos

No es posible.

Demostracion paso a paso:

1. Para cumplir NC hay que visitar `1,2,3,4`.
2. Visitar `1` obliga a usar `(1,2)` para poder avanzar (es la unica salida de `1`).
3. Visitar `3` obliga a usar `(2,3)` (es la unica entrada a `3`).
4. Luego de estar en `3`, para poder continuar hacia un final hay que usar `(3,2)` (es la unica salida de `3`).
5. Para terminar en el nodo final `4`, necesariamente se usa `(2,4)` (es la unica entrada a `4`).

Con esos cinco puntos, todo conjunto de tests que satisface NC termina cubriendo todos los arcos de EC.  
Por lo tanto, en este grafo no existe un conjunto que cumpla NC y falle EC.

### (b) Cobertura de Arcos pero no Cobertura de Pares de Arcos

Si es posible.

Un conjunto de test que cumple EC pero no EPC es:

- `t1 = [1,2,3,2,4]`

Verificacion de EC para `t1`:

- Recorre `(1,2)` en el paso `1 -> 2`.
- Recorre `(2,3)` en el paso `2 -> 3`.
- Recorre `(3,2)` en el paso `3 -> 2`.
- Recorre `(2,4)` en el paso `2 -> 4`.

Entonces EC queda satisfecha.

Ahora revisamos EPC.  
Los pares de arcos que aparecen en `t1` (ventana deslizante de 3 nodos) son:

- `[1,2,3]`
- `[2,3,2]`
- `[3,2,4]`

Pero faltan al menos estos dos pares alcanzables:

- `[1,2,4]`
- `[3,2,3]`

Entonces `t1` cumple EC pero no EPC, que es exactamente lo que pedia el item.

### (c) Caminos para satisfacer Cobertura de Pares de Arcos

Un conjunto minimo que satisface EPC es:

- `t1 = [1,2,4]`
- `t2 = [1,2,3,2,3,2,4]`

Comprobacion detallada:

- Pares cubiertos por `t1 = [1,2,4]`:
- `[1,2,4]`

- Pares cubiertos por `t2 = [1,2,3,2,3,2,4]`:
- `[1,2,3]`
- `[2,3,2]`
- `[3,2,3]`
- `[3,2,4]`

Union total cubierta por `t1 U t2`:

- `[1,2,3]`
- `[1,2,4]`
- `[2,3,2]`
- `[3,2,3]`
- `[3,2,4]`

Eso coincide con todos los pares alcanzables, por lo tanto EPC queda satisfecha.

Por que este conjunto es minimo (2 tests):

1. Para cubrir `[1,2,4]`, el test debe ir a `4` inmediatamente despues de `2`.
2. Para cubrir `[1,2,3]`, el test debe ir a `3` inmediatamente despues de `2`.
3. Ambas condiciones son incompatibles en un mismo prefijo que empieza en `1` (desde `1,2` hay que elegir una sola salida en ese punto).
4. Como todo test termina al llegar a `4`, no se puede "volver atras" para cubrir la otra alternativa.

Por eso, hace falta al menos 2 tests. El conjunto propuesto usa exactamente 2, asi que es minimo.

