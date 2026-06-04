# Ejercicio 1 — `ThreesBoard` con caracterización del dominio de inputs

Aplicar **Input Domain Characterization** sobre [`ThreesBoard`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesBoard.java), enfocando los métodos principales del modelo del juego *Threes*. Sobre cada característica relevante se definen particiones, se eligen casos representativos y se reportan los defectos detectados durante el proceso.

## Modelo

Características identificadas sobre la API pública de `ThreesBoard`:

| ID | Característica | Particiones |
|---|---|---|
| C1 | Coordenadas en `setTile / getTile` | válidas `[0..3]` vs inválidas (`<0` o `≥4`) |
| C2 | Cantidad inicial en `ThreesBoard(totalTiles)` | válida `[0..16]` vs inválida (`<0` o `>16`) |
| C3 | Ocupación en `numberOfSetTiles()` | vacío, parcial, completo |
| C4 | Tipo de pareja en `canTilesCombine(t1, t2)` | `1+2`, `2+1`, `x+x` con `x ≥ 3`, no combinables, `null` |
| C5 | Movilidad en `canMoveLeft/Right/Up/Down` e `isFinished()` | sin movimientos, por huecos, por combinación, lleno bloqueado |
| C6 | Categoría de valor en `computeScore()` | `0/1/2`, `3`, `>3` |

## Criterio de cobertura

Se cubrieron todas las particiones definidas en C1..C6 con casos representativos. Apoyos puntuales:

- Tests parametrizados para coordenadas inválidas y combinaciones de tiles.
- `@BeforeEach` para inicializar estado limpio en cada test.
- Nombres de suite y tests alineados con el criterio seleccionado.

## Requisitos de test

Suite: [`ThreesBoardInputDomainCharacterizationTest`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesBoardInputDomainCharacterizationTest.java).

| ID | Requisito | Test |
|---|---|---|
| R1 | `setTile / getTile` con coordenadas válidas | `setAndGetTileWithinBounds` |
| R2 | `setTile` rechaza coordenadas inválidas | `setTileRejectsOutOfRangeCoordinates` (parametrizado) |
| R3 | `getTile` rechaza coordenadas inválidas | `getTileRejectsOutOfRangeCoordinates` (parametrizado) |
| R4 | Constructor aleatorio inicializa exactamente `totalTiles` celdas con valores permitidos | `constructorWithTotalTilesSetsExactAmount` |
| R5 | Constructor aleatorio rechaza `totalTiles` inválido | `constructorRejectsInvalidTotalTiles` (parametrizado) |
| R6 | Conteo de tiles seteados | `numberOfSetTilesCountsNonFreeTiles` |
| R7 | Reglas de combinación (válidas e inválidas) | `canTilesCombineMatchesRules` (parametrizado) + `canTilesCombineRejectsNullTiles` |
| R8 | Tablero vacío no se mueve y finaliza | `emptyBoardHasNoMovesAndIsFinished` |
| R9 | Detección de movimiento por huecos | `movementByGapsIsDetectedPerDirection` |
| R10 | Detección de movimiento por combinación | `movementByCombinationIsDetectedPerDirection` |
| R11 | Tablero lleno bloqueado | `fullBoardWithoutCombinationsIsFinished` |
| R12 | Cálculo de puntaje | `computeScoreFollowsImplementedRules` |

### Requisitos inviables

- **RI1.** Validar posiciones exactas de las fichas del constructor aleatorio sin inyectar/mockear `RandomGenerator`. *Motivo:* comportamiento no determinista.
- **RI2.** Cobertura exhaustiva de todos los estados del tablero. *Motivo:* explosión combinatoria; se aplica particionado por dominio.
- **RI3.** Verificar uniformidad estadística del generador aleatorio. *Motivo:* corresponde a análisis estadístico, no a un test unitario determinista.

## Reporte de fallas

Defectos detectados y corregidos durante la suite:

- `ThreesBoard.getTile`: validación incorrecta de columna (`col <= COLUMNS`), permitía índice fuera de rango.
- `ThreesBoard(int totalTiles)`: no validaba rango de `totalTiles` y podía quedar en loop infinito para valores `>16`.
- `ThreesBoard(int totalTiles)`: el valor aleatorio inicial usaba `0..2` (incluyendo `0`) cuando debía setear `1..3`.
- `ThreesBoard`: implementación faltante de `isFinished`, `canMoveLeft/Right/Up/Down`, `canTilesCombine`, `computeScore`.
- `ThreesTile`: implementación faltante de `isValidValue`.
- `ThreesTile.setRandomValue`: `% 3` sobre `nextInt()` podía generar valores inválidos; se reemplazó por `nextInt(3) + 1`.
- `ThreesController`: implementación faltante de `moveUp`, `moveLeft`, `moveRight`.
- `ThreesController.moveDown`: la lógica previa podía duplicar valores al desplazar; se reemplazó por colapso + combinación consistente.
- `pom.xml`: `jacoco-maven-plugin 0.8.2` era incompatible con el JDK del entorno; se actualizó a `0.8.12`.

## Resultados

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 \
    -Dtest=ThreesBoardInputDomainCharacterizationTest test
```

Resultado: **28 / 28 tests OK**.

Cobertura JaCoCo sobre `ThreesBoard`:

| Métrica | Cubiertas | Totales | % |
|---|---|---|---|
| Líneas | 85 | 97 | **87.63 %** |
| Branches | 108 | 124 | **87.10 %** |
| Métodos | 12 | 13 | **92.31 %** |

## Archivos

- [`ThreesBoard.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesBoard.java)
- [`ThreesTile.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesTile.java)
- [`ThreesBoardInputDomainCharacterizationTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesBoardInputDomainCharacterizationTest.java)

## Enlaces

- Enunciado: [`practico9.pdf`](/pdfs/tp9/practico9.pdf)
- Resolución: [`resolucion_practico9.pdf`](/pdfs/tp9/resolucion_practico9.pdf)
