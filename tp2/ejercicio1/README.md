# Ejercicio 1 — Lectura del capítulo 3

## Consigna

Lectura del capítulo 3 de *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición), *Test Automation*. No hay entrega de código.

## Material

- [Capítulo 3 — *Introduction to Software Testing*](/pdfs/tp2/material/Capitulo%203%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 03 — Automation](/pdfs/tp2/material/notas-03-automation.pdf)
- [Notas 04 — Data-driven testing](/pdfs/tp2/material/notas-04-data-driven-test.pdf)

## Resumen

- **Test Requirement (TR) y criterio de cobertura (TCC).** El TR es una propiedad sintáctica que un test tiene que cumplir (por ejemplo, "cubrir el arco e7 del grafo de flujo"); el criterio es la regla que, dado el artefacto bajo prueba, genera el conjunto de TRs.
- **Subsumption.** $C_1$ subsume a $C_2$ si todo test set que cubre $C_1$ también cubre $C_2$. Es lo que permite ordenar criterios por fuerza.
- **Patrón Arrange–Act–Assert.** Estructura repetible: preparar el escenario, ejecutar la operación, verificar el resultado. Se aplica en los ejercicios 3 y 6.
- **Test-Driven Development.** Escribir el test antes de la implementación como técnica de diseño.
- **Model-Driven Test Design (MDTD).** Marco que aplica los mismos criterios sobre cuatro modelos (control flow, data flow, logic, input space) a través de una capa intermedia. Se profundiza desde el TP3 en adelante.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
