# Ejercicio 1 - NodeCachingLinkedList con Randoop

## Objetivo

El trabajo consiste en aplicar testing automático sobre la clase `assignment8_exercises.ncl.NodeCachingLinkedList` utilizando Randoop. A partir de la suite generada se analizan los defectos que aparecen, se corrigen en el código fuente y finalmente se reportan las métricas de cobertura de ramas y de mutación.

## Trabajo realizado

El proceso seguido fue el siguiente:

1. Compilación del proyecto y generación inicial de tests con Randoop sobre `NodeCachingLinkedList`.
2. Análisis de las fallas detectadas por la herramienta para identificar defectos reales en la clase.
3. Corrección de los defectos encontrados e incorporación del contrato `repOK`.
4. Regeneración de la suite, dejándola como tests de regresión.
5. Ejecución de JaCoCo (cobertura) y PIT (mutación) para obtener las métricas finales.

## Defectos corregidos

Randoop permitió detectar dos problemas concretos en `NodeCachingLinkedList`:

1. El atributo `maximumCacheSize` no se inicializaba en el constructor, por lo que quedaba en `0` y deshabilitaba el cache.
2. El método `repOK()` no estaba implementado: devolvía siempre `false`, invalidando cualquier instancia desde el punto de vista del invariante.

Sobre esa base se hicieron dos agregados adicionales:

- Se implementó `repOK()` de forma completa, verificando la estructura de la lista, el estado del cache y la consistencia interna entre ambos.
- Se anotó `repOK()` con `@randoop.CheckRep` para que Randoop lo evalúe como invariante durante la generación y reporte cualquier violación.

## Comandos usados

Compilación del proyecto:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile
```

Generación de la suite con Randoop:

```bash
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200
```

Ejecución de los tests generados:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test
```

Análisis de mutación con PIT:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q org.pitest:pitest-maven:mutationCoverage
```

## Resultados

Una vez corregidos los defectos, la suite de regresión quedó en estado verde:

- 217 tests ejecutados
- 0 fallos
- 0 errores

La cobertura de ramas medida con JaCoCo sobre `NodeCachingLinkedList` fue:

- Ramas cubiertas: 25
- Ramas no cubiertas: 45
- Cobertura de ramas: 35,71%

El análisis de mutación con PIT arrojó los siguientes valores:

- Mutantes generados: 102
- Mutantes eliminados (killed): 39
- Mutation score: 38%
- Mutantes sin cobertura: 44
- Test strength: 67%

Los números muestran que la suite generada por Randoop detecta una porción razonable de los mutantes que efectivamente llegan a ejecutarse (test strength 67%), pero la baja cobertura de ramas limita el mutation score global.

## Archivos útiles

Reportes generados durante la ejecución:

- JaCoCo (HTML): `target/site/jacoco/index.html`
- JaCoCo (XML): `target/site/jacoco/jacoco.xml`
- PIT: `target/pit-reports`
- Surefire: `target/surefire-reports`

## Nota técnica

Para que las herramientas funcionen correctamente en este entorno fue necesario actualizar algunos plugins en `pom.xml`:

- `maven-surefire-plugin` a `3.2.5`
- `jacoco-maven-plugin` a `0.8.11`

Además, se ajustó el script `gen-randoop.sh` para acotar la salida y obtener una suite de tamaño manejable.
