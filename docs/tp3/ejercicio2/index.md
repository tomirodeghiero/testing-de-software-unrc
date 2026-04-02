---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp3/ejercicio2/"
description: "Contenido importado desde tp3/ejercicio2/README.md"
---

# Ejercicio 2 - Practico 3

## Archivos trabajados

- `../assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/ListUtils.java`
- `../assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/numberOfOcurrencesTest.java`

## Modelo del Dominio de Entradas (MDE)

Metodo bajo prueba:

`numberOfOcurrences(List<Integer> l, Integer element)`

Caracteristicas y bloques:

- C1 (`l` referencia):
  - L0: `l == null`
  - L1: `l != null`
- C2 (`element` referencia):
  - E0: `element == null`
  - E1: `element != null`
- C3 (tamano de lista, solo si L1):
  - S0: lista vacia
  - S1: lista no vacia
- C4 (cantidad de ocurrencias, solo si L1 y E1):
  - O0: 0 ocurrencias
  - O1: 1 ocurrencia
  - O2: mas de 1 ocurrencia

Restricciones:

- Si L0, C3 y C4 no aplican.
- Si E0, C4 no aplica.
- Si S0, entonces necesariamente O0.

## Requisitos de test para Pairwise Coverage (PWC)

Se listan los pares factibles entre caracteristicas:

- R01: (L0, E0)
- R02: (L0, E1)
- R03: (L1, E0)
- R04: (L1, E1)
- R05: (L1, S0)
- R06: (L1, S1)
- R07: (L1, O0)
- R08: (L1, O1)
- R09: (L1, O2)
- R10: (E0, S0)
- R11: (E0, S1)
- R12: (E1, S0)
- R13: (E1, S1)
- R14: (E1, O0)
- R15: (E1, O1)
- R16: (E1, O2)
- R17: (S0, O0)
- R18: (S1, O0)
- R19: (S1, O1)
- R20: (S1, O2)

## Casos de test implementados

- TC1: `l = null`, `element = null` -> `IllegalArgumentException` (R01)
- TC2: `l = null`, `element = 7` -> `IllegalArgumentException` (R02)
- TC3: `l = []`, `element = null` -> `IllegalArgumentException` (R03, R05, R10)
- TC4: `l = [1,2,3]`, `element = null` -> `IllegalArgumentException` (R03, R06, R11)
- TC5: `l = []`, `element = 5` -> `0` (R04, R05, R07, R12, R14, R17)
- TC6: `l = [1,2,3]`, `element = 9` -> `0` (R04, R06, R07, R13, R14, R18)
- TC7: `l = [1,2,3]`, `element = 2` -> `1` (R04, R06, R08, R13, R15, R19)
- TC8: `l = [4,1,4,4]`, `element = 4` -> `3` (R04, R06, R09, R13, R16, R20)

Adicionalmente, se agrego un test de robustez para verificar que la rutina no modifica la lista de entrada.

## Implementacion de la rutina

La implementacion de `numberOfOcurrences`:

- lanza `IllegalArgumentException` si `l == null` o `element == null`
- recorre la lista y cuenta coincidencias con `element.equals(actual)`
- retorna la cantidad total de ocurrencias

## Ejecucion

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 test
```
