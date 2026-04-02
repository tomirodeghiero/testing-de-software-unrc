# Trabajo Práctico Final- Documentación


## Ejercicio 1

### Modelo

Se utilizo **Caracterizacion del Dominio de Inputs** sobre `ThreesBoard`, enfocando los metodos principales:

- `setTile(row,col,v)` y `getTile(row,col)`:
Caracteristica C1 (coordenadas): validas `[0..3]` vs invalidas `(<0 o >=4)`.

- `ThreesBoard(totalTiles)`:
Caracteristica C2 (cantidad inicial): valida `[0..16]` vs invalida `(<0 o >16)`.

- `numberOfSetTiles()`:
Caracteristica C3 (ocupacion): tablero vacio, parcial y completo.

- `canTilesCombine(t1,t2)`:
Caracteristica C4 (tipo de pareja): `1+2`, `2+1`, `x+x` con `x>=3`, no combinables y `null`.

- `canMoveLeft/Right/Up/Down` e `isFinished()`:
Caracteristica C5 (movilidad): sin movimientos, por huecos, por combinacion, tablero lleno bloqueado.

- `computeScore()`:
Caracteristica C6 (categoria de valor): `0/1/2`, `3`, `>3`.

### Criterio de Cobertura

Se cubrieron todas las particiones definidas en C1..C6 con casos representativos.

Adicionalmente:
- Se usaron tests parametrizados para coordenadas invalidas y combinaciones de tiles.
- Se uso `@BeforeEach` para inicializar estado limpio en cada test.
- Se mantuvieron nombres de suite y tests alineados con el criterio seleccionado.

### Requisitos de Test

Suite: `ThreesBoardInputDomainCharacterizationTest`

- R1: `setTile/getTile` con coordenadas validas.
Cubre: `setAndGetTileWithinBounds`.

- R2: `setTile` rechaza coordenadas invalidas.
Cubre: `setTileRejectsOutOfRangeCoordinates` (parametrizado).

- R3: `getTile` rechaza coordenadas invalidas.
Cubre: `getTileRejectsOutOfRangeCoordinates` (parametrizado).

- R4: constructor aleatorio inicializa exactamente `totalTiles` celdas y con valores permitidos.
Cubre: `constructorWithTotalTilesSetsExactAmount`.

- R5: constructor aleatorio rechaza `totalTiles` invalido.
Cubre: `constructorRejectsInvalidTotalTiles` (parametrizado).

- R6: conteo de tiles seteados.
Cubre: `numberOfSetTilesCountsNonFreeTiles`.

- R7: reglas de combinacion (validas e invalidas).
Cubre: `canTilesCombineMatchesRules` (parametrizado) y `canTilesCombineRejectsNullTiles`.

- R8: tablero vacio no se mueve y finaliza.
Cubre: `emptyBoardHasNoMovesAndIsFinished`.

- R9: deteccion de movimiento por huecos.
Cubre: `movementByGapsIsDetectedPerDirection`.

- R10: deteccion de movimiento por combinacion.
Cubre: `movementByCombinationIsDetectedPerDirection`.

- R11: tablero lleno bloqueado.
Cubre: `fullBoardWithoutCombinationsIsFinished`.

- R12: calculo de puntaje.
Cubre: `computeScoreFollowsImplementedRules`.

#### Requisitos inviables

- RI1: Validar posiciones exactas de las fichas del constructor aleatorio sin inyectar/mokear `RandomGenerator`.
Motivo: comportamiento no determinista.

- RI2: Cobertura exhaustiva de todos los estados del tablero (espacio de estados enorme).
Motivo: combinatoria inabordable; se aplica particionado por dominio de inputs.

- RI3: Verificar uniformidad estadistica del generador aleatorio como requisito de test unitario.
Motivo: corresponde a analisis estadistico, no a tests unitarios deterministas.

### Reporte de fallas

Errores detectados y corregidos:

