# Ejercicio 1 — Lectura del capítulo 6 (*Input Space Partitioning*)

## Consigna

Lectura el capítulo 6 de *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición), *Input Space Partitioning*. No hay entrega de código: es el marco que se aplica en los ejercicios 2 a 5.

## Material

- [Capítulo 6 — *Introduction to Software Testing*](/pdfs/tp3/material/Capitulo%206%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 05 — Criterios de cobertura](/pdfs/tp3/material/notas-05-criterios.pdf)
- [Notas 06 — Input Space Partitioning](/pdfs/tp3/material/notas-06-input.pdf)

## Qué saco en limpio

La idea central: en lugar de elegir casos de test "a ojo", se modela el dominio de entradas y de ahí se derivan requisitos claros y medibles.

- **Modelo del Dominio de Entradas (MDE).** Se identifican los parámetros y se les asocian **características** relevantes; cada característica se divide en **bloques** (clases de valores). Un MDE bien hecho cumple dos propiedades: toda entrada válida cae en algún bloque (**completitud**) y no cae en dos a la vez (**disjointness**).
- **Dos enfoques.** *Basado en interfaz* (una característica por parámetro, mirando la sintaxis) es rápido pero ignora relaciones; *basado en funcionalidad* (características derivadas del comportamiento esperado) es más costoso pero más expresivo.
- **Criterios sobre el modelo.**
  - *Each Choice (ECC)*: cada bloque aparece al menos una vez.
  - *Pair-Wise (PWC)*: para cada par de características, toda combinación de bloques aparece en algún test.
  - *Base Choice (BCC)*: se elige un caso base y se varía una característica a la vez.
  - *All Combinations (ACoC)*: producto cartesiano. Máxima fuerza, máximo costo.
- **PWC vs ACoC.** PWC suele dar buena detección con muchos menos casos: la mayoría de los defectos se disparan por interacción de dos factores.
- **Restricciones.** No todas las combinaciones son válidas; el modelo debe explicitar las que son infactibles para no generar requisitos imposibles.

## Enlaces

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
