# Ejercicio 2

## Cual es la diferencia entre defecto (`fault`) y falla (`failure`)?

La diferencia principal es que un **defecto** es la causa interna del problema en el software, mientras que una **falla** es la manifestacion externa de ese problema cuando el sistema se ejecuta.

Conceptualmente:

- **Fault**: un defecto estatico en el software.
- **Error**: un estado interno incorrecto que resulta de un defecto.
- **Failure**: un comportamiento externo incorrecto con respecto a los requisitos o al comportamiento esperado.

### Diferencia central

Un **defecto** (`fault`) existe dentro del programa aunque nadie lo esté ejecutando. Es un problema en el código, en el diseño o en la especificacion. Por eso se lo conoce como un defecto **estático**.

Una **falla** (`failure`), en cambio, solo aparece cuando el programa se ejecuta y el usuario o el entorno pueden observar un comportamiento incorrecto. Por eso la falla es algo **externo y visible**.

En forma directa:

- El `fault` es la **causa**.
- La `failure` es la **consecuencia observable**.

### Relacion entre fault, error y failure

No solo existen los términos de `fault` y `failure`, sino que existe un concepto intermedio: el **error**.

La relacion es esta:

`fault -> error -> failure`

Esto significa:

1. Hay un **fault** en el software.
2. Cuando ese defecto se ejecuta, puede producir un **error**, es decir, un estado interno incorrecto.
3. Si ese error se propaga hasta la salida o hasta el comportamiento visible del sistema, entonces ocurre una **failure**.

Esta distincion es importante porque **no todo defecto produce una falla en todas las ejecuciones**. Un defecto puede existir y hasta ser ejecutado, pero si el estado erroneo no afecta el resultado visible, entonces no se observa una falla.

### Ejemplo

Supongamos un método que busca ceros en un arreglo, pero comienza a recorrerlo desde el indice `1` en lugar de `0`. Ahí existe un **fault**: el programa fue escrito con un defecto.

Cuando el metodo se ejecuta, ese defecto genera un **error** en el estado interno del programa, porque la ejecucion no esta avanzando como deberia.

Sin embargo, pueden pasar dos cosas:

- Si para una entrada dada el resultado final coincide igual con el esperado, entonces hay defecto y hay error interno, pero **no hay falla visible**.
- Si para otra entrada ese error interno llega al valor devuelto o al comportamiento observable, entonces si aparece una **failure**.

O sea, la falla no se identifica solo porque el programa tenga un defecto, sino porque ese defecto finalmente produce un comportamiento incorrecto hacia afuera.

### Analogia

Esta idea puede compararse con un medico:

- La **failure** seria el sintoma que observa el paciente.
- El **fault** seria la causa raiz del problema.
- El **error** seria una condicion interna anomala que ayuda a explicar como la causa llega al sintoma.

La analogia sirve para entender que la falla es lo que se ve, mientras que el defecto es lo que realmente esta mal en el sistema.

### Conclusión

La diferencia entre ambos conceptos es que el **defecto (`fault`)** esta dentro del software y representa un problema de construccion del programa, mientras que la **falla (`failure`)** es el comportamiento incorrecto que se observa al ejecutar ese software.

Dicho de otra forma: el `fault` esta en el programa; la `failure` aparece en la ejecucion. Entre ambos, se encuentra el `error` como el estado interno incorrecto que conecta la causa con la manifestacion visible.
