# Ejercicio 1 — Lectura del capítulo 6 (*Input Space Partitioning*)

## Consigna

Leer el capítulo 6 de *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición), titulado *Input Space Partitioning*. El ejercicio no pide entrega de código: fija el marco conceptual que se aplica en los Ejercicios 2 a 5.

## Material de lectura

- [Capítulo 6 — *Introduction to Software Testing*](/pdfs/tp3/material/Capitulo%206%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 05 — Criterios de cobertura](/pdfs/tp3/material/notas-05-criterios.pdf)
- [Notas 06 — Input Space Partitioning](/pdfs/tp3/material/notas-06-input.pdf)

## Síntesis del capítulo

La idea central del capítulo es que no conviene elegir casos de test "a ojo" cuando una entrada admite muchas combinaciones posibles. En su lugar, se modela el dominio de entradas y, a partir de ese modelo, se derivan requisitos de test claros y medibles.

### 1) Modelo del dominio de entradas (MDE)

Primero se identifican los parámetros de entrada y luego se los describe con **características** relevantes para testing. Cada característica se divide en **bloques** (particiones) que representan clases de valores. Un MDE de buena calidad cumple dos propiedades:

- **Completitud**: toda entrada válida queda cubierta por algún bloque.
- **Disyunción (*disjointness*)**: una entrada no cae en dos bloques de la misma característica al mismo tiempo.

### 2) Dos enfoques para construirlo

- **Basado en interfaz**: una característica por parámetro, mirando la sintaxis. Rápido, pero ignora relaciones entre parámetros.
- **Basado en funcionalidad**: las características se derivan del comportamiento esperado (precondiciones, poscondiciones, valores especiales). Más costoso, pero mucho más expresivo.

### 3) Criterios de cobertura sobre el modelo

- **Each Choice (ECC)**: cada bloque de cada característica aparece al menos una vez.
- **Pair-Wise Coverage (PWC)**: para cada par de características, toda pareja de bloques aparece al menos una vez en algún test.
- **All Combinations (AC)**: cubre todas las combinaciones posibles de bloques entre características. Máxima fuerza, también máximo costo.
- **Base Choice (BCC)**: se elige un caso base por característica y se varía una a la vez.

La relación costo/beneficio que destaca el capítulo es que **PWC suele dar buena detección de fallas con muchos menos casos que AC**, porque la mayoría de los defectos se disparan por interacción de a dos factores.

### 4) Restricciones e infactibilidad

En la práctica no todas las combinaciones son válidas. El modelo debe explicitar **restricciones** para descartar combinaciones imposibles o fuera de especificación. Esto evita generar requisitos que ningún test podría satisfacer.

### 5) Flujo recomendado

1. Identificar los parámetros de entrada.
2. Definir las características relevantes.
3. Particionar cada característica en bloques.
4. Declarar las restricciones entre bloques.
5. Elegir el criterio de cobertura (ECC, PWC, BCC, AC).
6. Derivar los requisitos de test y, recién al final, instanciar casos concretos.

## Aplicación al resto del práctico

Este enfoque encaja directo con los ejercicios siguientes. Por ejemplo, para `numberOfOcurrences(List<Integer> l, Integer element)` el MDE obliga a modelar explícitamente situaciones como:

- `l` nula vs. no nula,
- `element` nulo vs. no nulo,
- lista vacía vs. no vacía,
- elemento presente vs. ausente,
- una ocurrencia vs. múltiples ocurrencias.

Con ese modelo, cubrir por PWC deja de ser algo "intuitivo" y pasa a ser verificable: cada par de bloques entre características queda respaldado por al menos un test documentado.

Para una versión más extensa con definiciones y ejemplos, ver el [Resumen teórico del TP3](/pdfs/tp3/resumen_teorico_practico3.pdf).

## Enlaces relacionados

- Enunciado del práctico: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución completa: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
- Resumen teórico: [`resumen_teorico_practico3.pdf`](/pdfs/tp3/resumen_teorico_practico3.pdf)
