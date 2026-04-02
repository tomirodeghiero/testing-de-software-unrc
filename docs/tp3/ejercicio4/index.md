---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp3/ejercicio4/"
description: "Contenido importado desde tp3/ejercicio4/README.md"
---

# Ejercicio 4 - Practico 3

## Archivos trabajados

- `../assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/PatternIndex.java`
- `../assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/PatternIndexTest.java`

## Modelo del Dominio de Entradas (MDE)

Metodo bajo prueba:

`PatternIndex.patternIndex(String subject, String pattern)`

Caracteristicas y bloques:

- C1 (`subject` referencia)
  - C1.b1: `subject == null`
  - C1.b2: `subject != null`
- C2 (`pattern` referencia)
  - C2.b1: `pattern == null`
  - C2.b2: `pattern != null`
- C3 (tamano de `subject`, solo si C1.b2)
  - C3.b1: `subject` vacio
  - C3.b2: `subject` no vacio
- C4 (tamano de `pattern`, solo si C2.b2)
  - C4.b1: `pattern` vacio
  - C4.b2: `pattern` de 1 caracter
  - C4.b3: `pattern` de 2 o mas caracteres
- C5 (resultado esperado, solo si C1.b2 y C2.b2)
  - C5.b1: indice `0` (inicio)
  - C5.b2: indice intermedio
  - C5.b3: indice final
  - C5.b4: `-1` (no encontrado)

Restricciones importantes:

- Si C1.b1 o C2.b1, la salida esperada es excepcion y C3/C4/C5 no aplican.
- Si C4.b1 (`pattern` vacio), el resultado esperado es `0`.
- Si C3.b1 (`subject` vacio) y C4.b2/C4.b3 (`pattern` no vacio), el resultado esperado es `-1`.

## Requisitos de test (PWC)

Se derivaron requisitos para cubrir pares relevantes entre caracteristicas:

- R01: (C1.b1, C2.b1)
- R02: (C1.b1, C2.b2)
- R03: (C1.b2, C2.b1)
- R04: (C1.b2, C2.b2)
- R05: (C3.b1, C4.b1)
- R06: (C3.b2, C4.b1)
- R07: (C3.b1, C4.b2)
- R08: (C3.b2, C4.b2)
- R09: (C3.b2, C4.b3)
- R10: (C3.b1, C4.b3)
- R11: (C4.b1, C5.b1)
- R12: (C3.b2, C5.b1) con C4.b1
- R13: (C4.b2, C5.b1)
- R14: (C4.b2, C5.b2)
- R15: (C4.b2, C5.b4)
- R16: (C4.b2, C5.b3)
- R17: (C4.b3, C5.b1)
- R18: (C4.b3, C5.b2)
- R19: (C4.b3, C5.b3)
- R20: (C4.b3, C5.b4)

## Casos de test implementados

- TC1: `subject=null`, `pattern=null` -> `IllegalArgumentException` (R01)
- TC2: `subject=null`, `pattern="a"` -> `IllegalArgumentException` (R02)
- TC3: `subject="abc"`, `pattern=null` -> `IllegalArgumentException` (R03)
- TC4: `subject=""`, `pattern=""` -> `0` (R04, R05, R11)
- TC5: `subject="abc"`, `pattern=""` -> `0` (R04, R06, R12)
- TC6: `subject=""`, `pattern="a"` -> `-1` (R04, R07, R15)
- TC7: `subject="abc"`, `pattern="a"` -> `0` (R04, R08, R13)
- TC8: `subject="abc"`, `pattern="b"` -> `1` (R04, R08, R14)
- TC9: `subject="abc"`, `pattern="c"` -> `2` (R04, R08, R16)
- TC10: `subject="abcde"`, `pattern="ab"` -> `0` (R04, R09, R17)
- TC11: `subject="abcde"`, `pattern="cd"` -> `2` (R04, R09, R18)
- TC12: `subject="abcde"`, `pattern="de"` -> `3` (R04, R09, R19)
- TC13: `subject="abcde"`, `pattern="fg"` -> `-1` (R04, R09, R20)
- TC14: `subject="abc"`, `pattern="z"` -> `-1` (R04, R08, R15)
- TC15: `subject=""`, `pattern="ab"` -> `-1` (R04, R10, R20)

## Fallas encontradas en la implementacion original

Si, los tests descubrieron fallas:

1. No se cumplia la especificacion de excepciones en null:
   - la version original hacia `subject.length()`/`pattern.length()` sin validar null,
   - eso terminaba en `NullPointerException` en vez de `IllegalArgumentException`.

2. Caso `pattern` vacio:
   - la version original intentaba `pattern.charAt(0)`,
   - eso disparaba `StringIndexOutOfBoundsException`.

## Correccion aplicada en `PatternIndex`

Se actualizo la rutina para:

- validar `subject` y `pattern` contra null y lanzar `IllegalArgumentException`
- devolver `0` cuando `pattern` es vacio
- devolver `-1` cuando `pattern` es mas largo que `subject`
- buscar la primera ocurrencia en forma deterministica y devolver su indice

## Ejecucion

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 test
```