- `ThreesBoard.getTile`: validacion incorrecta de columna (`col <= COLUMNS`), permitia indice fuera de rango.
- `ThreesBoard(int totalTiles)`: no validaba rango de `totalTiles` y podia quedar en loop infinito para valores >16.
- `ThreesBoard(int totalTiles)`: inicializacion de valor aleatorio usaba `0..2` (incluia 0), cuando debia setear `1..3`.
- `ThreesBoard`: implementacion faltante de `isFinished`, `canMoveLeft/Right/Up/Down`, `canTilesCombine`, `computeScore`.
- `ThreesTile`: implementacion faltante de `isValidValue`.
- `ThreesTile.setRandomValue`: uso de `% 3` sobre `nextInt()` podia generar valores invalidos; se reemplazo por `nextInt(3)+1`.
- `ThreesController`: implementacion faltante de `moveUp`, `moveLeft`, `moveRight`.
- `ThreesController.moveDown`: logica previa podia duplicar valores al desplazar; se reemplazo por una implementacion consistente de colapso + combinacion.
- `pom.xml`: `jacoco-maven-plugin 0.8.2` era incompatible con el JDK del entorno; se actualizo a `0.8.12`.

Resultado de ejecucion (`JAVA_HOME` Java 17, `mvn test`):
- Tests: 28/28 OK.

Cobertura JaCoCo relevante para `ThreesBoard`:
- Lineas: 85 cubiertas / 97 totales = **87.63%**
- Branches: 108 cubiertas / 124 totales = **87.10%**
- Metodos: 12 cubiertos / 13 totales = **92.31%**



***
## Ejercicio 2

### Modelo

Se construyo una suite de **tests de modulo/integracion** para `ThreesController`, tomando como unidad principal las acciones:

- `moveUp()`
- `moveDown()`
- `moveLeft()`
- `moveRight()`

El modelo de estados considerado para cada accion fue:

- M0: tablero no modificable en esa direccion.
- M1: tablero modificable solo por desplazamiento.
- M2: tablero modificable con combinacion `1+2` / `2+1`.
- M3: tablero modificable con combinacion `x+x` para `x>=3`.
- M4: carga de nueva baldosa en borde opuesto con fila/columna elegida pseudoaleatoriamente.

Para hacer reproducibles los asserts de integracion se uso un `RandomGenerator` determinista en tests.

### Criterio de Cobertura

Se busco alta cobertura de predicados de las acciones de movimiento (decisiones internas de movimiento/modificacion, combinacion y carga de siguiente baldosa), evaluada con JaCoCo.

Se uso:

- `@BeforeEach` para estado base limpio.
- tests parametrizados para cubrir de forma compacta el caso "sin cambios" en las 4 acciones.
- un test con **dos movimientos distintos secuenciales** para cumplir explicitamente el requisito de modulo.

### Requisitos de Test

Suite: `ThreesControllerModuleIntegrationTest`

- R2.1: constructor por defecto genera tablero inicial valido.
Cubre: `defaultConstructorCreatesExpectedInitialState`.

- R2.2: si el movimiento no modifica tablero, retorna `false` y no cambia estado.
Cubre: `noChangeMoveKeepsBoardAndNextTile` (parametrizado para 4 direcciones).

- R2.3: `moveLeft` desplaza/combina y carga baldosa en borde derecho.
Cubre: `moveLeftCombinesShiftsAndLoadsNextTileOnRightEdge`.

- R2.4: `moveRight` cubre combinacion `2+1` y carga en borde izquierdo.
Cubre: `moveRightCombinesTwoPlusOneAndLoadsNextTileOnLeftEdge`.

- R2.5: `moveUp` combina y carga en fila inferior.
Cubre: `moveUpCombinesAndLoadsNextTileOnBottomRow`.

- R2.6: `moveDown` combina y carga en fila superior.
Cubre: `moveDownCombinesAndLoadsNextTileOnTopRow`.

- R2.7: comportamiento consistente en secuencia de movimientos distintos.
Cubre: `sequentialDifferentMovesBehaveConsistently`.

#### Requisitos inviables

- RI2.1: comprobar distribucion estadistica del azar real en tests de modulo.
Motivo: no determinista y fuera de alcance de pruebas de integracion reproducibles.

- RI2.2: cobertura exhaustiva de todas las secuencias posibles de estados del juego.
Motivo: explosion combinatoria; se aplica particionado representativo del dominio.

### Resultados JaCoCo (Ejercicio 2)

Clase objetivo: `ThreesController`

- Instrucciones: 596/596 = **100.00%**
- Branches: 71/78 = **91.03%**
- Lineas: 124/124 = **100.00%**
- Metodos: 19/19 = **100.00%**

Ejecucion:

- `JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test`
- Resultado global: 38 tests, 0 fallas.
