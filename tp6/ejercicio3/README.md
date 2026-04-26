# Ejercicio 3

Este ejercicio estuvo orientado a completar la parte de fuzzing del template provisto por la cátedra.
La consigna pedía implementar las clases `Mutator`, `MutationFuzzer` y `RandomFuzzer`, y cerrar el test parametrizado que ejecuta el comando `bc` sobre entradas generadas mediante fuzzing, validando que el proceso no exhiba comportamientos inesperados o críticos.

## Código completado

Los archivos editados son los siguientes:

- [Mutator.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/Mutator.java)
- [MutationFuzzer.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/MutationFuzzer.java)
- [RandomFuzzer.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/RandomFuzzer.java)
- [LinuxCommandTest.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/fuzzing/LinuxCommandTest.java)

## Detalle de la implementación

### 1) `Mutator`

En esta clase implementé los tres operadores de mutación básicos sobre cadenas:

1. `deleteRandomCharacter(s)`: elimina un carácter en una posición aleatoria.
2. `insertRandomCharacter(s)`: inserta un carácter aleatorio en una posición arbitraria.
3. `flipRandomCharacter(s)`: reemplaza un carácter aleatorio por otro distinto.

Además implementé el método `mutate(s)`, que selecciona uno de los tres operadores de manera aleatoria y lo aplica sobre la cadena recibida.
También se incorporaron validaciones para entradas `null` y se contempló el manejo de la cadena vacía en aquellas operaciones donde aplicaba (por ejemplo, no se puede borrar ni dar vuelta un carácter de una cadena de longitud cero).

### 2) `MutationFuzzer`

Aquí corregí un bug del constructor original, en el que el parámetro `max_mutations` quedaba mal asignado. A partir de eso, completé el método `fuzz()` siguiendo estos pasos:

1. Selecciona aleatoriamente una semilla a partir de la población inicial de entradas.
2. Determina cuántas mutaciones aplicar, eligiendo un valor entre `min_mutations` y `max_mutations`.
3. Aplica las mutaciones en cadena (cada nueva mutación se hace sobre el resultado de la anterior) y devuelve la cadena final.

Esto permite generar entradas progresivamente más alejadas de las semillas iniciales, lo cual es útil para descubrir caminos del programa que un fuzzer puramente aleatorio difícilmente exploraría.

### 3) `RandomFuzzer`

Implementé el método `fuzz()` para que genere cadenas completamente aleatorias a partir de los siguientes parámetros:

1. Una longitud aleatoria entre `0` y `maxLength`.
2. Caracteres aleatorios dentro del rango definido por `charStart` y `charRange`.

De este modo el fuzzer produce strings sin ningún tipo de estructura previa, lo que sirve como punto de comparación frente al enfoque de mutación.

### 4) `LinuxCommandTest`

Por último, completé el test parametrizado que ejecuta el comando `bc` usando como entrada las cadenas generadas por el fuzzer.

El criterio de validación que adopté está orientado a detectar fallas graves en la ejecución, en lugar de exigir una salida específica:

1. El proceso no debe terminar con códigos de retorno típicos de aborto o segmentation fault (`134`, `139`).
2. La salida estándar de error (`stderr`) no debe contener mensajes asociados a fallas críticas, como:
   - `segmentation fault`
   - `core dumped`
   - `illegal instruction`

Es importante destacar que **no se exige `exitCode == 0`**, ya que es perfectamente esperable que `bc` rechace muchas entradas fuzzed devolviendo errores sintácticos: ese comportamiento corresponde al manejo normal de entradas inválidas y no debería considerarse una falla del programa.

## Verificación

Para validar que la implementación funciona correctamente, ejecuté la suite completa de tests con el siguiente comando:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado obtenido:

- `BUILD SUCCESS`
- `LinuxCommandTest`: **100/100 OK**
- `TriTypTest`: **15/15 OK**

## Cierre

El ejercicio queda resuelto con las tres clases de fuzzing implementadas (`Mutator`, `MutationFuzzer` y `RandomFuzzer`) y un test parametrizado robusto que ejecuta `bc` de forma controlada frente a un volumen significativo de entradas aleatorias y mutadas, sin reportar comportamientos críticos durante la ejecución.
