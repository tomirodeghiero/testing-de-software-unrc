---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp4/ejercicio2/"
description: "Contenido importado desde tp4/ejercicio2/README.md"
---

# Ejercicio 2

Se considera el siguiente grafo dirigido:

- `N = {1, 2, 3, 4, 5, 6, 7}`
- `N0 = {1}` (nodo inicial)
- `Nf = {7}` (nodo final)
- `E = {(1,2), (1,7), (2,3), (2,4), (3,2), (4,5), (4,6), (5,6), (6,1)}`

Caminos candidatos dados por el enunciado:

- `p1 = [1, 2, 4, 5, 6, 1, 7]`
- `p2 = [1, 2, 3, 2, 4, 6, 1, 7]`
- `p3 = [1, 2, 3, 2, 4, 5, 6, 1, 7]`

### (a) Requisitos de test para cobertura de pares de aristas

Los pares de aristas alcanzables (caminos de longitud 2 dentro del grafo) son los siguientes 12:

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

### (b) ¿El conjunto candidato satisface cobertura de pares?

**No**, el conjunto `{p1, p2, p3}` no satisface la cobertura de pares de aristas.

Para justificarlo, analizamos los pares cubiertos por cada uno de los caminos:

- `p1 = [1, 2, 4, 5, 6, 1, 7]` cubre: `[1, 2, 4]`, `[2, 4, 5]`, `[4, 5, 6]`, `[5, 6, 1]` y `[6, 1, 7]`.
- `p2 = [1, 2, 3, 2, 4, 6, 1, 7]` cubre: `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 4]`, `[2, 4, 6]`, `[4, 6, 1]` y `[6, 1, 7]`.
- `p3 = [1, 2, 3, 2, 4, 5, 6, 1, 7]` cubre: `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 4]`, `[2, 4, 5]`, `[4, 5, 6]`, `[5, 6, 1]` y `[6, 1, 7]`.

La unión `p1 ∪ p2 ∪ p3` cubre los siguientes pares:

- `[1, 2, 3]`, `[1, 2, 4]`, `[2, 3, 2]`, `[2, 4, 5]`, `[2, 4, 6]`, `[3, 2, 4]`, `[4, 5, 6]`, `[4, 6, 1]`, `[5, 6, 1]` y `[6, 1, 7]`.

Quedan sin cubrir dos pares de aristas:

- `[3, 2, 3]`
- `[6, 1, 2]`

Por lo tanto, el conjunto candidato no satisface la cobertura de pares.

### (c) Tour directo o con sidetrips

Se propone el siguiente camino simple:

- `q = [3, 2, 4, 5, 6]`

Y el camino de test:

- `t = [1, 2, 3, 2, 4, 6, 1, 2, 4, 5, 6, 1, 7]`

Análisis:

1. `t` **no** recorre `q` de manera directa, ya que cuando `t` llega al nodo `4` por primera vez toma la rama `4 -> 6` en lugar de `4 -> 5`, mientras que `q` exige el paso `4 -> 5`.
2. `t` **sí** recorre `q` mediante un sidetrip.

Detalle del sidetrip:

- Desde el nodo `4`, el camino se desvía recorriendo `[4, 6, 1, 2, 4]` y luego retoma con `4 -> 5 -> 6`, completando así la secuencia exigida por `q`.
- Como ese desvío sale del nodo `4` y vuelve al mismo nodo `4`, se cumple exactamente la definición de sidetrip.

### (d) Requisitos para NC, EC y PPC

**NC (Cobertura de Nodos):**

- `{1, 2, 3, 4, 5, 6, 7}`

**EC (Cobertura de Arcos):**

- `(1,2)`, `(1,7)`, `(2,3)`, `(2,4)`, `(3,2)`, `(4,5)`, `(4,6)`, `(5,6)`, `(6,1)`

**PPC (Cobertura de Caminos Principales o Prime Paths):**

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

### (e) Caminos que satisfacen NC pero no EC

**Sí es posible** construir un conjunto de tests que cumpla NC sin cumplir EC.

Un ejemplo es:

- `t = [1, 2, 3, 2, 4, 5, 6, 1, 7]`

Este test pasa por todos los nodos del grafo (`1`, `2`, `3`, `4`, `5`, `6` y `7`), por lo que satisface NC. Sin embargo, no recorre el arco `(4, 6)`, ya que al llegar a `4` toma la rama hacia `5`. Como ese arco pertenece a EC y no aparece en el camino, EC no queda satisfecha.

### (f) Caminos que satisfacen EC pero no PPC

**Sí es posible** encontrar un conjunto que satisfaga EC sin satisfacer PPC.

Un ejemplo es:

- `t1 = [1, 2, 4, 5, 6, 1, 7]`
- `t2 = [1, 2, 3, 2, 4, 6, 1, 7]`

Verificación:

- La unión `t1 ∪ t2` recorre los nueve arcos del grafo: `(1,2)`, `(1,7)`, `(2,3)`, `(2,4)`, `(3,2)`, `(4,5)`, `(4,6)`, `(5,6)` y `(6,1)`. Por lo tanto, EC queda satisfecha.
- Sin embargo, no se recorren todos los caminos principales: por ejemplo, el prime path `[3, 2, 3]` no aparece en ninguno de los dos tests, ya que ninguno toma dos veces seguidas el ciclo `2 -> 3 -> 2`.

Como queda al menos un prime path sin cubrir, el conjunto propuesto satisface EC pero no PPC.
