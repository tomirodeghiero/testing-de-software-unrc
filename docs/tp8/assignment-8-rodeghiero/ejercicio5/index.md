---
title: "Ejercicio 5"
sidebar_position: 5
slug: "/tp8/assignment-8-rodeghiero/ejercicio5/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio5/README.md"
---

# Ejercicio 5 - `fail2ban.Server` con Randoop, EvoSuite y jqwik

## Objetivo

Este ejercicio integra varias de las técnicas vistas en la materia sobre la clase `assignment8_exercises.fail2ban.Server`. Las tareas solicitadas son:

1. Implementar `repOK()`.
2. Generar tests con Randoop (30s), analizar las salidas y depurar en base a ellas.
3. Generar tests con EvoSuite (30s), analizar los resultados y compararlos con los de Randoop.
4. Explicar cómo se puede aprovechar `repOK()` para depurar con EvoSuite.
5. Escribir una propiedad con jqwik para `update` utilizando un único generador.

## a) Implementación de `repOK()`

El invariante se implementó en:

- `src/main/java/assignment8_exercises/fail2ban/Server.java`

Las validaciones incluidas son:

- `expirationTime` no nulo y estrictamente mayor a 0.
- `time` no nulo.
- `exceptions` y `bans` no nulos.
- `exceptions.repOK()` y `bans.repOK()` verdaderos.
- Ninguna IP puede estar simultáneamente en `exceptions` y en `bans`.
- Si `lastUpdate != null`, entonces todos los bans deben satisfacer `expires > lastUpdate`.

Además se anotó el método con `@CheckRep` para que Randoop lo evalúe como invariante durante la generación. Complementariamente, se completaron los invariantes auxiliares en:

- `SinglyLinkedList.repOK()`
- `StrictlySortedSinglyLinkedList.repOK()`

De este modo, cuando `Server.repOK()` delega en las estructuras internas, la validación se extiende también a ellas.

## b) Randoop (30s): análisis, debugging y mediciones

### Corrida base

```bash
./gen-randoop.sh assignment8_exercises.fail2ban.Server 30 500 200
```

Resultado:

- `failing inputs=0`
- no se generó `ErrorTest`
- se obtuvo una suite de regresión de 250 tests

### Problema observado

La suite inicial incluía aserciones dependientes del tiempo del sistema (por ejemplo, comparaciones contra `lastUpdate` embebidas en `toString()`). Esto hace que al volver a ejecutarla aparezcan fallas intermitentes de regresión, es decir, tests flaky más que defectos funcionales reales.

### Suite estable para ejecución y métricas

Para evitar ese ruido y obtener métricas confiables, se regeneró la suite con opciones más estrictas:

```bash
java -classpath target/classes:libs/randoop-all-3.0.8.jar randoop.main.Main gentests \
  --testclass=assignment8_exercises.fail2ban.Server \
  --timelimit=30 --outputlimit=500 --testsperfile=200 --small-tests=true \
  --junit-output-dir=src/test/java --junit-package-name=assignment8_exercises.fail2ban \
  --forbid-null=true --null-ratio=0 \
  --npe-on-null-input=INVALID --npe-on-non-null-input=ERROR \
  --no-regression-assertions=true --ignore-flaky-tests=true
```

Resultado:

- `failing inputs=0`
- sin `ErrorTest`
- `RegressionTest`: 174 tests en verde

