#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
cd "$ROOT"

TPS="tp1 tp2 tp3 tp4 tp5 tp6 tp7 tp8 tp9"

upper() {
  echo "$1" | tr '[:lower:]' '[:upper:]'
}

titleize() {
  echo "$1" | sed -E 's/[-_]+/ /g' | awk '{for(i=1;i<=NF;i++){ $i=toupper(substr($i,1,1)) tolower(substr($i,2)) } print}'
}

readmes_list="$(mktemp)"
for tp in $TPS; do
  find "$tp" -type f \( -name 'README.md' -o -name 'readme.md' \)
done | sort > "$readmes_list"

rm -rf docs
rm -rf static/pdfs
mkdir -p docs static/pdfs

while IFS= read -r src; do
  tp="${src%%/*}"
  sub="${src#*/}"
  dir="$(dirname "$sub")"

  if [ "$dir" = "." ]; then
    dest="docs/$tp/index.md"
    title="$(upper "$tp")"
    slug="/$tp/"
    position=1
  else
    bn="$(basename "$dir")"
    bn="${bn/assignmnet/assignment}"
    case "$bn" in
      ejercicio[0-9]*)
        n="$(echo "$bn" | sed -E 's/[^0-9]+//g')"
        if [ -n "$n" ]; then
          title="Ejercicio $n"
          position="$n"
        else
          title="$(titleize "$bn")"
          position=99
        fi
        ;;
      *)
        title="$(titleize "$bn")"
        position=99
        ;;
    esac
    dest="docs/$tp/$dir/index.md"
    slug="/$tp/$dir/"
  fi

  mkdir -p "$(dirname "$dest")"
  {
    echo "---"
    echo "title: \"$title\""
    echo "sidebar_position: $position"
    echo "slug: \"$slug\""
    echo "description: \"Contenido importado desde $src\""
    echo "---"
    echo
    sed -E 's#(\[[^]]+\]\([^)]*)README\.md#\1index.md#g; s#(\[[^]]+\]\([^)]*)readme\.md#\1index.md#g' "$src"
  } > "$dest"
done < "$readmes_list"

for tp in $TPS; do
  idx="docs/$tp/index.md"
  if [ ! -f "$idx" ]; then
    mkdir -p "docs/$tp"
    tpu="$(upper "$tp")"
    {
      echo "---"
      echo "title: \"$tpu\""
      echo "sidebar_position: 1"
      echo "slug: \"/$tp/\""
      echo "description: \"Indice de documentacion para $tp\""
      echo "---"
      echo
      echo "# $tpu"
      echo
      echo "Este practico no tenia un README general en la raiz."
      echo
    } > "$idx"
  fi
done

for tp in $TPS; do
  idx="docs/$tp/index.md"
  subdocs="$(find "docs/$tp" -type f -name 'index.md' ! -path "$idx" | sort || true)"
  if [ -n "$subdocs" ] && ! grep -qE '^## Navegacion interna$' "$idx"; then
    {
      echo
      echo "## Navegacion interna"
      echo
      echo "$subdocs" | while IFS= read -r d; do
        [ -z "$d" ] && continue
        rel="${d#docs/$tp/}"
        rel="${rel%/index.md}"
        bn="$(basename "$rel")"
        bn="${bn/assignmnet/assignment}"
        case "$bn" in
          ejercicio[0-9]*)
            n="$(echo "$bn" | sed -E 's/[^0-9]+//g')"
            if [ -n "$n" ]; then
              label="Ejercicio $n"
            else
              label="$(titleize "$bn")"
            fi
            ;;
          *)
            label="$(titleize "$bn")"
            ;;
        esac
        echo "- [$label](./$rel/)"
      done
    } >> "$idx"
  fi
done

