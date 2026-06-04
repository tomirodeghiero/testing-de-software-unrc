# Ejercicio 5 — `fail2ban.Server` con Randoop, EvoSuite y jqwik

## (a) `repOK()`

El invariante que implementé en [`Server.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/Server.java) chequea:

- `expirationTime` no nulo y estrictamente mayor a 0.
- `time` no nulo.
- `exceptions` y `bans` no nulos.
- `exceptions.repOK()` y `bans.repOK()` verdaderos.
- Ninguna IP puede estar simultáneamente en `exceptions` y en `bans`.
- Si `lastUpdate != null`, todos los bans deben satisfacer `expires > lastUpdate`.

Además anoté el método con `@CheckRep` para que Randoop lo evalúe durante la generación:

```java
@CheckRep
public boolean repOK() {
    if (expirationTime == null || expirationTime.longValue() <= 0L) return false;
    if (time == null) return false;
    if (exceptions == null || bans == null) return false;
    if (!exceptions.repOK() || !bans.repOK()) return false;

    HashSet<IP> exceptionSet = exceptions.toSet();
    HashSet<IP> banSet = bans.toSet();
    for (IP ip : banSet) {
        if (exceptionSet.contains(ip)) return false;
    }

    if (lastUpdate != null && !bans.greaterThan(lastUpdate)) return false;
    return true;
}
```

También completé los invariantes auxiliares en `SinglyLinkedList.repOK()` y `StrictlySortedSinglyLinkedList.repOK()`. Así, cuando `Server.repOK()` delega en las estructuras internas, la validación se extiende.

## (b) Randoop (30 s): análisis y depuración

Corrida base:

```bash
./gen-randoop.sh assignment8_exercises.fail2ban.Server 30 500 200
```

Resultado: `failing inputs=0`, sin `ErrorTest`, suite de 250 tests.

### Problema observado

La suite inicial incluía aserciones dependientes del tiempo del sistema (por ejemplo, comparaciones contra `lastUpdate` embebidas en `toString()`). Al volver a correrla aparecían fallas intermitentes de regresión — tests *flaky*, no defectos funcionales reales.

### Suite estable

Para sacar ruido y obtener métricas confiables, regeneré con opciones más estrictas:

```bash
java -classpath target/classes:libs/randoop-all-3.0.8.jar randoop.main.Main gentests \
    --testclass=assignment8_exercises.fail2ban.Server \
    --timelimit=30 --outputlimit=500 --testsperfile=200 --small-tests=true \
    --junit-output-dir=src/test/java \
    --junit-package-name=assignment8_exercises.fail2ban \
    --forbid-null=true --null-ratio=0 \
    --npe-on-null-input=INVALID --npe-on-non-null-input=ERROR \
    --no-regression-assertions=true --ignore-flaky-tests=true
```

Resultado: `failing inputs=0`, sin `ErrorTest`, `RegressionTest` con 174 tests correctos.

### Defectos corregidos durante la depuración

Archivos modificados:

- [`Server.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/Server.java)
- [`SinglyLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/SinglyLinkedList.java)
- [`StrictlySortedSinglyLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/StrictlySortedSinglyLinkedList.java)

Cambios principales:

- Corrección en `SinglyLinkedList.remove(...)`: eliminación correcta y decremento de `size`.
- Validaciones de `null` en operaciones públicas para evitar NPEs innecesarios.
- `StrictlySortedSinglyLinkedList.removeFromIP(...)` ahora devuelve `false` cuando no elimina nada.
- Mejoras de robustez en recorridos e inserciones.

### Métricas Randoop

**Cobertura de ramas (JaCoCo) sobre `Server`**:

- Cubiertas: 2
- Totales: 52
- **Branch Coverage: 3,85 %**

**Mutación (PIT)**:

- Mutantes generados: 54
- Mutantes muertos: 2
- **Mutation score: 4 %**
- Mutantes sin cobertura: 50

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q \
    -DtargetClasses=assignment8_exercises.fail2ban.Server \
    -DtargetTests=assignment8_exercises.fail2ban.RegressionTest \
    org.pitest:pitest-maven:mutationCoverage
