# Práctico 9 — Trabajo práctico final

## Documentos principales

- Enunciado: [`practico9.pdf`](/pdfs/tp9/practico9.pdf)
- Resolución: [`resolucion_practico9.pdf`](/pdfs/tp9/resolucion_practico9.pdf)

## Ejercicios

- `ejercicio1/` — `ThreesBoard` con caracterización del dominio de inputs: particiones sobre coordenadas, tiles, reglas de combinación, movilidad y puntaje.
- `ejercicio2/` — `ThreesController`: tests de módulo / integración sobre `moveUp/Down/Left/Right`, con `RandomGenerator` determinista para asserts reproducibles.

## Sobre el dominio: el juego *Threes*

En el proyecto implemento una versión simplificada del juego *Threes* (tablero `4 × 4` con baldosas combinables: `1 + 2`, `2 + 1`, `x + x` con `x ≥ 3`). Las clases bajo prueba son:

- `ThreesBoard` — modelo del tablero, reglas de combinación, conteo y puntaje.
- `ThreesController` — orquesta movimientos, colapso, combinación y carga de la siguiente baldosa.
- `ThreesTile`, `RandomGenerator`, `RandomValueGenerator` — auxiliares.

## Código fuente

- [`ThreesBoard.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesBoard.java)
- [`ThreesController.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesController.java)
- [`ThreesTile.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/ThreesTile.java)
- [`RandomGenerator.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/RandomGenerator.java)
- [`RandomValueGenerator.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/main/java/assignment9_exercises/RandomValueGenerator.java)

Tests:

- [`ThreesBoardInputDomainCharacterizationTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesBoardInputDomainCharacterizationTest.java)
- [`ThreesControllerModuleIntegrationTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp9/assignment-9-rodeghiero-1/src/test/java/assignment9_exercises/ThreesControllerModuleIntegrationTest.java)

## Cómo correr los tests

El código se encuentra en `assignment-9-rodeghiero-1/`. Recomiendo usar JDK 17. La build se basa en JaCoCo 0.8.12 para reportar cobertura.

```bash
cd tp9/assignment-9-rodeghiero-1
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 test
```

Suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 \
    -Dtest=ThreesBoardInputDomainCharacterizationTest test
```

Reporte JaCoCo:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 test jacoco:report
# Salida HTML: target/site/jacoco/index.html
```

## Resultados resumidos

| Clase | Líneas | Branches | Métodos |
|---|---|---|---|
| `ThreesBoard` | 85 / 97 (87.63 %) | 108 / 124 (87.10 %) | 12 / 13 (92.31 %) |
| `ThreesController` | 124 / 124 (100 %) | 71 / 78 (91.03 %) | 19 / 19 (100 %) |

Suites: **38 tests, 0 fallas**.
