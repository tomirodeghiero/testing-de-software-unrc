# Ejercicio 4 — `IPBlacklist.login` con EasyMock

[`IPBlacklist`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/logging/IPBlacklist.java) tiene que cumplir tres responsabilidades:

1. registrar el último IP que intentó loguearse,
2. contar los intentos fallidos consecutivos provenientes de ese IP,
3. agregar el IP a la lista negra cuando acumule 3 intentos fallidos consecutivos.

Sobre eso se piden dos verificaciones puntuales:

- Después de 3 intentos fallidos del mismo IP, el IP queda en blacklist.
- Si los intentos fallidos son menos de 3, el IP no queda en blacklist.

## Por qué uso mocks

`IPBlacklist.login(...)` depende internamente de un `LoginService.login(ip, user, passwordHash)` que típicamente consulta un sistema externo. Para los tests no queremos depender de ese servicio real: lo que queremos es **controlar** qué devuelve y verificar la lógica de blacklisting que está adentro de `IPBlacklist`.

Con **EasyMock** se crea un doble del `LoginService` y se programa qué responder a cada llamada. Eso aísla la lógica bajo prueba.

## Tests

```java
@Test
public void shouldBlacklistIpAfterThreeConsecutiveFailedAttempts() {
    String ip = "192.168.0.10";
    String user = "usuario";
    String password = "clave";
    String passwordHash = Utils.getPasswordHashMD5(password);

    expect(service.login(ip, user, passwordHash)).andReturn(false).times(3);
    replay(service);

    assertFalse(ipblacklist.login(ip, user, password));
    assertFalse(ipblacklist.login(ip, user, password));
    assertFalse(ipblacklist.login(ip, user, password));

    assertTrue(ipblacklist.blacklisted(ip));
    verify(service);
}

@Test
public void shouldNotBlacklistIpWhenFailedAttemptsAreLessThanThree() {
    String ip = "192.168.0.20";
    String user = "usuario";
    String password = "clave";
    String passwordHash = Utils.getPasswordHashMD5(password);

    expect(service.login(ip, user, passwordHash)).andReturn(false).times(2);
    replay(service);

    assertFalse(ipblacklist.login(ip, user, password));
    assertFalse(ipblacklist.login(ip, user, password));

    assertFalse(ipblacklist.blacklisted(ip));
    verify(service);
}
```

Esquema de cada test:

1. **`expect(...).andReturn(false).times(N)`** programa el mock para devolver `false` en las `N` invocaciones siguientes.
2. **`replay(service)`** cambia al modo "ejecución" — a partir de ahora el mock acepta las llamadas según lo programado.
3. Se invoca `ipblacklist.login(ip, user, password)` con el mismo IP las veces necesarias.
4. Se verifica `ipblacklist.blacklisted(ip)`: debe ser `true` si hubo 3 fallos, `false` si hubo menos.
5. **`verify(service)`** confirma que el mock recibió exactamente las llamadas esperadas.

## Ejecución

```bash
cd tp8/assignment-8-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Djacoco.skip=true -Dtest=IPBlacklistTest test
```

El resultado es que los dos tests pasan exitosamente.

## Archivos

- [`IPBlacklist.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/logging/IPBlacklist.java) — lógica de blacklisting.
- [`LoginService.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/logging/LoginService.java) — interfaz que se mockea.
- [`IPBlacklistTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/logging/IPBlacklistTest.java) — los dos tests con EasyMock.

## Enlaces

- Enunciado: [`practico8.pdf`](/pdfs/tp8/practico8.pdf)
- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)
