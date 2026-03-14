# Ejercicio 3

Esta carpeta contiene una resolucion completa del ejercicio 3 con:

- las versiones defectuosas de los cuatro programas
- las versiones corregidas
- un runner por consola para ejecutar los casos del ejercicio sobre la version fallada o la version corregida

## Archivos

- `DefectivePrograms.java`: replica los cuatro programas tal como aparecen en el enunciado
- `FixedPrograms.java`: contiene una correccion posible para cada programa
- `Exercise3Runner.java`: ejecuta casos representativos para los puntos b), c) y d)

## Comandos para compilar y ejecutar

Desde esta carpeta:

```bash
cd tp1/ejercicio3
javac *.java
```

Ejecutar todos los programas en su version fallada:

```bash
java Exercise3Runner faulty all
```

Ejecutar todos los programas en su version corregida:

```bash
java Exercise3Runner fixed all
```

Ejecutar un programa puntual:

```bash
java Exercise3Runner faulty findLast
java Exercise3Runner fixed findLast
java Exercise3Runner faulty lastZero
java Exercise3Runner fixed lastZero
java Exercise3Runner faulty countPositive
java Exercise3Runner fixed countPositive
java Exercise3Runner faulty oddOrPos
java Exercise3Runner fixed oddOrPos
```

## Resolucion

### 1. `findLast(int[] x, int y)`

#### a) Defecto y correccion

El defecto esta en la condicion del `for`:

```java
for (int i = x.length - 1; i > 0; i--)
```

El ciclo deberia seguir mientras `i >= 0`, no mientras `i > 0`. Tal como esta escrito, nunca revisa la posicion `0` del arreglo.

Correccion:

```java
for (int i = x.length - 1; i >= 0; i--)
```

#### b) Caso que no ejecute el defecto

No se puede, al menos usando entradas validas. El defecto esta en la condicion del `for`, y esa condicion se evalua siempre que se llama al metodo. Lo que si puede pasar es que el defecto se ejecute pero no se note, si justo no hace falta revisar la posicion `0`.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [5, 2, 3], y = 2
resultado esperado = 1
```

El defecto se ejecuta, pero como el valor buscado no esta en la posicion `0`, el resultado sigue siendo correcto.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [2, 3, 5], y = 2
resultado esperado = 0
resultado defectuoso = -1
```

Falla porque el programa no revisa la posicion `0`.

### 2. `lastZero(int[] x)`

#### a) Defecto y correccion

El defecto es conceptual: el metodo debe devolver el ultimo indice cuyo valor es `0`, pero recorre el arreglo de izquierda a derecha y retorna apenas encuentra el primer cero.

Codigo defectuoso:

```java
for (int i = 0; i < x.length; i++) {
    if (x[i] == 0) {
        return i;
    }
}
```

Una correccion simple es recorrer desde el final:

```java
for (int i = x.length - 1; i >= 0; i--) {
    if (x[i] == 0) {
        return i;
    }
}
```

#### b) Caso que no ejecute el defecto

Para arreglos no nulos, no es posible. La estrategia defectuosa de recorrer desde el inicio siempre se utiliza.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [1, 0, 2]
resultado esperado = 1
```

El metodo esta mal, pero como solo hay un cero, el primer cero coincide con el ultimo.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [0, 1, 0]
resultado esperado = 2
resultado defectuoso = 0
```

Falla porque devuelve el primer cero, no el ultimo.

### 3. `countPositive(int[] x)`

#### a) Defecto y correccion

El comentario indica que debe contar elementos positivos, pero el codigo cuenta elementos mayores o iguales que cero:

```java
if (x[i] >= 0) {
    count++;
}
```

Eso incluye al `0`, que no es positivo.

Correccion:

```java
if (x[i] > 0) {
    count++;
}
```

#### b) Caso que no ejecute el defecto

```text
x = []
resultado esperado = 0
```

Como el arreglo esta vacio, no entra al cuerpo del `for` y la condicion defectuosa no se evalua.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [-4, 2, 2]
resultado esperado = 2
```

La condicion defectuosa se ejecuta, pero como no hay ceros, contar `>= 0` o `> 0` da el mismo resultado.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [-4, 2, 0, 2]
resultado esperado = 2
resultado defectuoso = 3
```

Falla porque el `0` se cuenta como positivo.

### 4. `oddOrPos(int[] x)`

#### a) Defecto y correccion

El metodo debe contar valores impares o positivos. El defecto esta en usar:

```java
x[i] % 2 == 1
```

En Java, los impares negativos no cumplen esa condicion. Por ejemplo:

```text
-3 % 2 == -1
```

Por eso los impares negativos quedan afuera aunque deberian contarse.

Una correccion simple es:

```java
if (x[i] % 2 != 0 || x[i] > 0) {
    count++;
}
```

#### b) Caso que no ejecute el defecto

```text
x = []
resultado esperado = 0
```

El cuerpo del `for` no se ejecuta.

#### c) Caso que ejecute el defecto y no produzca falla

```text
x = [2, 4, -2]
resultado esperado = 2
```

El defecto se ejecuta, pero no hay impares negativos. Entonces el resultado coincide con el esperado.

#### d) Caso que ejecute el defecto y produzca falla

```text
x = [-3, -2, 0, 1, 4]
resultado esperado = 3
resultado defectuoso = 2
```

Los valores que deberian contarse son `-3`, `1` y `4`, pero el programa defectuoso no cuenta `-3`.

## Resumen corto

- `findLast`: no revisa el indice `0`
- `lastZero`: devuelve el primer cero en vez del ultimo
- `countPositive`: cuenta `0` como positivo
- `oddOrPos`: no reconoce impares negativos
