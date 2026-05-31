# Ejercicio 1 — Cobertura sobre grafo de 4 nodos (NC, EC, EPC)

## El grafo

Grafo dirigido:

- `N = {1, 2, 3, 4}`
- `N0 = {1}` (nodo inicial)
- `Nf = {4}` (nodo final)
- `E = {(1,2), (2,3), (3,2), (2,4)}`

Estructura:

- Desde `1` la única salida es `2`.
- Desde `2` se va a `3` o a `4`.
- Desde `3` la única salida es volver a `2`.
- `4` es nodo final, sin aristas salientes.

Todo camino de test válido (de `1` a `4`) tiene la forma:

- `1 → 2 → (ciclo 2 ↔ 3 repetido cero o más veces) → 4`

Por ejemplo: `[1, 2, 4]`, `[1, 2, 3, 2, 4]`, `[1, 2, 3, 2, 3, 2, 4]`, etc.

Requisitos por criterio:

- **NC** (cobertura de nodos): `{1, 2, 3, 4}`
- **EC** (cobertura de arcos): `{(1,2), (2,3), (3,2), (2,4)}`
- **EPC** (cobertura de pares de arcos): `[1, 2, 3]`, `[1, 2, 4]`, `[2, 3, 2]`, `[3, 2, 3]`, `[3, 2, 4]`.

## (a) ¿NC sin EC?

**No es posible.** Cumplir NC obliga a visitar los cuatro nodos, y dada la topología cada visita fuerza un arco específico:

1. Visitar `1` obliga a usar `(1, 2)` (única arista saliente de `1`).
2. Visitar `3` obliga a usar `(2, 3)` (única que entra a `3`).
3. Desde `3` solo se puede salir por `(3, 2)`.
4. Terminar en `4` obliga a usar `(2, 4)` (única que entra a `4`).

Esos cuatro arcos son exactamente EC, así que cualquier suite que cumpla NC también cumple EC.

## (b) ¿EC sin EPC?

**Sí.** Un ejemplo concreto:

- `t1 = [1, 2, 3, 2, 4]`

Recorre los cuatro arcos (`(1,2)`, `(2,3)`, `(3,2)`, `(2,4)`), así que EC queda cubierta con un solo test.

Pares de arcos que ese camino cubre (ventana de tres nodos consecutivos):

- `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 4]`

Quedan sin cubrir al menos `[1, 2, 4]` y `[3, 2, 3]`, así que EPC no se satisface.

## (c) Conjunto mínimo que satisface EPC

Dos tests alcanzan:

- `t1 = [1, 2, 4]`
- `t2 = [1, 2, 3, 2, 3, 2, 4]`

Pares cubiertos:

- `t1` cubre `[1, 2, 4]`.
- `t2` cubre `[1, 2, 3]`, `[2, 3, 2]`, `[3, 2, 3]`, `[3, 2, 4]`.

La unión cubre los cinco pares alcanzables, así que EPC queda satisfecha.

**Por qué no alcanza con un solo test:**

- Para cubrir `[1, 2, 4]` el test tiene que ir directo de `2` a `4`.
- Para cubrir `[1, 2, 3]` el test tiene que ir de `2` a `3`.
- Las dos cosas son incompatibles en el mismo prefijo `1, 2`, y una vez que se llega a `4` no hay vuelta atrás.

Hacen falta como mínimo dos tests, y el conjunto propuesto usa exactamente dos.

## Enlaces

- Enunciado: [`practico4.pdf`](/pdfs/tp4/practico4.pdf)
- Resolución: [`resolucion_practico4.pdf`](/pdfs/tp4/resolucion_practico4.pdf)
