# Testing de Software — UNRC

Repositorio de los trabajos prácticos de la materia **Testing de Software** de la Licenciatura en Ciencias de la Computación, Universidad Nacional de Río Cuarto.

- Alumno: Tomás Rodeghiero
- Año de cursado: 2026
- Sitio publicado: <https://testing-de-software-unrc.vercel.app/>

## Contenido del repositorio

El repositorio reúne los nueve prácticos de la materia. Cada práctico tiene la misma estructura:

```
tpN/
├─ readme.md                    portada del práctico
├─ practicoN.pdf                enunciado original
├─ resolucion_practicoN.pdf     resolución completa (versión final)
├─ resolucion_practicoN.tex     fuente LaTeX de la resolución
├─ resumen_teorico_*.pdf|.tex   (opcional) resumen teórico de la unidad
├─ material/                    capítulos y notas de cátedra usados
└─ ejercicioM/                  carpeta por cada ejercicio
   ├─ README.md                 consigna y resolución navegable
   └─ <código y artefactos>
```

| Práctico | Tema |
| :---: | :--- |
| TP1 | Conceptos básicos: *fault*, *error* y *failure*, modelo RIPR, JUnit y patrón Arrange–Act–Assert |
| TP2 | Data-driven testing con JUnit 5 (`@ParameterizedTest`) y `repOK` sobre TADs |
| TP3 | Particionado del espacio de entrada (*Input Space Partitioning*) |
| TP4 | Testing basado en grafos: *control-flow*, *data-flow* y criterios sobre grafos |
| TP5 | Testing de expresiones lógicas: cobertura de predicados, cláusulas y CACC / RACC |
| TP6 | Testing basado en sintaxis: mutación con Pitest y *fuzzing* |
| TP7 | *Property-Based Testing* con `jqwik` y generación aleatoria de entradas |
| TP8 | Generación automática de tests (Randoop, EvoSuite), *mocking* con EasyMock |
| TP9 | Trabajo práctico final |

## Sitio web (Docusaurus)

La web es la forma recomendada de recorrer la entrega: muestra cada práctico con su enunciado en PDF, la resolución en PDF y la resolución navegable construida a partir de los `README.md` del repositorio.

Para verla en local:

```bash
npm install            # solo la primera vez
npm run docs:generate  # arma docs/ y static/pdfs/ a partir de los README
npm start              # http://localhost:3000
```

Para generar la build estática (lo mismo que ejecuta el deploy):

```bash
npm run build          # docs:generate + docusaurus build
npm run serve          # sirve la build local
```

## Cómo está armada la web

Las páginas se generan automáticamente desde los `README.md` / `readme.md` del repositorio mediante `scripts/generate_docs_docusaurus.sh`. El script:

1. Recorre cada carpeta `tpN/` y vuelca los README a `docs/`.
2. Copia todos los PDF de cada práctico a `static/pdfs/<tp>/` para que queden enlazables.
3. Arma el índice de ejercicios y la sección *Material PDF* de cada práctico.

Por eso `docs/` y `static/pdfs/` están en `.gitignore`: la fuente de verdad son los README. Para modificar el sitio, se edita el README correspondiente y se regenera.

## Estado de la entrega

Los nueve prácticos están resueltos, con la resolución completa publicada en PDF y en la web. El TP9 corresponde al trabajo práctico final.