for tp in $TPS; do
  idx="docs/$tp/index.md"
  pdfs="$(find "$tp" -type f -iname '*.pdf' | sort || true)"
  if [ -n "$pdfs" ]; then
    {
      echo
      echo "## Material PDF"
      echo
      echo "$pdfs" | while IFS= read -r pdf; do
        [ -z "$pdf" ] && continue
        rel="${pdf#./}"
        mkdir -p "static/pdfs/$(dirname "$rel")"
        cp "$pdf" "static/pdfs/$rel"
        name="$(basename "$pdf")"
        echo "- [$name](/pdfs/$rel)"
      done
    } >> "$idx"
  fi
done

cat > docs/intro.md <<'EOF'
---
title: "Documentacion de Trabajos Practicos"
sidebar_position: 1
slug: "/"
description: "Indice principal de la documentacion de Testing de Software"
---

# Documentacion de Trabajos Practicos

Esta documentacion consolida los README de cada trabajo practico del repositorio,
organizados por secciones para facilitar la navegacion.

## Practicos

- [TP1](./tp1/)
- [TP2](./tp2/)
- [TP3](./tp3/)
- [TP4](./tp4/)
- [TP5](./tp5/)
- [TP6](./tp6/)
- [TP7](./tp7/)
- [TP8](./tp8/)
- [TP9](./tp9/)

## Notas

- El contenido fue importado desde los README originales sin eliminarlos del proyecto.
- Se incorporo front matter basico para compatibilidad con Docusaurus.
- Los enlaces a otros README fueron adaptados a rutas `index.md` dentro de `docs/`.
- Los PDFs de cada practico se publican en la seccion "Material PDF" del indice.
EOF

if [ ! -f package.json ]; then
  cat > package.json <<'EOF'
{
  "name": "testing-software-docs",
  "version": "1.0.0",
  "private": true,
  "scripts": {
    "start": "docusaurus start",
    "build": "docusaurus build",
    "serve": "docusaurus serve",
    "clear": "docusaurus clear",
    "docs:generate": "bash scripts/generate_docs_docusaurus.sh"
  },
  "dependencies": {
    "@docusaurus/core": "3.9.2",
    "@docusaurus/preset-classic": "3.9.2",
    "react": "^18.2.0",
    "react-dom": "^18.2.0"
  }
}
EOF
fi

if [ ! -f docusaurus.config.js ]; then
  cat > docusaurus.config.js <<'EOF'
// @ts-check

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'Testing de Software - Documentacion',
  tagline: 'Trabajos practicos',
  url: 'http://localhost',
  baseUrl: '/',
  onBrokenLinks: 'warn',
  onBrokenMarkdownLinks: 'warn',
  i18n: {
    defaultLocale: 'es',
    locales: ['es']
  },
  presets: [
    [
      'classic',
      {
        docs: {
          routeBasePath: '/',
          sidebarPath: require.resolve('./sidebars.js')
        },
        blog: false,
        theme: {
          customCss: require.resolve('./src/css/custom.css')
        }
      }
    ]
  ],
  themeConfig: {
    navbar: {
      title: 'Testing de Software',
      items: [
        {
          type: 'docSidebar',
          sidebarId: 'tutorialSidebar',
          position: 'left',
          label: 'Documentacion'
        }
      ]
    }
  }
};

module.exports = config;
EOF
fi

if [ ! -f sidebars.js ]; then
  cat > sidebars.js <<'EOF'
/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  tutorialSidebar: [{ type: 'autogenerated', dirName: '.' }]
};

module.exports = sidebars;
EOF
fi

if [ ! -f babel.config.js ]; then
  cat > babel.config.js <<'EOF'
module.exports = {
  presets: [require.resolve('@docusaurus/core/lib/babel/preset')]
};
EOF
fi

mkdir -p src/css
if [ ! -f src/css/custom.css ]; then
  cat > src/css/custom.css <<'EOF'
/* Ajustes visuales minimos para la documentacion */
EOF
fi

rm -f "$readmes_list"
echo "Documentacion regenerada en docs/ y static/pdfs/"
