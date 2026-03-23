# Ejercicio 5

En este ejercicio hice tests parametrizados para `ZuneBug.currentYear(int days)`
y, como aparecieron fallas, hice debugging y correccion del metodo.

## Archivos

- `../src/test/java/assignment2_exercises/ZuneBugParameterizedTest.java`
- `../src/main/java/assignment2_exercises/ZuneBug.java`
- `currentYear_original.java.txt` (version original, antes de corregir)

## Que cubren los tests

Agregue dos tests parametrizados:

- casos de borde (por ejemplo `365`, `366`, `367`, `731`, `1461`)
- varios valores para comparar `currentYear` contra `oracle`

Tambien use `assertTimeoutPreemptively` para detectar cuelgues.

## Que fallo durante las pruebas

Antes de corregir, aparecieron dos problemas:

- Con `days = 366` el metodo podia quedar en loop infinito.
- En cambios exactos de año (por ejemplo `731` y `1461`) devolvia un año menos.

## Causa del defecto

La logica original mezclaba condiciones `> 365` y `> 366`.
Eso dejaba mal tratados los limites exactos de cada año.

## Correccion aplicada

Reescribi el bucle para trabajar con `daysInYear` del año actual:

- si `days >= daysInYear`, se descuenta ese año y se avanza
- si no, se corta el bucle y se devuelve el año actual

Con esto se arreglan tanto el loop infinito como el off-by-one en los bordes.

## Como correr solo este ejercicio

Desde `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=ZuneBugParameterizedTest test
```

Resultado luego de la correccion:

- `Tests run: 21, Failures: 0, Errors: 0`
- `BUILD SUCCESS`
