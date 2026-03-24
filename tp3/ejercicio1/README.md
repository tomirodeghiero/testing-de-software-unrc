# Ejercicio 1 - Practico 3

## Material trabajado

Para este ejercicio tome como base el capitulo 6 del libro _Introduction to Software Testing_ (Ammann y Offutt, 2da edicion), usando el PDF de teoria.

- `../../material/Introduction to Software Testing.pdf`
- `/Users/tomasrodeghiero/Downloads/Introduction to Software Testing (2).pdf`

## Sintesis del capitulo 6 (Input Space Partitioning)

En este capitulo, la idea central es que no conviene elegir tests "a ojo" cuando una entrada tiene muchas combinaciones posibles. En cambio, se modela el dominio de entradas y, a partir de ese modelo, se derivan requisitos de test claros y medibles.

### 1) Modelo del dominio de entradas

Primero se identifican los parametros de entrada y luego se los describe con **caracteristicas** relevantes para testing. Cada caracteristica se divide en **bloques** (particiones) que representan clases de valores.

Un modelo de buena calidad deberia cumplir dos propiedades:

- **Completitud**: toda entrada valida deberia quedar cubierta por algun bloque.
- **Disyuncion**: una entrada no deberia caer en dos bloques de la misma caracteristica al mismo tiempo.

### 2) Criterios de cobertura sobre el modelo

Una vez definido el modelo, el capitulo propone distintos criterios para generar requisitos de test (TR):

- **Each Choice (EC)**: cada bloque de cada caracteristica debe aparecer al menos una vez.
- **Pairwise Coverage (PWC)**: para cada par de caracteristicas, toda pareja de bloques debe aparecer al menos una vez en algun test.
- **All Combinations (AC)**: cubrir todas las combinaciones posibles de bloques entre caracteristicas (muy costoso, pero maximo nivel de combinacion).
- **Base Choice (BC)**: se elige un caso base y luego se varia una caracteristica por vez.

La relacion costo/beneficio que destaca el capitulo es que **PWC suele dar buena deteccion de fallas con menos casos que AC**, porque muchos defectos se disparan por interaccion de a dos factores.

### 3) Restricciones e infeasibilidad

En la practica, no todas las combinaciones son validas. Por eso el modelo tiene que explicitar **restricciones** para eliminar combinaciones imposibles o fuera de especificacion.

Esto es clave para no perder tiempo escribiendo tests que nunca podrian ejecutarse en escenarios reales.

### 4) Flujo recomendado de trabajo

El proceso que me queda del capitulo es:

1. Identificar parametros de entrada.
2. Definir caracteristicas relevantes.
3. Particionar cada caracteristica en bloques.
4. Declarar restricciones entre bloques.
5. Elegir criterio de cobertura (EC, PWC, BC, AC).
6. Derivar los requisitos de test y recien ahi instanciar casos concretos.

## Reflexion aplicada al Practico 3

Este enfoque encaja directo con el ejercicio de `numberOfOcurrences(List<Integer> l, Integer element)`, porque obliga a modelar explicitamente situaciones como:

- `l` nula vs no nula
- `element` nulo vs no nulo
- lista vacia vs no vacia
- elemento presente vs ausente
- una ocurrencia vs multiples ocurrencias

Con ese modelo, cubrir por PWC deja de ser algo "intuitivo" y pasa a ser verificable: cada par de bloques entre caracteristicas queda respaldado por al menos un test documentado.

## Conclusion personal

Este capitulo me ordena mucho la forma de trabajar con los tests: primero modelo, despues cobertura, y recien al final implementacion. Eso evita tanto el subtesting (faltan escenarios) como el overtesting (casos redundantes sin aporte).
