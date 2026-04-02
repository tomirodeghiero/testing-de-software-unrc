---
title: "Ejercicio 3"
sidebar_position: 3
slug: "/tp3/ejercicio3/"
description: "Contenido importado desde tp3/ejercicio3/README.md"
---

# Ejercicio 3 - Practico 3

## Archivos trabajados

- `../assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/SetUtils.java`
- `../assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IntersectionTest.java`

## a) Completitud de C1 (idem C2)

Si, satisface completitud.

Para un `Set<Integer> set1`, las posibilidades son:

- `set1 == null`
- `set1 != null` y vacio
- `set1 != null` y con al menos un elemento

Eso coincide con los bloques de C1 (`b1`, `b2`, `b3`) y cubre todo el dominio.

## b) No solapamiento de C1 (idem C2)

Si, satisface no solapamiento.

No existe entrada que pueda estar al mismo tiempo en dos bloques de C1:

- un set `null` no puede ser vacio/no vacio
- un set vacio no puede ser no vacio

## c) Completitud de C3

No, C3 no es completo.

Contraejemplo:

- `set1 = {1,2}`
- `set2 = {2,3}`

Aqui hay interseccion no vacia (`{2}`), pero:

- no son iguales
- `set1` no es subconjunto de `set2`
- `set2` no es subconjunto de `set1`
- no son disjuntos

No entra en ningun bloque de C3 original.

## d) Disjointness de C3

No, C3 no satisface disjointness.

Contraejemplo:

- `set1 = {1,2}`
- `set2 = {1,2}`

Cae simultaneamente en:

- `b1`: representan el mismo conjunto
- `b2`: `set1` es subconjunto de `set2`
- `b3`: `set2` es subconjunto de `set1`

(esto ocurre porque "subconjunto" no se definio como propio).

## e) Revision de caracteristicas (MDE corregido)

### C1 (Validez de set1)

- C1.b1: `set1 == null`
- C1.b2: `set1 = {}`
- C1.b3: `set1` no vacio

### C2 (Validez de set2)

- C2.b1: `set2 == null`
- C2.b2: `set2 = {}`
- C2.b3: `set2` no vacio

### C3 (Relacion entre set1 y set2), solo si C1.b2/b3 y C2.b2/b3

- C3.b1: `set1 = set2`
- C3.b2: `set1` es subconjunto propio de `set2`
- C3.b3: `set2` es subconjunto propio de `set1`
- C3.b4: `set1` y `set2` disjuntos
- C3.b5: interseccion no vacia y ninguno es subconjunto del otro (solapamiento parcial)

Con esta correccion, C3 queda completo y sin solapamiento.

## f) Requisitos BC + tests + implementacion

### Bloques base elegidos

- C1 base: C1.b3 (`set1` no vacio)
- C2 base: C2.b3 (`set2` no vacio)
- C3 base: C3.b1 (sets iguales)

### Requisitos de test para Base Choice (BC)

- TR-BC1: (C1.b3, C2.b3, C3.b1) -> caso base
- TR-BC2: variar C1 a C1.b1 -> `NullPointerException`
- TR-BC3: variar C1 a C1.b2 (ajustado por factibilidad) -> interseccion vacia
- TR-BC4: variar C2 a C2.b1 -> `NullPointerException`
- TR-BC5: variar C2 a C2.b2 (ajustado por factibilidad) -> interseccion vacia
- TR-BC6: variar C3 a C3.b2 -> resultado `set1`
- TR-BC7: variar C3 a C3.b3 -> resultado `set2`
- TR-BC8: variar C3 a C3.b4 -> resultado vacio
- TR-BC9: variar C3 a C3.b5 -> resultado con elementos comunes parciales

### Casos implementados en `IntersectionTest.java`

- TC1 -> TR-BC1
- TC2 -> TR-BC2
- TC3 -> TR-BC3
- TC4 -> TR-BC4
- TC5 -> TR-BC5
- TC6 -> TR-BC6
- TC7 -> TR-BC7
- TC8 -> TR-BC8
- TC9 -> TR-BC9

Adicionalmente:

- Se verifica que los sets de entrada no se modifican.
- Se verifica que el resultado es una nueva instancia.
- Se agrega un borde adicional: ambos sets vacios.

### Implementacion en `SetUtils.intersection`

Se implemento la rutina para:

- lanzar `NullPointerException` si `set1` o `set2` son `null`
- devolver un nuevo `Set` con la interseccion
- no modificar `set1` ni `set2`

## Ejecucion

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 test
```
