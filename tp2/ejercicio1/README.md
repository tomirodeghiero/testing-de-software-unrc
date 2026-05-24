# Ejercicio 1 — Lectura del capítulo 3

## Consigna

Leer el capítulo 3 de *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición), titulado *Test Automation*. El ejercicio no pide entrega de código: es la base teórica que se aplica en los ejercicios siguientes.

## Material de lectura

- [Capítulo 3 — *Introduction to Software Testing*](/pdfs/tp2/material/Capitulo%203%20-%20Introduction%20to%20Software%20Testing.pdf)

Las notas de la cátedra que cubren las mismas unidades complementan la lectura:

- [Notas 03 — Automation](/pdfs/tp2/material/notas-03-automation.pdf)
- [Notas 04 — Data-driven testing](/pdfs/tp2/material/notas-04-data-driven-test.pdf)

## Qué aporta esta lectura al resto del práctico

El capítulo 3 es el primer capítulo técnico del libro y fija el vocabulario que se usa en todos los ejercicios siguientes:

- **Test Requirement (TR) y criterio de cobertura (TCC).** Un TR es una propiedad sintáctica que un test debe satisfacer (por ejemplo, *cubrir el arco e7 del grafo de flujo*); un criterio de cobertura es una regla que, dado un artefacto bajo prueba, genera el conjunto de TRs a cubrir.
- **Subsumption entre criterios.** $C_1$ subsume a $C_2$ si todo test set que cubre $C_1$ también cubre $C_2$. Esto permite ordenar los criterios por fuerza (por ejemplo, *edge coverage* subsume a *node coverage*).
- **Patrón Arrange–Act–Assert.** Estructura repetible para tests automatizados, con separación clara entre preparación del escenario, ejecución de la operación y verificación del resultado. Se aplica explícitamente en los Ejercicios 3 y 6.
- **Test-Driven Development.** Escribir el test antes de la implementación como técnica de diseño.
- **Model-Driven Test Design (MDTD).** Marco que aplica los mismos criterios sobre cuatro modelos —*control flow*, *data flow*, *logic* e *input space*— a través de una capa de abstracción intermedia. Es el andamiaje conceptual que se profundiza desde el TP3 en adelante.

Para una versión más extensa con definiciones, ejemplos y diagramas, ver el [Resumen teórico del TP2](/pdfs/tp2/resumen_teorico_tp2.pdf), que reorganiza el contenido del libro junto con las notas de cátedra.

## Enlaces relacionados

- Enunciado del práctico: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución completa: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- Resumen teórico: [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
