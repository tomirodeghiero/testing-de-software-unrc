# Ejercicio 3 — `intersection`: análisis del MDE y *Base Choice*

## Consigna

Sobre `SetUtils.intersection(Set<Integer> set1, Set<Integer> set2)`, partiendo del MDE provisto por la cátedra (C1, C2 y C3), hay que:

- **a, b)** verificar si C1 y C2 son completas y disjuntas;
- **c, d)** verificar si C3 lo es;
- **e)** si algo falla, corregir el MDE;
- **f)** derivar requisitos por *Base Choice Coverage* (BCC), implementar los casos y completar la rutina.

## a) y b) — C1 (idem C2)

**Completa y disjunta.** Para `Set<Integer> set1` solo hay tres posibilidades, y los bloques las cubren exactamente:

- `set1 == null`,
- `set1 != null` y vacío,
- `set1 != null` y con al menos un elemento.

No hay solapamiento porque un set nulo no puede a la vez ser vacío o no vacío.

## c) — C3 no es completa

Contraejemplo:

- `set1 = {1, 2}`, `set2 = {2, 3}`

Hay intersección no vacía (`{2}`), pero no son iguales, ninguno es subconjunto del otro, y tampoco son disjuntos. Esa configuración no entra en ningún bloque del C3 original.

## d) — C3 tampoco es disjunta

Contraejemplo:

- `set1 = {1, 2}`, `set2 = {1, 2}`

Cae al mismo tiempo en `b1` (son iguales), `b2` (`set1` es subconjunto de `set2`) y `b3` (`set2` es subconjunto de `set1`). El problema es que "subconjunto" no se definió como **propio**.

## e) — MDE corregido

C1 y C2 quedan igual. C3 se reescribe con "subconjunto propio" y se agrega un bloque para el solapamiento parcial:

### C3 (relación entre `set1` y `set2`), solo si ambos no nulos

- **C3.b1**: `set1 = set2`
- **C3.b2**: `set1` es subconjunto **propio** de `set2`
- **C3.b3**: `set2` es subconjunto **propio** de `set1`
- **C3.b4**: `set1` y `set2` disjuntos
- **C3.b5**: intersección no vacía pero ninguno es subconjunto del otro (solapamiento parcial)

Con esto C3 queda completa y disjunta.

## f) — Base Choice Coverage

Caso base elegido (camino feliz): ambos sets no vacíos e iguales.

- C1 base: C1.b3 (`set1` no vacío)
- C2 base: C2.b3 (`set2` no vacío)
- C3 base: C3.b1 (sets iguales)

Requisitos: el test base, más uno por cada bloque no base, ajustando cuando alguna variación deja a C3 sin aplicar.

| ID       | Variación respecto del base    | Resultado esperado                |
|----------|--------------------------------|-----------------------------------|
| TR-BC1   | (caso base)                    | intersección igual a `set1`       |
| TR-BC2   | C1 → C1.b1 (`null`)            | `NullPointerException`            |
| TR-BC3   | C1 → C1.b2 (vacío, C3 ajust.)  | intersección vacía                |
| TR-BC4   | C2 → C2.b1 (`null`)            | `NullPointerException`            |
| TR-BC5   | C2 → C2.b2 (vacío, C3 ajust.)  | intersección vacía                |
| TR-BC6   | C3 → C3.b2                     | resultado `set1`                  |
| TR-BC7   | C3 → C3.b3                     | resultado `set2`                  |
| TR-BC8   | C3 → C3.b4                     | resultado vacío                   |
| TR-BC9   | C3 → C3.b5                     | elementos comunes parciales       |

## Casos implementados

`IntersectionTest.java` cubre `TC1` a `TC9` (uno por TR-BC). También:

- verifica que los sets de entrada no se modifican;
- verifica que el resultado es una nueva instancia;
- agrega un borde con ambos sets vacíos.

## La rutina

`intersection` valida con `Objects.requireNonNull` (lanza `NullPointerException` si alguno es `null`), copia `set1` y aplica `retainAll(set2)`. Así se garantiza que los sets de entrada no se modifican y que el retorno es una nueva instancia.

## Cómo correr

```bash
cd tp3/assignmnet-3-rodeghiero
mvn -Dmaven.repo.local=.m2 -Dtest=IntersectionTest test
```

## Archivos

- [`SetUtils.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/SetUtils.java) — implementación de `intersection`.
- [`IntersectionTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IntersectionTest.java) — los 9 casos BCC y los chequeos extra.

## Enlaces

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
