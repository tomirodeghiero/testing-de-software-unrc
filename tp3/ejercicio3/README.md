# Ejercicio 3 — `intersection`: análisis del MDE y *Base Choice Coverage*

## Consigna

Sobre el método `SetUtils.intersection(Set<Integer> set1, Set<Integer> set2)` se parte de un MDE dado por la cátedra (características C1, C2 y C3). El ejercicio pide:

- **a, b)** Verificar si C1 y C2 satisfacen completitud y no solapamiento.
- **c, d)** Verificar si C3 satisface completitud y no solapamiento.
- **e)** Si alguna propiedad falla, revisar y corregir el MDE.
- **f)** Derivar los requisitos de test por *Base Choice Coverage* (BCC), implementar los casos y completar la rutina.

## a) Completitud de C1 (ídem C2)

**Sí**, satisface completitud.

Para un `Set<Integer> set1`, las posibilidades son:

- `set1 == null`,
- `set1 != null` y vacío,
- `set1 != null` y con al menos un elemento.

Esto coincide con los bloques de C1 (`b1`, `b2`, `b3`) y cubre todo el dominio.

## b) No solapamiento de C1 (ídem C2)

**Sí**, satisface no solapamiento. Ninguna entrada puede estar al mismo tiempo en dos bloques de C1:

- un set `null` no puede ser vacío o no vacío,
- un set vacío no puede ser no vacío.

## c) Completitud de C3

**No**, C3 no es completa.

Contraejemplo:

- `set1 = {1, 2}`
- `set2 = {2, 3}`

Hay intersección no vacía (`{2}`), pero:

- no son iguales,
- `set1` no es subconjunto de `set2`,
- `set2` no es subconjunto de `set1`,
- no son disjuntos.

Esa configuración no entra en ningún bloque de C3 original.

## d) No solapamiento de C3

**No**, C3 no satisface *disjointness*.

Contraejemplo:

- `set1 = {1, 2}`
- `set2 = {1, 2}`

Cae simultáneamente en:

- `b1`: representan el mismo conjunto,
- `b2`: `set1` es subconjunto de `set2`,
- `b3`: `set2` es subconjunto de `set1`.

Esto ocurre porque "subconjunto" no se definió como propio.

## e) MDE corregido

### C1 (validez de `set1`)

- C1.b1: `set1 == null`
- C1.b2: `set1 = {}`
- C1.b3: `set1` no vacío

### C2 (validez de `set2`)

- C2.b1: `set2 == null`
- C2.b2: `set2 = {}`
- C2.b3: `set2` no vacío

### C3 (relación entre `set1` y `set2`), solo si C1.b2/b3 y C2.b2/b3

- C3.b1: `set1 = set2`
- C3.b2: `set1` es subconjunto **propio** de `set2`
- C3.b3: `set2` es subconjunto **propio** de `set1`
- C3.b4: `set1` y `set2` disjuntos
- C3.b5: intersección no vacía y ninguno es subconjunto del otro (solapamiento parcial)

Con esta corrección, C3 queda completa y sin solapamiento.

## f) Requisitos *Base Choice Coverage*

### Bloques base elegidos

- C1 base: C1.b3 (`set1` no vacío)
- C2 base: C2.b3 (`set2` no vacío)
- C3 base: C3.b1 (sets iguales)

### Requisitos

| ID       | Configuración variada     | Resultado esperado                |
|----------|---------------------------|-----------------------------------|
| TR-BC1   | base (todos en su bloque) | intersección igual a `set1`       |
| TR-BC2   | C1 → C1.b1                | `NullPointerException`            |
| TR-BC3   | C1 → C1.b2 (ajustado)     | intersección vacía                |
| TR-BC4   | C2 → C2.b1                | `NullPointerException`            |
| TR-BC5   | C2 → C2.b2 (ajustado)     | intersección vacía                |
| TR-BC6   | C3 → C3.b2                | resultado `set1`                  |
| TR-BC7   | C3 → C3.b3                | resultado `set2`                  |
| TR-BC8   | C3 → C3.b4                | resultado vacío                   |
| TR-BC9   | C3 → C3.b5                | elementos comunes parciales       |

### Casos implementados en `IntersectionTest.java`

- TC1 → TR-BC1
- TC2 → TR-BC2
- TC3 → TR-BC3
- TC4 → TR-BC4
- TC5 → TR-BC5
- TC6 → TR-BC6
- TC7 → TR-BC7
- TC8 → TR-BC8
- TC9 → TR-BC9

Adicionalmente:

- Se verifica que los sets de entrada no se modifican.
- Se verifica que el resultado es una nueva instancia.
- Se agrega un borde extra con ambos sets vacíos.

### Implementación de `SetUtils.intersection`

La rutina:

- lanza `NullPointerException` si `set1` o `set2` son `null`,
- devuelve un nuevo `Set` con la intersección,
- no modifica los sets de entrada.

## Cómo ejecutar

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=IntersectionTest test
```

## Código

- [`SetUtils.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/SetUtils.java) — implementación de `intersection`.
- [`IntersectionTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IntersectionTest.java) — suite con los 9 casos BCC y los chequeos adicionales.

## Enlaces relacionados

- Enunciado del práctico: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución completa: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
- Resumen teórico: [`resumen_teorico_practico3.pdf`](/pdfs/tp3/resumen_teorico_practico3.pdf)
