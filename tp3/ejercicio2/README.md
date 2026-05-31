# Ejercicio 2 — `numberOfOcurrences` con *Pair-Wise*

## Consigna

Construir un Modelo del Dominio de Entradas (MDE) para `ListUtils.numberOfOcurrences(List<Integer> l, Integer element)`, derivar los requisitos de test con *Pair-Wise Coverage* (PWC) e implementarlos en JUnit 5.

## Modelo del Dominio de Entradas

Características y bloques:

- **C1** (`l` referencia): L0 = `null`, L1 = no `null`.
- **C2** (`element` referencia): E0 = `null`, E1 = no `null`.
- **C3** (tamaño de `l`, solo si L1): S0 = vacía, S1 = no vacía.
- **C4** (cantidad de ocurrencias, solo si L1 y E1): O0 = 0, O1 = 1, O2 = más de una.

Restricciones:

- Si L0, C3 y C4 no aplican.
- Si E0, C4 no aplica.
- Si S0, necesariamente O0.

## Requisitos PWC

Los pares factibles entre características son:

| ID  | Par              | ID  | Par              |
|-----|------------------|-----|------------------|
| R01 | (L0, E0)         | R11 | (E0, S1)         |
| R02 | (L0, E1)         | R12 | (E1, S0)         |
| R03 | (L1, E0)         | R13 | (E1, S1)         |
| R04 | (L1, E1)         | R14 | (E1, O0)         |
| R05 | (L1, S0)         | R15 | (E1, O1)         |
| R06 | (L1, S1)         | R16 | (E1, O2)         |
| R07 | (L1, O0)         | R17 | (S0, O0)         |
| R08 | (L1, O1)         | R18 | (S1, O0)         |
| R09 | (L1, O2)         | R19 | (S1, O1)         |
| R10 | (E0, S0)         | R20 | (S1, O2)         |

## Casos implementados

- **TC1**: `l = null`, `element = null` → `IllegalArgumentException` (R01).
- **TC2**: `l = null`, `element = 7` → `IllegalArgumentException` (R02).
- **TC3**: `l = []`, `element = null` → `IllegalArgumentException` (R03, R05, R10).
- **TC4**: `l = [1,2,3]`, `element = null` → `IllegalArgumentException` (R03, R06, R11).
- **TC5**: `l = []`, `element = 5` → `0` (R04, R05, R07, R12, R14, R17).
- **TC6**: `l = [1,2,3]`, `element = 9` → `0` (R04, R06, R07, R13, R14, R18).
- **TC7**: `l = [1,2,3]`, `element = 2` → `1` (R04, R06, R08, R13, R15, R19).
- **TC8**: `l = [4,1,4,4]`, `element = 4` → `3` (R04, R06, R09, R13, R16, R20).

También un test de robustez extra: que la rutina no modifique la lista de entrada.

## La rutina

`numberOfOcurrences` valida que ni `l` ni `element` sean `null` (lanza `IllegalArgumentException` si lo son), recorre la lista y cuenta coincidencias usando `element.equals(actual)` para que `Integer` se compare por valor.

## Cómo correr

```bash
cd tp3/assignmnet-3-rodeghiero
mvn -Dmaven.repo.local=.m2 -Dtest=numberOfOcurrencesTest test
```

## Archivos

- [`ListUtils.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/ListUtils.java) — implementación de `numberOfOcurrences`.
- [`numberOfOcurrencesTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/numberOfOcurrencesTest.java) — los 8 casos PWC más el test de robustez.

## Enlaces

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
