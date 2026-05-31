# Ejercicio 1 — `NodeCachingLinkedList` con Randoop

## Objetivo

Aplicar testing automático con **Randoop** sobre `assignment8_exercises.ncl.NodeCachingLinkedList`. A partir de la suite generada se analizan los defectos que aparecen, se corrigen en el código y se reportan las métricas de cobertura de ramas y mutación.

## Flujo de trabajo

1. Compilar el proyecto y generar la suite inicial con Randoop.
2. Analizar las fallas detectadas para identificar defectos reales.
3. Corregir los defectos e incorporar el contrato `repOK()`.
4. Regenerar la suite, dejándola como tests de regresión.
5. Ejecutar JaCoCo (cobertura) y PIT (mutación) para sacar métricas.

## Defectos corregidos

Randoop detectó dos problemas concretos en `NodeCachingLinkedList`:

1. **`maximumCacheSize` no se inicializaba en el constructor**: quedaba en `0` y deshabilitaba el cache (si `cacheSize >= maximumCacheSize` siempre es cierto, nunca se cachean nodos).
2. **`repOK()` no estaba implementado**: devolvía `false` siempre, invalidando cualquier instancia desde el punto de vista del invariante.

Sobre esa base hice dos agregados:

- Implementé `repOK()` completo, verificando la estructura de la lista, el estado del cache y la consistencia entre ambos.
- Anoté `repOK()` con `@randoop.CheckRep` para que Randoop lo evalúe durante la generación y reporte cualquier violación.

## Comandos

```bash
cd tp8/assignment-8-rodeghiero

# Compilación
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile

# Generación con Randoop (clase, time-limit, output-limit, tests-per-file)
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200

# Tests
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test

# Mutación con PIT
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q org.pitest:pitest-maven:mutationCoverage
```

## Resultados

Suite de regresión final:

- 217 tests
- 0 fallos
- 0 errores

**Cobertura de ramas con JaCoCo** sobre `NodeCachingLinkedList`:

- Ramas cubiertas: 25
- Ramas no cubiertas: 45
- Cobertura: **35,71 %**

**Análisis de mutación con PIT**:

- Mutantes generados: 102
- Mutantes muertos: 39
- Mutation score: **38 %**
- Mutantes sin cobertura: 44
- Test strength: **67 %**

Los números muestran que la suite generada por Randoop detecta una porción razonable de los mutantes que efectivamente llegan a ejecutarse (test strength 67 %), pero la baja cobertura de ramas limita el mutation score global.

## Reportes generados

- JaCoCo (HTML): `target/site/jacoco/index.html`
- JaCoCo (XML): `target/site/jacoco/jacoco.xml`
- PIT: `target/pit-reports`
- Surefire: `target/surefire-reports`

## Nota técnica sobre el entorno

Tuve que actualizar plugins del `pom.xml` para que las herramientas anden en este entorno:

- `maven-surefire-plugin` a `3.2.5`
- `jacoco-maven-plugin` a `0.8.11`

Y ajusté `gen-randoop.sh` para acotar la salida y obtener una suite manejable.

## Archivos

- [`NodeCachingLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/ncl/NodeCachingLinkedList.java) — implementación con `repOK()` y la corrección del constructor.
- [`LinkedListNode.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/ncl/LinkedListNode.java)
- [`RegressionTest0.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/ncl/RegressionTest0.java) / [`RegressionTest1.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/ncl/RegressionTest1.java) — suite generada por Randoop.

## Enlaces

- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)
