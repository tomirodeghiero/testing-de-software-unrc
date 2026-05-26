---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp3/ejercicio4/"
description: "Contenido importado desde tp3/ejercicio4/README.md"
---

# Ejercicio 4 — `PatternIndex` con *Pair-Wise* y detección de fallas

## Consigna

Sobre `PatternIndex.patternIndex(String subject, String pattern)` se pide:

- Construir un MDE adecuado.
- Derivar requisitos de test usando *Pair-Wise Coverage* (PWC).
- Implementar los casos en JUnit 5.
- Reportar las fallas que aparezcan en la implementación provista y aplicar las correcciones necesarias.

## Modelo del Dominio de Entradas

Método bajo prueba: `PatternIndex.patternIndex(String subject, String pattern)`.

Características y bloques:

- **C1** (`subject` referencia):
  - C1.b1: `subject == null`
  - C1.b2: `subject != null`
- **C2** (`pattern` referencia):
  - C2.b1: `pattern == null`
  - C2.b2: `pattern != null`
- **C3** (tamaño de `subject`, solo si C1.b2):
  - C3.b1: `subject` vacío
  - C3.b2: `subject` no vacío
- **C4** (tamaño de `pattern`, solo si C2.b2):
  - C4.b1: `pattern` vacío
  - C4.b2: `pattern` de 1 carácter
  - C4.b3: `pattern` de 2 o más caracteres
- **C5** (resultado esperado, solo si C1.b2 y C2.b2):
  - C5.b1: índice `0` (inicio)
  - C5.b2: índice intermedio
  - C5.b3: índice final
  - C5.b4: `-1` (no encontrado)

Restricciones importantes:

- Si C1.b1 o C2.b1, la salida esperada es excepción y C3/C4/C5 no aplican.
- Si C4.b1 (`pattern` vacío), el resultado esperado es `0`.
- Si C3.b1 (`subject` vacío) y C4.b2/C4.b3 (`pattern` no vacío), el resultado esperado es `-1`.

## Requisitos de test (PWC)

Pares relevantes entre características:

| ID  | Par              | ID  | Par              |
|-----|------------------|-----|------------------|
| R01 | (C1.b1, C2.b1)   | R11 | (C4.b1, C5.b1)   |
| R02 | (C1.b1, C2.b2)   | R12 | (C3.b2, C5.b1) c/ C4.b1 |
| R03 | (C1.b2, C2.b1)   | R13 | (C4.b2, C5.b1)   |
| R04 | (C1.b2, C2.b2)   | R14 | (C4.b2, C5.b2)   |
| R05 | (C3.b1, C4.b1)   | R15 | (C4.b2, C5.b4)   |
| R06 | (C3.b2, C4.b1)   | R16 | (C4.b2, C5.b3)   |
| R07 | (C3.b1, C4.b2)   | R17 | (C4.b3, C5.b1)   |
| R08 | (C3.b2, C4.b2)   | R18 | (C4.b3, C5.b2)   |
| R09 | (C3.b2, C4.b3)   | R19 | (C4.b3, C5.b3)   |
| R10 | (C3.b1, C4.b3)   | R20 | (C4.b3, C5.b4)   |

## Casos de test implementados

- **TC1**: `subject = null`, `pattern = null` → `IllegalArgumentException` (R01).
- **TC2**: `subject = null`, `pattern = "a"` → `IllegalArgumentException` (R02).
- **TC3**: `subject = "abc"`, `pattern = null` → `IllegalArgumentException` (R03).
- **TC4**: `subject = ""`, `pattern = ""` → `0` (R04, R05, R11).
- **TC5**: `subject = "abc"`, `pattern = ""` → `0` (R04, R06, R12).
- **TC6**: `subject = ""`, `pattern = "a"` → `-1` (R04, R07, R15).
- **TC7**: `subject = "abc"`, `pattern = "a"` → `0` (R04, R08, R13).
- **TC8**: `subject = "abc"`, `pattern = "b"` → `1` (R04, R08, R14).
- **TC9**: `subject = "abc"`, `pattern = "c"` → `2` (R04, R08, R16).
- **TC10**: `subject = "abcde"`, `pattern = "ab"` → `0` (R04, R09, R17).
- **TC11**: `subject = "abcde"`, `pattern = "cd"` → `2` (R04, R09, R18).
- **TC12**: `subject = "abcde"`, `pattern = "de"` → `3` (R04, R09, R19).
- **TC13**: `subject = "abcde"`, `pattern = "fg"` → `-1` (R04, R09, R20).
- **TC14**: `subject = "abc"`, `pattern = "z"` → `-1` (R04, R08, R15).
- **TC15**: `subject = ""`, `pattern = "ab"` → `-1` (R04, R10, R20).

## Fallas detectadas

Los tests descubrieron dos defectos en la implementación original:

1. **No respetaba la especificación de excepciones para `null`.** La versión original hacía `subject.length()` / `pattern.length()` sin validar y terminaba en `NullPointerException` en lugar de `IllegalArgumentException`.
2. **Caso `pattern` vacío.** La versión original intentaba `pattern.charAt(0)` y disparaba `StringIndexOutOfBoundsException`.

## Corrección aplicada

La rutina actualizada:

- valida `subject` y `pattern` contra `null` y lanza `IllegalArgumentException`,
- devuelve `0` cuando `pattern` es vacío,
- devuelve `-1` cuando `pattern` es más largo que `subject`,
- busca la primera ocurrencia de forma determinística y devuelve su índice.

## Cómo ejecutar

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexTest test
```

## Código

- [`PatternIndex.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/PatternIndex.java) — implementación corregida.
- [`PatternIndexTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/PatternIndexTest.java) — suite con los 15 casos PWC.

## Enlaces relacionados

- Enunciado del práctico: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución completa: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
- Resumen teórico: [`resumen_teorico_practico3.pdf`](/pdfs/tp3/resumen_teorico_practico3.pdf)
