# Ejercicio 1

Lectura del capitulo 3 de _Introduction to Software Testing_
(P. Ammann y J. Offutt, 2da edicion).

## Material usado

- `../material/Capitulo 3 - Introduction to Software Testing.pdf`

## Ideas centrales del capitulo

El capitulo 3 es el primer capitulo "tecnico" del libro. Sirve de base
para todo el resto del cuatrimestre porque introduce los conceptos que
despues se aplican en cualquier tipo de testing (unitario, integracion,
sistema, mutation, fuzzing):

- **Test requirement (TR) y criterio de cobertura (TCC)**: un TR es una
  propiedad sintactica que un test debe satisfacer (por ejemplo
  *cubrir el arco e7 del grafo de flujo*) y un criterio de cobertura
  es una regla que, dado un artefacto, genera el conjunto de TRs a
  cubrir.
- **Subsumption** entre criterios: un criterio C1 subsume a C2 si
  cubrir C1 implica cubrir C2. Esto permite ordenar los criterios por
  "fuerza" (por ejemplo, *edge coverage* subsume a *node coverage*).
- **Test automation**: estructura repetible de los tests siguiendo el
  patron *arrange - act - assert*, uso de drivers, stubs y fixtures.
- **Test-driven development**: se motiva escribir el test antes de la
  implementacion como tecnica de diseno.
- **Modelo MDTD (Model-Driven Test Design)** y los cuatro niveles de
  abstraccion donde aplicar los mismos criterios: control-flow,
  data-flow, logica y entradas (input space).

Estos contenidos se trabajan con mayor detalle en el resumen teorico
(`../resumen_teorico_tp2.tex`).
