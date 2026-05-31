# Ejercicio 4 — Reparaciones y tests JUnit

## Consigna

Tomar los cuatro programas del ejercicio 3 y:

- aplicar las reparaciones;
- llevar los casos de test a **JUnit** para verificar que las correcciones funcionen;
- justificar, para cada caso, por qué el test detecta la falla usando el modelo **RIPR**.

## Archivos

- [`src/main/java/OriginalPrograms.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio4/src/main/java/OriginalPrograms.java) — versión con los defectos.
- [`src/main/java/RepairedPrograms.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio4/src/main/java/RepairedPrograms.java) — versión reparada.
- [`src/test/java/RepairedProgramsTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio4/src/test/java/RepairedProgramsTest.java) — tests JUnit con los casos del ejercicio anterior.
- [`pom.xml`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio4/pom.xml) — configuración Maven.

## Cómo correr los tests

```bash
cd tp1/ejercicio4
mvn -Dmaven.repo.local=.m2 test
```

Solo esta clase:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=RepairedProgramsTest test
```

## Reparaciones aplicadas

- `findLast`: el `for` iteraba con `i > 0`, lo cambié a `i >= 0`.
- `lastZero`: recorría desde el inicio y devolvía el primer cero; lo cambié para recorrer desde el final.
- `countPositive`: comparaba `>= 0`, lo cambié a `> 0`.
- `oddOrPos`: usaba `x[i] % 2 == 1`, lo cambié a `x[i] % 2 != 0`.

## Tests

Los casos JUnit son los mismos que en el ejercicio 3 hacían fallar a la versión defectuosa:

- `findLast([2,3,5], 2)` → `0`
- `lastZero([0,1,0])` → `2`
- `countPositive([-4,2,0,2])` → `2`
- `oddOrPos([-3,-2,0,1,4])` → `3`

Sobre `OriginalPrograms` esos casos detectan la falla; sobre `RepairedPrograms` pasan.

## Análisis RIPR

**`findLast`.** El test ejecuta el `for` y llega a la condición defectuosa (R). Cuando le tocaría revisar `i = 0`, esa posición no se inspecciona (I). Como el valor buscado está justo ahí, el error afecta el retorno (P). El assert compara `-1` contra `0` y la falla queda visible (R).

**`lastZero`.** El test entra al recorrido de izquierda a derecha (R). El programa toma como respuesta al primer cero, aunque hay otro más adelante (I). Ese índice se devuelve sin más (P). El test espera `2` y recibe `0` (R).

**`countPositive`.** El test ejecuta `x[i] >= 0` (R). Cuando el recorrido llega al `0`, el contador aumenta de más (I). Eso afecta el valor final (P). El test espera `2` y recibe `3` (R).

**`oddOrPos`.** El test evalúa `x[i] % 2 == 1 || x[i] > 0` (R). Al llegar a `-3`, el método no lo cuenta aunque es impar (I). El contador queda una unidad por debajo (P). El test espera `3` y recibe `2` (R).

## Resultado

`mvn test` sobre esta carpeta corre los tests contra `RepairedPrograms` y todos pasan.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
