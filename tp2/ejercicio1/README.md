# Ejercicio 1 — Lectura del capítulo 3

## Consigna

Lectura del capítulo 3 de *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición), *Test Automation*. No hay entrega de código.

## Material

- [Capítulo 3 — *Introduction to Software Testing*](/pdfs/tp2/material/Capitulo%203%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 03 — Automation](/pdfs/tp2/material/notas-03-automation.pdf)
- [Notas 04 — Data-driven testing](/pdfs/tp2/material/notas-04-data-driven-test.pdf)

## Resumen

- **Test Requirement (TR) y criterio de cobertura (TCC).** Un TR es una condición sintáctica concreta que cada test debe satisfacer —por ejemplo, *cubrir el arco e7 del grafo de flujo*—; el TCC es la regla que, aplicada al artefacto bajo prueba, deriva el conjunto completo de TRs que la suite tiene que cumplir.
- **Subsumption.** *C₁* subsume a *C₂* si todo test set que cubre *C₁* también cubre *C₂*. Es lo que permite ordenar criterios por fuerza.
- **Patrón Arrange–Act–Assert.** Estructura repetible: preparar el escenario, ejecutar la operación, verificar el resultado. Se aplica en los ejercicios 3 y 6.
- **Test-Driven Development.** Escribir el test antes de la implementación como técnica de diseño.
- **Model-Driven Test Design (MDTD).** Marco que aplica los mismos criterios sobre cuatro modelos (control flow, data flow, logic, input space) a través de una capa intermedia.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
