# Testing de Software — UNRC

Repositorio de la resolución de los trabajos prácticos de la materia **Testing de Software** de la Licenciatura en Ciencias de la Computación en la Universidad Nacional de Río Cuarto.

- Alumno: Tomás Rodeghiero
- Año: 2026
- Sitio: <https://testing-de-software-unrc.vercel.app>

## Prácticos

| TP | Tema |
| :---: | :--- |
| [TP1](tp1/) | Conceptos básicos: *fault / error / failure*, modelo RIPR, JUnit y AAA |
| [TP2](tp2/) | Data-driven testing con `@ParameterizedTest` y `repOK` sobre TADs |
| [TP3](tp3/) | Particionado del espacio de entrada (ISP) |
| [TP4](tp4/) | Testing basado en grafos: *control-flow*, *data-flow* y criterios |
| [TP5](tp5/) | Expresiones lógicas: cobertura de predicados, cláusulas, CACC / RACC |
| [TP6](tp6/) | Testing basado en sintaxis: mutación con Pitest y *fuzzing* |
| [TP7](tp7/) | *Property-Based Testing* con `jqwik` |
| [TP8](tp8/) | Generación automática de tests: Randoop, EvoSuite y *mocking* |
| [TP9](tp9/) | Trabajo práctico final |

## Estructura del repo

```
.
├─ tpN/          un práctico por carpeta
├─ web/          sitio Docusaurus (espejo navegable de los README)
├─ vercel.json   configuración del deploy de la web en Vercel
└─ README.md
```

Cada `tpN/` contiene el enunciado en PDF, la resolución, el material utilizado y los ejercicios con sus códigos y tests.
