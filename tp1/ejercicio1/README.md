# Ejercicio 1 — Lectura de los capítulos 1 y 2

## Consigna

Leer los capítulos 1 y 2 del libro *Introduction to Software Testing* (Ammann & Offutt, 2.ª edición). El ejercicio no pide una entrega de código: es la base conceptual que se aplica en el resto del práctico.

## Material de lectura

- [Capítulos 1 y 2 — *Introduction to Software Testing*](/pdfs/tp1/material/Capitulos%201%20y%202%20-%20Introduction%20to%20Software%20Testing.pdf)

Las notas de cátedra que cubren las mismas unidades también acompañan la lectura:

- [Notas 00 — Testing de Software](/pdfs/tp1/material/notas-00-testing-de-software.pdf)
- [Notas 01 — Testing de Software](/pdfs/tp1/material/notas-01-testing-de-software.pdf)
- [Notas 02 — TS](/pdfs/tp1/material/notas-02-ts.pdf)

## Qué aporta esta lectura al resto del práctico

Los capítulos establecen el vocabulario que se usa en todos los ejercicios siguientes y conviene fijar antes de seguir avanzando:

- **Calidad y motivación del testing.** Por qué testear es una actividad de ingeniería —no un control final—, con los casos clásicos (Therac-25, Ariane 5, Mars Climate Orbiter, Pentium FDIV, Zune) como evidencia del costo real de un defecto.
- **Definiciones de *fault*, *error* y *failure*.** La distinción aparece de forma operativa: el *fault* es el defecto estático en el código, el *error* es el estado interno incorrecto producido al ejecutarlo, y la *failure* es el comportamiento externo observable. Esa cadena `fault → error → failure` se usa explícitamente en el Ejercicio 2.
- **Modelo RIPR.** *Reachability, Infection, Propagation, Revealability*: las cuatro condiciones que un test debe satisfacer para revelar un defecto. Es la herramienta que se aplica en los Ejercicios 3 y 4 para razonar por qué un caso produce o no una falla.
- **Test requirements y criterios de cobertura.** Primera presentación de la idea de que un criterio define qué hay que cubrir, mientras que los tests son los artefactos concretos que cumplen esos requerimientos. Es el andamiaje conceptual que se profundiza desde el TP3 en adelante.
- **Niveles y tipos de testing.** Unidad, integración, sistema y aceptación; *black-box* vs. *white-box*; el lugar del testing dentro del ciclo de vida del software.

Para una versión más extensa con definiciones, ejemplos y diagramas, ver el [Resumen teórico del TP1](/pdfs/tp1/resumen-teorico-testing-tp1.pdf), que reorganiza el contenido del libro junto con las notas de cátedra.

## Enlaces relacionados

- Enunciado completo del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa en PDF: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
