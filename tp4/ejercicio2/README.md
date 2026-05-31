# Ejercicio 2 — Cobertura sobre grafo de 7 nodos, *sidetrips* y PPC

## El grafo

- `N = {1, 2, 3, 4, 5, 6, 7}`
- `N0 = {1}` (nodo inicial)
- `Nf = {7}` (nodo final)
- `E = {(1,2), (1,7), (2,3), (2,4), (3,2), (4,5), (4,6), (5,6), (6,1)}`

Caminos candidatos del enunciado:

- `p1 = [1, 2, 4, 5, 6, 1, 7]`
- `p2 = [1, 2, 3, 2, 4, 6, 1, 7]`
- `p3 = [1, 2, 3, 2, 4, 5, 6, 1, 7]`

## (a) Requisitos para EPC

Los 12 pares de arcos alcanzables:

1. `[1, 2, 3]`
2. `[1, 2, 4]`
3. `[2, 3, 2]`
4. `[2, 4, 5]`
5. `[2, 4, 6]`
6. `[3, 2, 3]`
7. `[3, 2, 4]`
8. `[4, 5, 6]`
9. `[4, 6, 1]`
10. `[5, 6, 1]`
11. `[6, 1, 2]`
12. `[6, 1, 7]`

## (b) ¿El conjunto candidato satisface EPC?

**No.** Los pares cubiertos por cada uno:

- `p1` cubre `[1, 2, 4]`, `[2, 4, 5]`, `[4, 5, 6]`, `[5, 6, 1]`, `[6, 1, 7]`.
- `p2` cubre `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 4]`, `[2, 4, 6]`, `[4, 6, 1]`, `[6, 1, 7]`.
- `p3` cubre `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 4]`, `[2, 4, 5]`, `[4, 5, 6]`, `[5, 6, 1]`, `[6, 1, 7]`.

La unión cubre 10 de los 12 pares. Quedan sin cubrir:

- `[3, 2, 3]`
- `[6, 1, 2]`

Por eso el conjunto candidato no satisface EPC.

## (c) Tour directo vs con *sidetrip*

Se propone:

- camino simple `q = [3, 2, 4, 5, 6]`
- camino de test `t = [1, 2, 3, 2, 4, 6, 1, 2, 4, 5, 6, 1, 7]`

`t` **no** recorre `q` de manera directa: cuando llega a `4` por primera vez toma la rama `4 → 6` en lugar de `4 → 5`, mientras que `q` exige `4 → 5`.

Pero `t` **sí** recorre `q` mediante un *sidetrip*: desde el nodo `4` se desvía por `[4, 6, 1, 2, 4]` y al volver a `4` retoma con `4 → 5 → 6`, completando la secuencia de `q`. Como el desvío sale de `4` y vuelve al mismo nodo `4`, encaja en la definición de *sidetrip*.

## (d) Requisitos para NC, EC y PPC

**NC**: `{1, 2, 3, 4, 5, 6, 7}`.

**EC**: `(1,2)`, `(1,7)`, `(2,3)`, `(2,4)`, `(3,2)`, `(4,5)`, `(4,6)`, `(5,6)`, `(6,1)`.

**PPC** (prime paths): 15 caminos.

1. `[1, 2, 4, 6, 1]`
2. `[1, 2, 4, 5, 6, 1]`
3. `[2, 3, 2]`
4. `[2, 4, 6, 1, 2]`
5. `[2, 4, 5, 6, 1, 2]`
6. `[3, 2, 3]`
7. `[3, 2, 4, 6, 1, 7]`
8. `[3, 2, 4, 5, 6, 1, 7]`
9. `[4, 6, 1, 2, 3]`
10. `[4, 6, 1, 2, 4]`
11. `[4, 5, 6, 1, 2, 3]`
12. `[4, 5, 6, 1, 2, 4]`
13. `[5, 6, 1, 2, 4, 5]`
14. `[6, 1, 2, 4, 6]`
15. `[6, 1, 2, 4, 5, 6]`

## (e) NC sin EC

**Sí es posible.** Por ejemplo:

- `t = [1, 2, 3, 2, 4, 5, 6, 1, 7]`

Pasa por los siete nodos (cumple NC), pero al llegar a `4` toma la rama hacia `5` y nunca recorre el arco `(4, 6)`. Como ese arco está en EC, EC no queda satisfecha.

## (f) EC sin PPC

**Sí es posible.** Por ejemplo:

- `t1 = [1, 2, 4, 5, 6, 1, 7]`
- `t2 = [1, 2, 3, 2, 4, 6, 1, 7]`

La unión recorre los nueve arcos del grafo, así que EC se cumple. Pero ninguno de los dos tests pasa dos veces seguidas por el ciclo `2 → 3 → 2`, así que el prime path `[3, 2, 3]` queda sin cubrir. PPC no se satisface.

## Enlaces

- Enunciado: [`practico4.pdf`](/pdfs/tp4/practico4.pdf)
- Resolución: [`resolucion_practico4.pdf`](/pdfs/tp4/resolucion_practico4.pdf)
