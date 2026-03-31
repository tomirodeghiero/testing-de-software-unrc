# Ejercicio 4 - Tests para `IPBlacklist.login`

## Enunciado resumido

La clase `IPBlacklist` debe realizar lo siguiente:

1. Guardar el ultimo IP que intento loguearse.
2. Contar intentos fallidos consecutivos del mismo IP.
3. Si el mismo IP falla 3 veces consecutivas, agregarlo a lista negra.

Se pidieron dos verificaciones:

- Luego de 3 intentos fallidos del mismo IP, el IP queda en blacklist.
- Si hay menos de 3 intentos fallidos, el IP no queda en blacklist.

## Implementacion realizada

Archivo de tests:

- `src/test/java/assignment8_exercises/logging/IPBlacklistTest.java`

Se agregaron dos tests con `EasyMock` sobre `LoginService`:

1. `shouldBlacklistIpAfterThreeConsecutiveFailedAttempts`
2. `shouldNotBlacklistIpWhenFailedAttemptsAreLessThanThree`

Detalles:

- Se mockea `service.login(...)` devolviendo `false` las veces necesarias.
- Se invoca `ipblacklist.login(...)` con el mismo IP.
- Se verifica `ipblacklist.blacklisted(ip)` en cada escenario.

## Ejecución

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Djacoco.skip=true -Dtest=IPBlacklistTest test && printf '\n\033[32m[OK] IPBlacklistTest paso correctamente (verde).\033[0m\n'
```

Resultado: tests en verde ejecutados exitosamente.
