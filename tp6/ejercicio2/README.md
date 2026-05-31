# Ejercicio 2 — Mutación sobre `TriTyp.triang` con Pitest

Testing de mutación con PIT sobre `TriTyp.triang`, que clasifica un triángulo como equilátero, isósceles, escaleno o no-triángulo a partir de tres lados. El objetivo es una suite JUnit que mate todos los mutantes generados.

## Ejecución de PIT

El `pom.xml` apunta a `Palindrome` por defecto, así que para correr Pitest sobre `TriTyp` hay que sobrescribir `targetClasses` y `targetTests` desde la línea de comandos:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -DtargetClasses=assignment6_exercises.TriTyp \
    -DtargetTests=assignment6_exercises.TriTypTest \
    test org.pitest:pitest-maven:mutationCoverage
```

## Suite

15 tests que activan todas las decisiones relevantes de `triang` y, por extensión, todos los mutantes generados por PIT. Los casos cubren:

1. Triángulo equilátero válido.
2. Triángulo escaleno válido.
3. Escaleno que **no** forma triángulo por igualdad estricta de la suma de dos lados con el tercero (tres permutaciones).
4. Escaleno que no forma triángulo por desigualdad estricta (la suma de dos lados es menor que el tercero).
5. Isósceles válido en sus tres variantes (`S1 == S2`, `S1 == S3`, `S2 == S3`).
6. Isósceles que no forma triángulo en cada una de esas tres variantes.
7. Casos con al menos un lado no positivo, evaluando cada una de las tres posiciones.

## Respuestas

**(a) ¿Cuántos mutantes generó la herramienta?** **39 mutantes** sobre `triang`.

**(b) ¿Cuántos tests definí?** **15 tests** en `TriTypTest`.

**(c) Mutation score.** **100% (39/39).** Progreso:
- Línea base inicial (1 test): 23% (9/39).
- Suite final (15 tests): 100% (39/39).

**(d) Mutantes equivalentes.** **0 equivalentes observados.** El reporte final de PIT terminó sin sobrevivientes (`KILLED 39 / GENERATED 39`), así que no quedó ningún mutante vivo para analizar. Podrían existir equivalentes en teoría, pero en esta corrida no fue necesario buscarlos.

## Cierre

- Mutantes generados: **39**
- Mutantes muertos: **39**
- Score bruto: **100%**

## Archivos

- [`TriTyp.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/main/java/assignment6_exercises/TriTyp.java)
- [`TriTypTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/test/java/assignment6_exercises/TriTypTest.java)

## Enlaces

- Enunciado: [`practico6.pdf`](/pdfs/tp6/practico6.pdf)
- Resolución: [`resolucion_practico6.pdf`](/pdfs/tp6/resolucion_practico6.pdf)
