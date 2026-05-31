# Ejercicio 3 — Fuzzing: `Mutator`, `MutationFuzzer`, `RandomFuzzer` y `bc`

Completar la parte de fuzzing del template: implementar `Mutator`, `MutationFuzzer` y `RandomFuzzer`, y cerrar el test parametrizado que ejecuta `bc` sobre entradas generadas por fuzzing.

## 1) `Mutator`

Tres operadores básicos de mutación sobre strings:

- `deleteRandomCharacter(s)` — borra un carácter en posición aleatoria.
- `insertRandomCharacter(s)` — inserta un carácter ASCII aleatorio en una posición aleatoria.
- `flipRandomCharacter(s)` — selecciona un carácter al azar y le da vuelta uno de los 7 bits bajos.

Más el método `mutate(s)`, que elige uno de los tres con probabilidad uniforme:

```java
public static String mutate(String s) {
    if (s == null) {
        throw new IllegalArgumentException("Input string cannot be null");
    }
    int choice = RANDOM.nextInt(3);
    switch (choice) {
        case 0:  return deleteRandomCharacter(s);
        case 1:  return insertRandomCharacter(s);
        default: return flipRandomCharacter(s);
    }
}
```

Las tres operaciones validan `null` y manejan el caso de string vacío donde corresponde (no se puede borrar ni flippear un carácter de una cadena de longitud 0).

## 2) `MutationFuzzer`

Corregí un bug del constructor (el parámetro `max_mutations` quedaba mal asignado) y completé `fuzz()`:

1. elige aleatoriamente una semilla de la población inicial,
2. determina cuántas mutaciones aplicar entre `min_mutations` y `max_mutations`,
3. aplica las mutaciones en cadena (cada nueva mutación sobre el resultado de la anterior) y devuelve la cadena final.

```java
public String fuzz() {
    String candidate = population.get(random.nextInt(population.size()));
    int mutations = min_mutations;
    if (max_mutations > min_mutations) {
        mutations += random.nextInt((max_mutations - min_mutations) + 1);
    }
    for (int i = 0; i < mutations; i++) {
        candidate = Mutator.mutate(candidate);
    }
    return candidate;
}
```

Así se generan entradas progresivamente más alejadas de las semillas, lo que ayuda a explorar caminos que un fuzzer puramente aleatorio difícilmente alcanzaría.

## 3) `RandomFuzzer`

`fuzz()` genera cadenas completamente aleatorias:

1. una longitud aleatoria entre `0` y `maxLength`,
2. cada carácter elegido en el rango `[charStart, charStart + charRange)`.

Sin estructura previa. Sirve como contrapunto al fuzzer por mutación.

## 4) `LinuxCommandTest`

Test parametrizado que corre `bc` con cadenas generadas por el `MutationFuzzer`. La semilla inicial es `"2 + 2"` y se hacen 100 trials.

El criterio de validación está orientado a detectar fallas **graves**, no a esperar una salida específica:

- el proceso no debe terminar con códigos típicos de aborto o segfault (`134`, `139`);
- `stderr` no debe contener `segmentation fault`, `core dumped` ni `illegal instruction`.

**Importante**: no se exige `exitCode == 0`. Es esperable que `bc` rechace muchas entradas fuzzed con errores sintácticos — ese comportamiento es manejo normal de entradas inválidas, no una falla del programa.

```java
assertNotEquals(134, exitCode); // abort
assertNotEquals(139, exitCode); // segfault
String stderrLower = stderr.toString().toLowerCase();
assertFalse(stderrLower.contains("segmentation fault"));
assertFalse(stderrLower.contains("core dumped"));
assertFalse(stderrLower.contains("illegal instruction"));
```

## Verificación

```bash
cd tp6/assignment-6-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado:

- `BUILD SUCCESS`
- `LinuxCommandTest`: **100/100 OK**
- `TriTypTest`: **15/15 OK**

## Archivos

- [`Mutator.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/Mutator.java)
- [`MutationFuzzer.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/MutationFuzzer.java)
- [`RandomFuzzer.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/RandomFuzzer.java)
- [`LinuxCommandTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp6/assignment-6-rodeghiero/src/test/java/assignment6_exercises/fuzzing/LinuxCommandTest.java)

## Enlaces

- Enunciado: [`practico6.pdf`](/pdfs/tp6/practico6.pdf)
- Resolución: [`resolucion_practico6.pdf`](/pdfs/tp6/resolucion_practico6.pdf)
