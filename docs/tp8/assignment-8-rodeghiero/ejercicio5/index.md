---
title: "Ejercicio 5"
sidebar_position: 5
slug: "/tp8/assignment-8-rodeghiero/ejercicio5/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio5/README.md"
---

# Ejercicio 5 - `fail2ban.Server` con Randoop, EvoSuite y jqwik

## Objetivo

Resolver el ejercicio sobre `assignment8_exercises.fail2ban.Server`:

1. Implementar `repOK()`.
2. Generar tests con Randoop (30s), analizar salidas y depurar.
3. Generar tests con EvoSuite (30s), analizar y comparar.
4. Explicar como usar `repOK()` para depurar con EvoSuite.
5. Escribir una propiedad con jqwik para `update` usando un solo generador.

## a) Implementacion de `repOK()`

Se implemento `repOK()` en el archivo:

- `src/main/java/assignment8_exercises/fail2ban/Server.java`

Validaciones incluidas:

- `expirationTime` no nulo y mayor a 0.
- `time` no nulo.
- `exceptions` y `bans` no nulos.
- `exceptions.repOK()` y `bans.repOK()` verdaderos.
- Ninguna IP puede estar al mismo tiempo en `exceptions` y en `bans`.
- Si `lastUpdate != null`, todos los bans deben cumplir `expires > lastUpdate`.

Además, se agrego `@CheckRep` para que Randoop use el invariante durante la generacion.

Tambien se completaron invariantes auxiliares en:

- `SinglyLinkedList.repOK()`
- `StrictlySortedSinglyLinkedList.repOK()`

## b) Randoop (30s): analisis, debugging y mediciones

### Corrida base

```bash
./gen-randoop.sh assignment8_exercises.fail2ban.Server 30 500 200
```

Resultado:

- `failing inputs=0`
- no se genero `ErrorTest`
- se genero una suite de regresion de 250 tests

### Problema observado

Esa suite trae aserciones sensibles al tiempo del sistema (`lastUpdate` en `toString()`), por eso al ejecutar aparecen fallas intermitentes de regresion (flaky), no defectos funcionales reales.

### Suite estable para ejecucion y metricas

Se regenero con opciones para evitar ese ruido:

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

### Defectos corregidos durante depuracion

Archivos modificados:

- `src/main/java/assignment8_exercises/fail2ban/Server.java`
- `src/main/java/assignment8_exercises/fail2ban/SinglyLinkedList.java`
- `src/main/java/assignment8_exercises/fail2ban/StrictlySortedSinglyLinkedList.java`

Cambios principales:

- Fix en `SinglyLinkedList.remove(...)` (eliminacion correcta + `size--`).
- Validaciones de `null` en operaciones publicas para evitar NPE que eran evitables.
- `StrictlySortedSinglyLinkedList.removeFromIP(...)` ahora devuelve `false` si no elimina.
- Mejoras de robustez en recorridos/inserciones de listas.

### Cobertura de ramas (Randoop)

Sobre `Server` con JaCoCo:

- ramas cubiertas: 2
- ramas totales: 52
- **Branch Coverage: 3.85%**

### Mutación (Randoop)

Con PIT sobre `Server` y suite Randoop estable:

- mutantes generados: 54
- mutantes muertos: 2
- **Mutation score: 4%**
- mutantes sin cobertura: 50

Comando usado:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q \
  -DtargetClasses=assignment8_exercises.fail2ban.Server \
  -DtargetTests=assignment8_exercises.fail2ban.RegressionTest \
  org.pitest:pitest-maven:mutationCoverage
```

## c) EvoSuite (30s): analisis y comparacion con Randoop

Generación con Java 11:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
./gen-evo.sh assignment8_exercises.fail2ban.Server 30
```

Resultados reportados por EvoSuite:

- tests generados: 30
- longitud total: 111
- cobertura promedio: 89%
- **Branch coverage: 89%** (48/54)
- **Weak mutation coverage: 92%** (65/71)
- **Mutation score: 72%**

EvoSuite tambien genero `Server_Failed_ESTest` con escenarios que rompen el estado interno (por ejemplo dejar `bans = null` desde test en la misma package), lo cual dispara excepciones no declaradas.

### Comparacion breve

- Branches: Randoop 3.85% vs EvoSuite 89%
- Mutacion: Randoop 4% (PIT) vs EvoSuite 72% (reporte EvoSuite)

En este caso, EvoSuite ejercita mejor la logica de `Server`.

## d) ¿Se puede usar `repOK()` para depurar con EvoSuite?

Si, pero de forma distinta a Randoop:

- Randoop usa `@CheckRep` directamente durante la generacion.
- EvoSuite no lo toma automaticamente igual; `repOK()` se usa como oraculo explicito (por ejemplo, agregando aserciones o wrappers que lo invoquen).

Conclusion: `repOK()` sigue siendo muy util para detectar estados invalidos y guiar la depuracion, tambien con EvoSuite.

## e) Propiedad jqwik sobre `update`

Se agrego:

- `src/test/java/assignment8_exercises/fail2ban/ServerPropertyTest.java`

Propiedad:

- `updateRemovesExactlyExpiredBans`

Que verifica:

- despues de `update()`, cada IP queda permitida o bloqueada segun su expiracion,
- y el estado final mantiene `repOK()`.

Generador (uno solo):

- `@Provide updateScenarios()`
- genera un escenario completo (`UpdateScenario`) con lista de IPs unicas, tiempo inicial y tiempo transcurrido.

Ejecucion:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q -Djacoco.skip=true -Dtest=assignment8_exercises.fail2ban.ServerPropertyTest test
```

Resultado: property test en verde.

## Resumen final

- `repOK()` implementado y usado en el flujo de testing automatico.
- Se corrigieron defectos funcionales y de robustez en `Server` y listas auxiliares.
- Randoop permitio detectar y depurar, pero tuvo baja cobertura/mutacion en esta clase.
- EvoSuite logro mejor exploracion de ramas y mejor score de mutacion.
- Se completo la parte de testing basado en propiedades con jqwik para `update`.
