# Ejercicio 4

En esta carpeta se realizó la reparación de los cuatro programas del ejercicio anterior y los casos de prueba en JUnit.

## Archivos

- `src/main/java/OriginalPrograms.java`: version original con los defectos.
- `src/main/java/RepairedPrograms.java`: version reparada.
- `src/test/java/RepairedProgramsTest.java`: tests JUnit con los casos que en el ejercicio anterior hacian fallar al programa defectuoso.

## Como correr los tests

Desde `tp1/ejercicio4`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

Si se quiere correr solo esta clase de tests:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=RepairedProgramsTest test
```

## Reparaciones hechas

### 1. `findLast(int[] x, int y)`

El problema era que el ciclo terminaba en `i > 0`, asi que nunca revisaba la posicion `0`. La reparacion fue cambiar la condicion a `i >= 0`.

### 2. `lastZero(int[] x)`

El metodo tenia que devolver el ultimo cero, pero recorria el arreglo desde el inicio y devolvia el primero. La reparacion fue recorrer desde el final.

### 3. `countPositive(int[] x)`

Estaba contando valores `>= 0`, o sea que el `0` entraba como positivo. La reparacion fue contar solo los valores `> 0`.

### 4. `oddOrPos(int[] x)`

El codigo usaba `x[i] % 2 == 1`, pero eso en Java no reconoce a los impares negativos. La reparacion fue usar `x[i] % 2 != 0`.

## Tests implementados

Se implementaron como tests JUnit los mismos casos que en el enunciado mostraban la falla:

- `findLast([2,3,5], 2)` debe devolver `0`
- `lastZero([0,1,0])` debe devolver `2`
- `countPositive([-4,2,0,2])` debe devolver `2`
- `oddOrPos([-3,-2,0,1,4])` debe devolver `3`

Sobre `OriginalPrograms`, esos casos detectan la falla. Sobre `RepairedPrograms`, los mismos tests pasan.

## Explicacion con RIPR

### 1. `findLast`

- **Reachability**: el test ejecuta el `for` y llega a la condicion defectuosa `i > 0`.
- **Infection**: cuando el recorrido deberia considerar `i = 0`, el estado interno queda mal porque esa posicion no se revisa.
- **Propagation**: como el valor buscado esta justo en `x[0]`, el error interno afecta al valor de retorno.
- **Revealability**: el test compara el resultado obtenido con el esperado (`-1` contra `0`) y la falla queda visible.

### 2. `lastZero`

- **Reachability**: el test entra al recorrido de izquierda a derecha.
- **Infection**: el programa toma como candidato valido al primer cero encontrado, aunque todavia queda otro cero mas adelante.
- **Propagation**: ese indice incorrecto se devuelve directamente.
- **Revealability**: el test espera `2` y recibe `0`, asi que la diferencia se observa en la asercion.

### 3. `countPositive`

- **Reachability**: el test ejecuta la condicion `x[i] >= 0`.
- **Infection**: cuando el recorrido llega al `0`, el contador aumenta aunque no deberia.
- **Propagation**: ese conteo de mas afecta el valor final retornado.
- **Revealability**: el test espera `2`, pero el programa defectuoso devuelve `3`.

### 4. `oddOrPos`

- **Reachability**: el test evalua la condicion `x[i] % 2 == 1 || x[i] > 0`.
- **Infection**: al llegar a `-3`, el metodo no lo cuenta aunque es impar.
- **Propagation**: el contador queda una unidad por debajo de lo correcto.
- **Revealability**: el test espera `3` y el programa defectuoso da `2`, por eso la falla se detecta.

## Resultado esperado

Si se corre `mvn -Dmaven.repo.local=.m2 test` sobre esta carpeta, los tests deben pasar porque estan ejecutandose contra `RepairedPrograms`.
