# Ejercicio 2

En este ejercicio apliqué testing de mutación con PIT sobre el método `triang` de la clase `TriTyp`, que clasifica un triángulo como equilátero, isósceles, escaleno o no-triángulo a partir de la longitud de sus tres lados.
El objetivo fue construir una suite JUnit lo suficientemente fuerte como para matar todos los mutantes generados por la herramienta y justificar los resultados obtenidos.

## Código analizado

- Método bajo test: [TriTyp.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/TriTyp.java)
- Suite de tests: [TriTypTest.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/TriTypTest.java)

## Ejecución de PIT para `TriTyp`

Como el `pom.xml` venía configurado por defecto para apuntar a la clase `Palindrome` del ejercicio anterior, en este caso fue necesario sobreescribir desde la línea de comandos los parámetros `targetClasses` y `targetTests` para indicarle a PIT que debía analizar `TriTyp`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
  -DtargetClasses=assignment6_exercises.TriTyp \
  -DtargetTests=assignment6_exercises.TriTypTest \
  test org.pitest:pitest-maven:mutationCoverage
```

## Suite de tests construida

La suite final quedó conformada por **15 tests**, diseñados para activar todas las decisiones relevantes del método `triang` y, por extensión, todos los mutantes generados por PIT. Los casos cubren los siguientes escenarios:

1. Triángulo equilátero válido.
2. Triángulo escaleno válido.
3. Escaleno que no forma triángulo por igualdad estricta de la suma de dos lados con el tercero, en las tres permutaciones posibles.
4. Escaleno que no forma triángulo por desigualdad estricta (la suma de dos lados es menor que el tercero).
5. Isósceles válido en sus tres variantes según qué par de lados sea igual (`S1 == S2`, `S1 == S3`, `S2 == S3`).
6. Isósceles que no forma triángulo en cada una de esas tres variantes.
7. Casos con al menos un lado no positivo, evaluando cada una de las tres posiciones.

Con esta combinación se ejercitan todas las ramas condicionales del método y se logra matar la totalidad de los mutantes detectados por la herramienta.

## Respuestas

### a) ¿Cuántos mutantes generó la herramienta?

PIT generó **39 mutantes** sobre el método `triang`.

### b) ¿Cuántos tests definí para matar todos los mutantes?

Definí **15 tests** en `TriTypTest`.

### c) ¿Qué puntaje de mutación obtuvo antes de analizar mutantes equivalentes?

El score final alcanzado fue de **100% (39/39)**.

Como referencia del progreso de la suite, partiendo de un único test de la línea base:

- Línea base inicial (1 test): **23% (9/39)**.
- Suite final (15 tests): **100% (39/39)**.

### d) ¿Cuántos mutantes equivalentes hay? Justifique

En esta corrida quedaron **0 mutantes equivalentes observados**.

La justificación es directa: el reporte final de PIT terminó sin sobrevivientes (`KILLED 39 / GENERATED 39`), por lo que no quedó ningún mutante vivo que requiriera ser analizado para descartar como equivalente. Si bien teóricamente podrían existir mutantes equivalentes en otros puntos del programa, en este ejercicio no fue necesario identificarlos, ya que la suite logró cobertura total de mutación.

## Cierre

- Mutantes generados: **39**
- Mutantes muertos: **39**
- Mutantes equivalentes observados: **0**
- Score bruto: **100%**

El resultado refleja una suite de tests robusta, capaz de discriminar el comportamiento de cada mutante respecto del código original sin necesidad de realizar análisis adicional sobre equivalencias.
