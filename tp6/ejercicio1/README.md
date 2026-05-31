# Ejercicio 1 — Mutación sobre `Palindrome.capicua` con Pitest

Testing de mutación con PIT sobre `Palindrome.capicua`. La consigna pide generar mutantes, escribir una suite JUnit que los mate, y responder cuatro preguntas (cantidad de mutantes, tests, mutation score y mutantes equivalentes).

## El método

`Palindrome.capicua(char[])` recibe un arreglo de `char` y determina si es capicúa recorriéndolo desde los extremos hacia el centro mientras los caracteres coincidan:

```java
public static boolean capicua(char[] list) {
    int index = 0;
    int l = list.length;
    boolean res = true;
    while (index < (l - 1) && res) {
        if (list[index] != list[(l - index) - 1]) {
            res = false;
        }
        index++;
    }
    return res;
}
```

## Ejecución de PIT

Desde `tp6/assignment-6-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    test org.pitest:pitest-maven:mutationCoverage
```

`-Djacoco.skip=true` evita conflictos con JaCoCo (PIT instrumenta el bytecode por su cuenta).

## Suite

5 tests pensados para cubrir caminos típicos y bordes:

1. `testCapicua()` — capicúa típica (`"neuquen"`).
2. `testNoCapicuaPar()` — caso mínimo no capicúa con dos caracteres distintos (`{'a','b'}`).
3. `testNoCapicuaConExtremosIguales()` — `{'a','b','c','a'}`. Es **el test clave**: obliga a que la verificación no se quede solo en comparar el primer y último carácter.
4. `testArregloVacioEsCapicua()` — arreglo vacío (capicúa por definición).
5. `testUnElementoEsCapicua()` — arreglo de un elemento (capicúa trivialmente).

## Respuestas

**(a) ¿Cuántos mutantes generó la herramienta?** PIT generó **9 mutantes** sobre `capicua`.

**(b) ¿Cuántos tests definí?** **5 tests**. Alcanzan para matar todos los mutantes que no son equivalentes.

**(c) Mutation score.** **89% (8/9).** Progreso de la suite:
- Línea base (suite del template): 56% (5/9).
- Suite final: 89% (8/9).

**(d) Mutantes equivalentes.** Hay **1 mutante equivalente**: una mutación de frontera en la guarda del `while`:

- Original: `index < (l - 1)`
- Mutado: `index <= (l - 1)`

El cambio no altera el resultado observable en ninguna entrada:

1. Si `l == 0`, ninguna versión entra al `while`, las dos devuelven `true`.
2. Si `l == 1`, la versión mutada agrega una iteración extra que compara `list[0]` consigo mismo. La comparación siempre da verdadera y `res` no cambia.
3. Si `l >= 2`, la iteración adicional con `index = l - 1` vuelve a comparar un par de extremos que ya había sido evaluado antes (en posición espejo). Tampoco cambia `res`.

No existe entrada que diferencie el código original del mutado, así que no se puede matar sin cambiar la semántica.

## Cierre

- Mutantes generados: **9**
- Mutantes muertos: **8**
- Mutantes equivalentes: **1**
- Score bruto: **89%**
- Score sobre mutantes no equivalentes: **100%**

## Archivos

- [`Palindrome.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/main/java/assignment6_exercises/Palindrome.java)
- [`PalindromeTests.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/test/java/assignment6_exercises/PalindromeTests.java)

## Enlaces

- Enunciado: [`practico6.pdf`](/pdfs/tp6/practico6.pdf)
- Resolución: [`resolucion_practico6.pdf`](/pdfs/tp6/resolucion_practico6.pdf)