```

## (c) EvoSuite (30 s)

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    ./gen-evo.sh assignment8_exercises.fail2ban.Server 30
```

Resultados reportados por EvoSuite:

- Tests generados: 30
- Longitud total: 111
- Cobertura promedio: **89 %**
- **Branch coverage: 89 %** (48/54)
- **Weak mutation coverage: 92 %** (65/71)
- **Mutation score: 72 %**

EvoSuite también generó `Server_Failed_ESTest`, una suite con escenarios que rompen el estado interno (por ejemplo, dejando `bans = null` desde un test dentro del mismo paquete) y disparan excepciones no declaradas.

### Comparación

| | Randoop | EvoSuite |
|---|---|---|
| Branch coverage | 3,85 % | 89 % |
| Mutation score | 4 % (PIT) | 72 % (métrica propia) |

EvoSuite ejercita la lógica de `Server` mucho más efectivamente. La diferencia se explica porque su generación guiada por cobertura construye secuencias que llegan a ramas profundas, mientras que Randoop se queda en configuraciones superficiales.

## (d) ¿`repOK()` para depurar con EvoSuite?

**Sí**, pero de manera distinta a Randoop:

- **Randoop** consume directamente la anotación `@CheckRep` y evalúa el invariante durante la generación.
- **EvoSuite** no la toma automáticamente. En su caso, `repOK()` se usa como oráculo explícito: o se agregan aserciones a los tests generados, o se envuelven las operaciones para invocarlo.

`repOK()` sigue siendo una herramienta útil para detectar estados inválidos y guiar la depuración con EvoSuite, solo que su integración requiere un paso manual adicional.

## (e) Propiedad jqwik sobre `update`

La propiedad `updateRemovesExactlyExpiredBans` verifica que:

- después de `update()`, cada IP queda correctamente permitida o bloqueada según su expiración,
- y el estado final del servidor sigue cumpliendo `repOK()`.

Uso **un único generador**, como pedía la consigna: `updateScenarios()` produce un escenario completo (`UpdateScenario`) con una lista de IPs únicas, un tiempo inicial y un tiempo transcurrido.

```java
@Property(tries = 100)
void updateRemovesExactlyExpiredBans(@ForAll("updateScenarios") UpdateScenario scenario) {
    Server server = new Server();
    MutableTime time = new MutableTime(scenario.startTime);
    server.setTime(time);

    long[] expires = new long[scenario.ips.size()];
    for (int i = 0; i < scenario.ips.size(); i++) {
        IP ip = scenario.ips.get(i);
        boolean added = server.addBan(ip);
        Assertions.assertTrue(added);
        expires[i] = time.getCurrentTime() + BAN_WINDOW_MS;
        time.setNow(time.getCurrentTime() + 1L);
    }

    long nowAtUpdate = scenario.startTime + scenario.ips.size() + scenario.elapsed;
    time.setNow(nowAtUpdate);
    server.update();

    for (int i = 0; i < scenario.ips.size(); i++) {
        IP ip = scenario.ips.get(i);
        boolean banStillActive = expires[i] > nowAtUpdate;
        boolean expectedConnection = !banStillActive;
        Assertions.assertEquals(expectedConnection, server.connect(ip));
    }

    Assertions.assertTrue(server.repOK());
}
```

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -Djacoco.skip=true \
    -Dtest=assignment8_exercises.fail2ban.ServerPropertyTest test
```

Cabe destacar que la propiedad pasa en todas las ejecuciones.

## Archivos

- [`Server.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/Server.java) — `repOK()`, `update`, anotado con `@CheckRep`.
- [`SinglyLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/SinglyLinkedList.java)
- [`StrictlySortedSinglyLinkedList.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fail2ban/StrictlySortedSinglyLinkedList.java)
- [`ServerPropertyTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fail2ban/ServerPropertyTest.java) — propiedad jqwik con un único generador.
- [`Server_ESTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fail2ban/Server_ESTest.java) — suite generada por EvoSuite.
- [`RegressionTest0.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fail2ban/RegressionTest0.java) — suite estable de Randoop.

## Enlaces

- Enunciado: [`practico8.pdf`](/pdfs/tp8/practico8.pdf)
- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)
