# Ejercicio 2 — Diferencia entre *fault* y *failure*

## Consigna

Explicar la diferencia entre **defecto** (*fault*) y **falla** (*failure*) en testing de software.

## Resolución

Un **fault** es la causa interna del problema: existe en el código aunque nadie lo esté ejecutando. Es un defecto estático, sea en el código, el diseño o la especificación.

Una **failure** es la manifestación externa: solo aparece cuando el programa se ejecuta y se observa un comportamiento incorrecto desde afuera.

Entre los dos hay un concepto intermedio, el **error**, que es un estado interno incorrecto producido al ejecutar el fault. La relación es:

```
fault → error → failure
```

Es decir: hay un defecto en el código; al ejecutarlo, ese defecto puede producir un error en el estado interno; si ese error se propaga hasta la salida, recién ahí se observa una falla.

Esto importa porque **no todo defecto produce una falla en toda ejecución**. Un defecto puede ejecutarse y generar un estado interno incorrecto, pero si ese estado no afecta el resultado visible, no se observa nada.

### Ejemplo

Un método que busca ceros en un arreglo pero arranca el recorrido desde el índice `1` en lugar de `0`. Ahí hay un **fault**. Al ejecutarlo, el recorrido queda mal y se genera un **error** interno. Pero:

- Si para una entrada el resultado coincide igual con el esperado, hay fault y hay error, pero no se observa **failure**.
- Si para otra entrada ese error llega al valor devuelto, recién ahí hay **failure**.

### Analogía

Pensándolo como un diagnóstico médico: la **failure** es el síntoma que se observa, el **fault** es la causa raíz, y el **error** es la condición interna anómala que conecta una cosa con la otra.

En resumen: el fault está en el programa, la failure aparece en la ejecución, y el error es el puente entre los dos.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
