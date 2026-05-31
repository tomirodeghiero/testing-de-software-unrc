# Ejercicio 4 — `PatternIndex` con *Pair-Wise* y fallas detectadas

## Consigna

Para `PatternIndex.patternIndex(String subject, String pattern)`:

- construir un MDE;
- derivar requisitos por *Pair-Wise Coverage* (PWC);
- implementar los casos en JUnit 5;
- reportar las fallas que aparezcan en la implementación provista y aplicar las correcciones.

## MDE

Características y bloques:

- **C1** (`subject` referencia): C1.b1 = `null`, C1.b2 = no `null`.
- **C2** (`pattern` referencia): C2.b1 = `null`, C2.b2 = no `null`.
- **C3** (tamaño de `subject`, solo si C1.b2): C3.b1 = vacío, C3.b2 = no vacío.
- **C4** (tamaño de `pattern`, solo si C2.b2): C4.b1 = vacío, C4.b2 = 1 carácter, C4.b3 = 2 o más.
- **C5** (resultado esperado, solo si C1.b2 y C2.b2): C5.b1 = índice 0, C5.b2 = intermedio, C5.b3 = final, C5.b4 = `-1`.

Restricciones:

- Si C1.b1 o C2.b1, el resultado esperado es excepción y C3/C4/C5 no aplican.
- Si C4.b1 (pattern vacío), el resultado es `0`.
- Si C3.b1 (subject vacío) con C4.b2/b3 (pattern no vacío), el resultado es `-1`.

## Requisitos PWC

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

## Casos implementados

15 casos, cada uno con su `subject` y `pattern`:

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

## Fallas que aparecieron

Los tests descubrieron dos defectos en la implementación original:

1. **No validaba `null`.** Hacía `subject.length()` / `pattern.length()` sin chequear, así que TC1–TC3 lanzaban `NullPointerException` en lugar del `IllegalArgumentException` que documenta el Javadoc.
2. **Pattern vacío.** Con `pattern = ""`, la condición `iSub + patternLen - 1 < subjectLen` queda como `iSub - 1 < subjectLen` (verdadero al menos para `iSub = 0`), y adentro se ejecuta `pattern.charAt(0)`, que dispara `StringIndexOutOfBoundsException` en vez de devolver `0`.

## Corrección

Agregué las dos guardas al principio del método:

```java
if (subject == null || pattern == null) {
    throw new IllegalArgumentException("subject and pattern must be non-null");
}
// ...
if (patternLen == 0) {
    return 0;
}
```

El resto del algoritmo de búsqueda es correcto, así que con las dos guardas alcanza para que los 15 casos pasen.

## Cómo correr

```bash
cd tp3/assignmnet-3-rodeghiero
mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexTest test
```

## Archivos

- [`PatternIndex.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/PatternIndex.java) — versión corregida.
- [`PatternIndexTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/PatternIndexTest.java) — los 15 casos PWC.

## Enlaces

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
