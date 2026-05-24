---
title: "Ejercicio 1"
sidebar_position: 1
slug: "/tp6/ejercicio1/"
description: "Contenido importado desde tp6/ejercicio1/README.md"
---

# Ejercicio 1

En este ejercicio trabajé sobre el método `capicua` de la clase `Palindrome`, aplicando testing de mutación con la herramienta PIT.
La consigna pedía generar mutantes a partir del código original, escribir una suite de tests JUnit que lograra matarlos, y luego responder cuatro preguntas sobre la cantidad de mutantes generados, los tests definidos, el score de mutación obtenido y la presencia de mutantes equivalentes.

## Código analizado

- Método bajo test: [Palindrome.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/Palindrome.java)
- Suite de tests: [PalindromeTests.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/PalindromeTests.java)

El método recibe un arreglo de `char` y determina si es capicúa, recorriéndolo desde los extremos hacia el centro mientras los caracteres comparados coincidan.

## Ejecución de PIT

Desde el directorio `tp6/assignment-6-rodeghiero` se debe ejecutar el siguiente comando para correr los tests y generar el reporte de mutación:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test org.pitest:pitest-maven:mutationCoverage
```

La opción `-Djacoco.skip=true` se utiliza para evitar conflictos con el plugin de cobertura de JaCoCo, ya que PIT instrumenta el bytecode por su cuenta.

## Tests definidos

La suite final de `PalindromeTests` quedó con cinco casos pensados para cubrir tanto los caminos típicos como los bordes del método:

1. `testCapicua()` — verifica un caso capicúa típico con la palabra `neuquen`.
2. `testNoCapicuaPar()` — el caso mínimo no capicúa con dos caracteres distintos (`{'a','b'}`).
3. `testNoCapicuaConExtremosIguales()` — un arreglo no capicúa cuyos extremos sí coinciden (`{'a','b','c','a'}`). Este test es importante porque obliga a que la verificación no se quede solo en comparar el primer y último carácter.
4. `testArregloVacioEsCapicua()` — caso borde con arreglo vacío, que por definición debe considerarse capicúa.
5. `testUnElementoEsCapicua()` — caso borde con un único elemento, también capicúa de manera trivial.

## Respuestas

### a) ¿Cuántos mutantes generó la herramienta?

PIT generó **9 mutantes** sobre el método `capicua`.

### b) ¿Cuántos tests definí para matar todos los mutantes?

Definí **5 tests**, suficientes para matar todos los mutantes que no son equivalentes.

### c) ¿Qué puntaje de mutación obtuvo antes de analizar mutantes equivalentes?

El score final fue de **89% (8/9)**.

A modo de referencia, este fue el progreso de la suite a medida que la fui completando:

- Línea base inicial (suite del template): **56% (5/9)**.
- Suite final: **89% (8/9)**.

### d) ¿Cuántos mutantes equivalentes hay? Justifique

Hay **1 mutante equivalente**, correspondiente a una mutación de frontera en la guarda del `while`:

- Original: `index < (l - 1)`
- Mutado: `index <= (l - 1)`

La justificación es que el cambio en la condición no altera el resultado observable del método en ninguno de los casos posibles:

1. Si `l == 0`, ninguna versión entra al `while`, por lo que ambas devuelven `true`.
2. Si `l == 1`, la versión mutada agrega una única iteración extra que compara `list[0]` consigo mismo. Esa comparación siempre da verdadera, así que `res` no cambia.
3. Si `l >= 2`, la iteración adicional en `index = l - 1` vuelve a comparar un par de extremos que ya había sido evaluado antes (en posición espejo), por lo que tampoco modifica el valor final de `res`.

En consecuencia, no existe ninguna entrada que diferencie el comportamiento del código original del mutado, y por eso no es posible matarlo sin alterar la semántica del método.

## Cierre

- Mutantes generados: **9**
- Mutantes muertos: **8**
- Mutantes equivalentes: **1**
- Score bruto: **89%**
- Score sobre mutantes no equivalentes: **100% (8/8)**

El resultado final es el esperado: la suite mata todos los mutantes que sí podían diferenciarse del original, y el mutante restante quedó identificado y justificado como equivalente.
