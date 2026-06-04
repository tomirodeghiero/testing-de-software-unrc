# Ejercicio 2 — `ThreesController`: tests de módulo / integración

Tests de **módulo / integración** sobre [`ThreesController`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesController.java), basándome como unidad principal en las acciones de movimiento del juego *Threes*.

## Modelo

Acciones bajo prueba:

- `moveUp()`
- `moveDown()`
- `moveLeft()`
- `moveRight()`

Estados considerados para cada acción:

| Estado | Descripción |
|---|---|
| M0 | tablero no modificable en esa dirección |
| M1 | tablero modificable solo por desplazamiento |
| M2 | tablero modificable con combinación `1 + 2` / `2 + 1` |
| M3 | tablero modificable con combinación `x + x` para `x ≥ 3` |
| M4 | carga de nueva baldosa en borde opuesto con fila/columna pseudoaleatoria |

Para que los asserts de integración sean reproducibles se usó un `RandomGenerator` determinista en tests.

## Criterio de cobertura

Alta cobertura de **predicados** de las acciones de movimiento (decisiones internas de desplazamiento/modificación, combinación y carga de la siguiente baldosa), medida con JaCoCo.

Bases:

- `@BeforeEach` para estado base limpio.
- Tests parametrizados para cubrir compactamente el caso "sin cambios" en las 4 direcciones.
- Un test con **dos movimientos distintos secuenciales** para cumplir explícitamente el requisito de módulo.

## Requisitos de test

Suite: [`ThreesControllerModuleIntegrationTest`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesControllerModuleIntegrationTest.java).

| ID | Requisito | Test |
|---|---|---|
| R2.1 | Constructor por defecto genera tablero inicial válido | `defaultConstructorCreatesExpectedInitialState` |
| R2.2 | Movimiento sin cambios retorna `false` y no muta estado | `noChangeMoveKeepsBoardAndNextTile` (parametrizado, 4 direcciones) |
| R2.3 | `moveLeft` desplaza/combina y carga baldosa en borde derecho | `moveLeftCombinesShiftsAndLoadsNextTileOnRightEdge` |
| R2.4 | `moveRight` cubre combinación `2 + 1` y carga en borde izquierdo | `moveRightCombinesTwoPlusOneAndLoadsNextTileOnLeftEdge` |
| R2.5 | `moveUp` combina y carga en fila inferior | `moveUpCombinesAndLoadsNextTileOnBottomRow` |
| R2.6 | `moveDown` combina y carga en fila superior | `moveDownCombinesAndLoadsNextTileOnTopRow` |
| R2.7 | Comportamiento consistente en secuencia de movimientos distintos | `sequentialDifferentMovesBehaveConsistently` |

### Requisitos inviables

- **RI2.1.** Comprobar distribución estadística del azar real en tests de módulo. *Motivo:* no determinista y fuera del alcance de pruebas de integración reproducibles.
- **RI2.2.** Cobertura exhaustiva de todas las secuencias posibles de estados del juego. *Motivo:* explosión combinatoria; se aplica particionado representativo del dominio.

## Resultados

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -q test
```

Resultado global: **38 tests, 0 fallas**.

Cobertura JaCoCo sobre `ThreesController`:

| Métrica | Cubiertas | Totales | % |
|---|---|---|---|
| Instrucciones | 596 | 596 | **100.00 %** |
| Branches | 71 | 78 | **91.03 %** |
| Líneas | 124 | 124 | **100.00 %** |
| Métodos | 19 | 19 | **100.00 %** |

## Archivos

- [`ThreesController.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesController.java)
- [`RandomGenerator.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/RandomGenerator.java) — generador inyectable para reproducibilidad.
- [`ThreesControllerModuleIntegrationTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesControllerModuleIntegrationTest.java)

## Enlaces

- Enunciado: [`practico9.pdf`](/pdfs/tp9/practico9.pdf)
- Resolución: [`resolucion_practico9.pdf`](/pdfs/tp9/resolucion_practico9.pdf)
