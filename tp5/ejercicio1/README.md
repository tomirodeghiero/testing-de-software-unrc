# Ejercicio 1

En este ejercicio resuelvo los cinco predicados propuestos y dejo, para cada uno, los incisos (a) a (f) completos:

1. `p = a ∨ (b ∧ c)`
2. `p = a → (b → c)`
3. `p = (a ∨ b) ∧ (c ∨ d)`
4. `p = a ⊕ b`
5. `p = a ∨ b ∨ (c ∧ d)`

Convención usada en todas las tablas:

- Las filas están numeradas en orden lexicográfico con `T` antes que `F`.
- En `e)` y `f)`, los pares se listan como `(fila_i, fila_j)`.

## 1) `p = a ∨ (b ∧ c)`

a) Cláusulas de `p`:

- `a`, `b`, `c`

b) Tabla de verdad:

| Fila | a | b | c | p |
|---|---|---|---|---|
| 1 | T | T | T | T |
| 2 | T | T | F | T |
| 3 | T | F | T | T |
| 4 | T | F | F | T |
| 5 | F | T | T | T |
| 6 | F | T | F | F |
| 7 | F | F | T | F |
| 8 | F | F | F | F |

c) CC pero no PC:

- `{fila 4, fila 5}`

d) PC pero no CC:

- `{fila 1, fila 6}`

e) Pares que satisfacen CACC:

- mayor `a`: `(2,6), (2,7), (2,8), (3,6), (3,7), (3,8), (4,6), (4,7), (4,8)`
- mayor `b`: `(5,7)`
- mayor `c`: `(5,6)`

f) Pares que satisfacen RACC:

- mayor `a`: `(2,6), (3,7), (4,8)`
- mayor `b`: `(5,7)`
- mayor `c`: `(5,6)`

## 2) `p = a → (b → c)`

a) Cláusulas de `p`:

- `a`, `b`, `c`

b) Tabla de verdad:

| Fila | a | b | c | p |
|---|---|---|---|---|
| 1 | T | T | T | T |
| 2 | T | T | F | F |
| 3 | T | F | T | T |
| 4 | T | F | F | T |
| 5 | F | T | T | T |
| 6 | F | T | F | T |
| 7 | F | F | T | T |
| 8 | F | F | F | T |

c) CC pero no PC:

- `{fila 1, fila 8}`

d) PC pero no CC:

- `{fila 1, fila 2}`

e) Pares que satisfacen CACC:

- mayor `a`: `(2,6)`
- mayor `b`: `(2,4)`
- mayor `c`: `(1,2)`

f) Pares que satisfacen RACC:

- mayor `a`: `(2,6)`
- mayor `b`: `(2,4)`
- mayor `c`: `(1,2)`

## 3) `p = (a ∨ b) ∧ (c ∨ d)`

a) Cláusulas de `p`:

- `a`, `b`, `c`, `d`

b) Tabla de verdad:

| Fila | a | b | c | d | p |
|---|---|---|---|---|---|
| 1 | T | T | T | T | T |
| 2 | T | T | T | F | T |
| 3 | T | T | F | T | T |
| 4 | T | T | F | F | F |
| 5 | T | F | T | T | T |
| 6 | T | F | T | F | T |
| 7 | T | F | F | T | T |
| 8 | T | F | F | F | F |
| 9 | F | T | T | T | T |
| 10 | F | T | T | F | T |
| 11 | F | T | F | T | T |
| 12 | F | T | F | F | F |
| 13 | F | F | T | T | F |
| 14 | F | F | T | F | F |
| 15 | F | F | F | T | F |
| 16 | F | F | F | F | F |

c) CC pero no PC:

- `{fila 4, fila 13}`

d) PC pero no CC:

- `{fila 1, fila 4}`

e) Pares que satisfacen CACC:

- mayor `a`: `(5,13), (5,14), (5,15), (6,13), (6,14), (6,15), (7,13), (7,14), (7,15)`
- mayor `b`: `(9,13), (9,14), (9,15), (10,13), (10,14), (10,15), (11,13), (11,14), (11,15)`
- mayor `c`: `(2,4), (2,8), (2,12), (4,6), (4,10), (6,8), (6,12), (8,10), (10,12)`
- mayor `d`: `(3,4), (3,8), (3,12), (4,7), (4,11), (7,8), (7,12), (8,11), (11,12)`

f) Pares que satisfacen RACC:

- mayor `a`: `(5,13), (6,14), (7,15)`
- mayor `b`: `(9,13), (10,14), (11,15)`
- mayor `c`: `(2,4), (6,8), (10,12)`
- mayor `d`: `(3,4), (7,8), (11,12)`

## 4) `p = a ⊕ b`

a) Cláusulas de `p`:

- `a`, `b`

b) Tabla de verdad:

| Fila | a | b | p |
|---|---|---|---|
| 1 | T | T | F |
| 2 | T | F | T |
| 3 | F | T | T |
| 4 | F | F | F |

c) CC pero no PC:

- `{fila 1, fila 4}`

d) PC pero no CC:

- `{fila 1, fila 2}`

e) Pares que satisfacen CACC:

- mayor `a`: `(1,3), (2,4)`
- mayor `b`: `(1,2), (3,4)`

f) Pares que satisfacen RACC:

- mayor `a`: `(1,3), (2,4)`
- mayor `b`: `(1,2), (3,4)`

## 5) `p = a ∨ b ∨ (c ∧ d)`

a) Cláusulas de `p`:

- `a`, `b`, `c`, `d`

b) Tabla de verdad:

| Fila | a | b | c | d | p |
|---|---|---|---|---|---|
| 1 | T | T | T | T | T |
| 2 | T | T | T | F | T |
| 3 | T | T | F | T | T |
| 4 | T | T | F | F | T |
| 5 | T | F | T | T | T |
| 6 | T | F | T | F | T |
| 7 | T | F | F | T | T |
| 8 | T | F | F | F | T |
| 9 | F | T | T | T | T |
| 10 | F | T | T | F | T |
| 11 | F | T | F | T | T |
| 12 | F | T | F | F | T |
| 13 | F | F | T | T | T |
| 14 | F | F | T | F | F |
| 15 | F | F | F | T | F |
| 16 | F | F | F | F | F |

c) CC pero no PC:

- `{fila 4, fila 13}`

d) PC pero no CC:

- `{fila 1, fila 14}`

e) Pares que satisfacen CACC:

- mayor `a`: `(6,14), (6,15), (6,16), (7,14), (7,15), (7,16), (8,14), (8,15), (8,16)`
- mayor `b`: `(10,14), (10,15), (10,16), (11,14), (11,15), (11,16), (12,14), (12,15), (12,16)`
- mayor `c`: `(13,15)`
- mayor `d`: `(13,14)`

f) Pares que satisfacen RACC:

- mayor `a`: `(6,14), (7,15), (8,16)`
- mayor `b`: `(10,14), (11,15), (12,16)`
- mayor `c`: `(13,15)`
- mayor `d`: `(13,14)`
