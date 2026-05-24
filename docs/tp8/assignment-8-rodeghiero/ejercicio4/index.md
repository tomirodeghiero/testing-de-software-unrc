---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp8/assignment-8-rodeghiero/ejercicio4/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio4/README.md"
---

# Ejercicio 4 - Tests para `IPBlacklist.login`

## Enunciado resumido

La clase `IPBlacklist` debe cumplir con las siguientes responsabilidades:

1. Registrar el último IP que intentó loguearse.
2. Contar los intentos fallidos consecutivos provenientes de ese mismo IP.
3. Agregar el IP a la lista negra cuando acumule 3 intentos fallidos consecutivos.

Sobre ese comportamiento se pidieron dos verificaciones puntuales:

- Después de 3 intentos fallidos del mismo IP, el IP queda efectivamente en blacklist.
- Si los intentos fallidos son menos de 3, el IP no queda en blacklist.

## Implementación realizada

El archivo de tests correspondiente es:

- `src/test/java/assignment8_exercises/logging/IPBlacklistTest.java`

Allí se agregaron dos tests que usan `EasyMock` para simular el `LoginService`, de manera de poder controlar con precisión los valores que devuelve `login(...)`:

1. `shouldBlacklistIpAfterThreeConsecutiveFailedAttempts`
2. `shouldNotBlacklistIpWhenFailedAttemptsAreLessThanThree`

El esquema de cada test es el siguiente:

- Se configura el mock de `service.login(...)` para que devuelva `false` la cantidad de veces necesaria según el escenario.
- Se invoca `ipblacklist.login(...)` con el mismo IP para simular intentos consecutivos.
- Finalmente, se verifica `ipblacklist.blacklisted(ip)` para chequear si el IP quedó o no en la lista negra.

Este uso de mocks permite aislar la lógica de `IPBlacklist` del comportamiento real del servicio de autenticación, lo cual es justamente el punto que se quería ejercitar.

## Ejecución

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Djacoco.skip=true -Dtest=IPBlacklistTest test && printf '\n\033[32m[OK] IPBlacklistTest paso correctamente (verde).\033[0m\n'
```

Resultado: ambos tests pasaron correctamente, quedando la suite en verde.
