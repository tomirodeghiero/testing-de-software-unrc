# Practico 7

Resolucion del practico 7 de Testing de Software (Property-Based Testing con `jqwik` y
generacion aleatoria de inputs).

## Resoluciones por ejercicio

- `ejercicio1/README.md` - `NodeCachingLinkedList`: implementacion de `repOK()` y tres propiedades sobre cache y remocion.
- `ejercicio2/README.md` - `Point`: contrato `equals/hashCode`, generador `@Provide` y propiedad de distancia en recta horizontal.
- `ejercicio3/README.md` - `Date`: constructor con validacion, `addDays` por bloques de mes y propiedad de validez del resultado.
- `assignmnet-7-rodeghiero/` - codigo Java con `jqwik` (`mvn test`).

## Documentos LaTeX

- `resolucion_practico7.tex` / `.pdf` - resolucion integral del TP7.
- `resumen_teorico_practico7.tex` / `.pdf` - resumen teorico basado en:
  - `material/notas-12-pbt.pdf`
  - `material/notas-13-generacion-aleatoria.pdf`

## Como compilar los LaTeX

```bash
tectonic resolucion_practico7.tex
tectonic resumen_teorico_practico7.tex
```

o, alternativamente:

```bash
pdflatex resolucion_practico7.tex && pdflatex resolucion_practico7.tex
pdflatex resumen_teorico_practico7.tex && pdflatex resumen_teorico_practico7.tex
```

## Como correr los tests

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```
