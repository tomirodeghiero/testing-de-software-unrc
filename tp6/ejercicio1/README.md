# Ejercicio 1

En este ejercicio trabajé con mutación sobre el método `capicua` de `Palindrome` usando PIT.
La consigna pedía generar mutantes, agregar tests JUnit para matar todos los posibles, y responder las preguntas sobre cantidad de mutantes, cantidad de tests, score y mutantes equivalentes.

## Código analizado

- Método bajo test: [Palindrome.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/Palindrome.java)
- Suite de tests: [PalindromeTests.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/PalindromeTests.java)

## Cómo ejecuté PIT

Desde `tp6/assignment-6-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test org.pitest:pitest-maven:mutationCoverage
```

## Tests que definí

En `PalindromeTests` dejé 5 casos:

1. `testCapicua()` -> caso capicúa típico (`neuquen`).
2. `testNoCapicuaPar()` -> caso mínimo no capicúa (`{'a','b'}`).
3. `testNoCapicuaConExtremosIguales()` -> no capicúa con extremos iguales (`{'a','b','c','a'}`), para no depender solo del primer/último carácter.
4. `testArregloVacioEsCapicua()` -> borde de arreglo vacío.
5. `testUnElementoEsCapicua()` -> borde de un único elemento.

## Respuestas

### a) ¿Cuántos mutantes generó la herramienta?

PIT generó **9 mutantes** para `capicua`.

### b) ¿Cuántos tests definió para matar todos los mutantes?

Definí **5 tests**.

Con esos tests se matan todos los mutantes **no equivalentes**.

### c) ¿Qué puntaje de mutación obtuvo antes de analizar mutantes equivalentes?

El puntaje fue **89% (8/9)**.

Como referencia del progreso:

- línea base inicial (suite template): **56% (5/9)**
- suite final: **89% (8/9)**

### d) ¿Cuántos mutantes equivalentes hay? Justifique

Hay **1 mutante equivalente**.

Es el mutante de frontera en el `while`:

- original: `index < (l - 1)`
- mutado: `index <= (l - 1)`

Justificación:

1. Si `l=0`, ninguna versión entra al `while`.
2. Si `l=1`, la mutada agrega solo una comparación `list[0]` con `list[0]`, que siempre es verdadera y no cambia el resultado.
3. Si `l>=2`, la iteración extra en `index=l-1` vuelve a comparar extremos que ya fueron comparados antes (en espejo), sin alterar el valor final observado.

Por eso ese mutante sobrevive y no hay test que lo mate sin cambiar la semántica del método.

## Cierre

- Mutantes generados: **9**
- Mutantes muertos: **8**
- Mutantes equivalentes: **1**
- Score bruto: **89%**
- Score sobre mutantes no equivalentes: **100% (8/8)**