Ejecución:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q -Djacoco.skip=true -Dtest=assignment8_exercises.fail2ban.RegressionTest test
```

### Defectos corregidos durante la depuración

Archivos modificados:

- `src/main/java/assignment8_exercises/fail2ban/Server.java`
- `src/main/java/assignment8_exercises/fail2ban/SinglyLinkedList.java`
- `src/main/java/assignment8_exercises/fail2ban/StrictlySortedSinglyLinkedList.java`

Los cambios principales fueron:

- Corrección en `SinglyLinkedList.remove(...)`, asegurando la eliminación correcta y el decremento de `size`.
- Validaciones de `null` en las operaciones públicas para evitar NPEs que resultaban innecesarios.
- `StrictlySortedSinglyLinkedList.removeFromIP(...)` ahora devuelve `false` cuando no elimina ningún elemento.
- Mejoras generales de robustez en los recorridos e inserciones sobre las listas.

### Cobertura de ramas (Randoop)

Medición con JaCoCo sobre `Server`:

- Ramas cubiertas: 2
- Ramas totales: 52
- **Branch Coverage: 3,85%**

### Mutación (Randoop)

Ejecución de PIT sobre `Server` con la suite Randoop estable:

- Mutantes generados: 54
- Mutantes muertos: 2
- **Mutation score: 4%**
- Mutantes sin cobertura: 50

Comando utilizado:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q \
  -DtargetClasses=assignment8_exercises.fail2ban.Server \
  -DtargetTests=assignment8_exercises.fail2ban.RegressionTest \
  org.pitest:pitest-maven:mutationCoverage
```

## c) EvoSuite (30s): análisis y comparación con Randoop

Generación con Java 11:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
./gen-evo.sh assignment8_exercises.fail2ban.Server 30
```

Resultados reportados por EvoSuite:

- Tests generados: 30
- Longitud total: 111
- Cobertura promedio: 89%
- **Branch coverage: 89%** (48/54)
- **Weak mutation coverage: 92%** (65/71)
- **Mutation score: 72%**

EvoSuite también generó `Server_Failed_ESTest`, una suite con escenarios que rompen el estado interno (por ejemplo, dejando `bans = null` desde un test dentro del mismo paquete) y disparan excepciones no declaradas.

### Comparación breve

- Branches: Randoop 3,85% vs EvoSuite 89%.
- Mutación: Randoop 4% (medido con PIT) vs EvoSuite 72% (métrica propia).

En este caso, EvoSuite ejercita de forma mucho más efectiva la lógica de `Server`. La diferencia se explica porque su generación guiada por cobertura logra construir secuencias que efectivamente llegan a ramas profundas, mientras que Randoop se queda en configuraciones superficiales.

## d) ¿Se puede usar `repOK()` para depurar con EvoSuite?

Sí, aunque de manera distinta a como se usa con Randoop:

- Randoop consume directamente la anotación `@CheckRep` y evalúa el invariante durante la generación.
- EvoSuite no la toma de forma automática: en su caso, `repOK()` se usa como oráculo explícito, típicamente agregando aserciones en los tests generados o envolviendo las operaciones para invocarlo.

Conclusión: `repOK()` sigue siendo una herramienta muy útil para detectar estados inválidos y guiar la depuración también en el flujo con EvoSuite, solo que su integración requiere un paso manual adicional.

## e) Propiedad jqwik sobre `update`

Se agregó el archivo:

- `src/test/java/assignment8_exercises/fail2ban/ServerPropertyTest.java`

La propiedad implementada es:

- `updateRemovesExactlyExpiredBans`

Verifica que:

- después de ejecutar `update()`, cada IP queda correctamente permitida o bloqueada según su expiración,
- y el estado final del servidor sigue cumpliendo `repOK()`.

Se utiliza un único generador, como pedía el enunciado:

- `@Provide updateScenarios()`
- produce un escenario completo (`UpdateScenario`) compuesto por una lista de IPs únicas, un tiempo inicial y un tiempo transcurrido.

De esta forma, jqwik puede explorar combinaciones variadas de entradas sin que el test dependa de múltiples generadores independientes.

Ejecución:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q -Djacoco.skip=true -Dtest=assignment8_exercises.fail2ban.ServerPropertyTest test
```

Resultado: la propiedad se cumple en todas las ejecuciones; el test queda en verde.

## Resumen final

- `repOK()` quedó implementado y efectivamente incorporado al flujo de testing automático.
- Durante la depuración con Randoop se corrigieron defectos funcionales y de robustez tanto en `Server` como en las listas auxiliares.
- Randoop permitió detectar y depurar problemas, pero alcanzó baja cobertura y un mutation score pobre en esta clase.
- EvoSuite logró una mejor exploración de ramas y un mutation score claramente superior.
- La parte de property-based testing se completó con una propiedad jqwik para `update` apoyada en un único generador.
