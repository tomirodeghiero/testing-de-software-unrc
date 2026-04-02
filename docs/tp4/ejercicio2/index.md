---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp4/ejercicio2/"
description: "Contenido importado desde tp4/ejercicio2/README.md"
---

# Ejercicio 2

Para el grafo:

- `N = {1,2,3,4,5,6,7}`
- `N0 = {1}`
- `Nf = {7}`
- `E = {(1,2), (1,7), (2,3), (2,4), (3,2), (4,5), (4,6), (5,6), (6,1)}`

Caminos candidatos dados:

- `p1 = [1,2,4,5,6,1,7]`
- `p2 = [1,2,3,2,4,6,1,7]`
- `p3 = [1,2,3,2,4,5,6,1,7]`

### (a) Requisitos de test para cobertura de pares de aristas (12)

Los pares de aristas alcanzables (caminos de longitud 2) son:

1. `[1,2,3]`
2. `[1,2,4]`
3. `[2,3,2]`
4. `[2,4,5]`
5. `[2,4,6]`
6. `[3,2,3]`
7. `[3,2,4]`
8. `[4,5,6]`
9. `[4,6,1]`
10. `[5,6,1]`
11. `[6,1,2]`
12. `[6,1,7]`

### (b) El conjunto candidato satisface cobertura de pares?

No, no la satisface.

Pares que cubre cada camino:

- `p1` cubre: `[1,2,4]`, `[2,4,5]`, `[4,5,6]`, `[5,6,1]`, `[6,1,7]`
- `p2` cubre: `[1,2,3]`, `[2,3,2]`, `[3,2,4]`, `[2,4,6]`, `[4,6,1]`, `[6,1,7]`
- `p3` cubre: `[1,2,3]`, `[2,3,2]`, `[3,2,4]`, `[2,4,5]`, `[4,5,6]`, `[5,6,1]`, `[6,1,7]`

Union total cubierta por `p1 U p2 U p3`:

- `[1,2,3]`, `[1,2,4]`, `[2,3,2]`, `[2,4,5]`, `[2,4,6]`, `[3,2,4]`, `[4,5,6]`, `[4,6,1]`, `[5,6,1]`, `[6,1,7]`

Requisitos faltantes:

- `[3,2,3]`
- `[6,1,2]`

### (c) Tour directo o con sidetrips

Camino simple:

- `q = [3,2,4,5,6]`

Camino de test:

- `t = [1,2,3,2,4,6,1,2,4,5,6,1,7]`

Resultado:

1. `t` **no** recorre `q` directamente, porque al llegar a `4` hace `4 -> 6` y no `4 -> 5`.
2. `t` **si** recorre `q` con sidetrip.

Sidetrip:

- Desde el nodo `4`, el desvio es `[4,6,1,2,4]`, y luego continua con `4 -> 5 -> 6`.
- Ese desvio sale de `4` y vuelve al mismo `4`, por eso cumple la idea de sidetrip.

### (d) Requisitos para NC, EC y PPC

NC (Cobertura de Nodos):

- `{1,2,3,4,5,6,7}`

EC (Cobertura de Arcos):

- `(1,2)`, `(1,7)`, `(2,3)`, `(2,4)`, `(3,2)`, `(4,5)`, `(4,6)`, `(5,6)`, `(6,1)`

PPC (Cobertura de Caminos Principales / Prime Paths):

1. `[1,2,4,6,1]`
2. `[1,2,4,5,6,1]`
3. `[2,3,2]`
4. `[2,4,6,1,2]`
5. `[2,4,5,6,1,2]`
6. `[3,2,3]`
7. `[3,2,4,6,1,7]`
8. `[3,2,4,5,6,1,7]`
9. `[4,6,1,2,3]`
10. `[4,6,1,2,4]`
11. `[4,5,6,1,2,3]`
12. `[4,5,6,1,2,4]`
13. `[5,6,1,2,4,5]`
14. `[6,1,2,4,6]`
15. `[6,1,2,4,5,6]`

### (e) Proveer caminos que satisfagan NC pero no EC

Si es posible.

Un ejemplo:

- `t = [1,2,3,2,4,5,6,1,7]`

Este test visita todos los nodos `1..7`, por lo tanto satisface NC.  
Pero no recorre el arco `(4,6)`, asi que no satisface EC.

### (f) Proveer caminos que satisfagan EC pero no PPC

Si es posible.

Un ejemplo:

- `t1 = [1,2,4,5,6,1,7]`
- `t2 = [1,2,3,2,4,6,1,7]`

Verificacion rapida:

- `t1 U t2` cubre todos los arcos de EC.
- Pero no cubre todos los caminos principales (por ejemplo, no cubre el prime path `[3,2,3]`).

Entonces cumple EC pero no PPC.

