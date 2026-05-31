#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
SITE_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
cd "$REPO_ROOT"

TPS="tp1 tp2 tp3 tp4 tp5 tp6 tp7 tp8 tp9"

upper() {
  echo "$1" | tr '[:lower:]' '[:upper:]'
}

titleize() {
  echo "$1" | sed -E 's/[-_]+/ /g' | awk '{for(i=1;i<=NF;i++){ $i=toupper(substr($i,1,1)) tolower(substr($i,2)) } print}'
}

readmes_list="$(mktemp)"
for tp in $TPS; do
  find "$tp" -type f \( -name 'README.md' -o -name 'readme.md' \) \
      ! -path "*assignment-*-rodeghiero/*" \
      ! -path "*assignmnet-*-rodeghiero/*"
done | sort > "$readmes_list"

rm -rf "$SITE_ROOT/docs"
rm -rf "$SITE_ROOT/static/pdfs"
mkdir -p "$SITE_ROOT/docs" "$SITE_ROOT/static/pdfs"

while IFS= read -r src; do
  tp="${src%%/*}"
  sub="${src#*/}"
  dir="$(dirname "$sub")"

  if [ "$dir" = "." ]; then
    dest="$SITE_ROOT/docs/$tp/index.md"
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
    dest="$SITE_ROOT/docs/$tp/$dir/index.md"
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
  idx="$SITE_ROOT/docs/$tp/index.md"
  if [ ! -f "$idx" ]; then
    mkdir -p "$SITE_ROOT/docs/$tp"
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
  idx="$SITE_ROOT/docs/$tp/index.md"
  subdocs="$(find "$SITE_ROOT/docs/$tp" -type f -name 'index.md' ! -path "$idx" | sort || true)"
  if [ -n "$subdocs" ] && ! grep -qE '^## Navegacion interna$' "$idx"; then
    {
      echo
      echo "## Navegacion interna"
      echo
      echo "$subdocs" | while IFS= read -r d; do
        [ -z "$d" ] && continue
        rel="${d#$SITE_ROOT/docs/$tp/}"
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
  idx="$SITE_ROOT/docs/$tp/index.md"
  pdfs="$(find "$tp" -type f -iname '*.pdf' | sort || true)"
  if [ -n "$pdfs" ]; then
    {
      echo
      echo "## Material PDF"
      echo
      echo "$pdfs" | while IFS= read -r pdf; do
        [ -z "$pdf" ] && continue
        rel="${pdf#./}"
        mkdir -p "$SITE_ROOT/static/pdfs/$(dirname "$rel")"
        cp "$pdf" "$SITE_ROOT/static/pdfs/$rel"
        name="$(basename "$pdf")"
        url="/pdfs/${rel// /%20}"
        echo "- [$name]($url)"
      done
    } >> "$idx"
  fi
done

cat > "$SITE_ROOT/docs/intro.md" <<'EOF'
---
title: "Testing de Software — UNRC"
sidebar_position: 1
slug: "/"
description: "Resolución de los Trabajos prácticos de Testing de Software (UNRC)"
---

# Testing de Software — UNRC

Trabajos prácticos de la materia. Cada TP tiene su enunciado, la resolución y los ejercicios con código y tests.

## Prácticos

- [TP1 — Conceptos básicos, RIPR y JUnit AAA](./tp1/)
- [TP2 — Data-driven testing con `@ParameterizedTest` y `repOK`](./tp2/)
- [TP3 — Particionado del espacio de entrada (ISP)](./tp3/)
- [TP4 — Testing basado en grafos](./tp4/)
- [TP5 — Expresiones lógicas: CACC / RACC](./tp5/)
- [TP6 — Mutación con Pitest y *fuzzing*](./tp6/)
- [TP7 — Property-Based Testing con `jqwik`](./tp7/)
- [TP8 — Randoop, EvoSuite y *mocking*](./tp8/)
- [TP9 — Trabajo práctico final](./tp9/)
EOF

if [ ! -f "$SITE_ROOT/package.json" ]; then
  cat > "$SITE_ROOT/package.json" <<'EOF'
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

if [ ! -f "$SITE_ROOT/docusaurus.config.js" ]; then
  cat > "$SITE_ROOT/docusaurus.config.js" <<'EOF'
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

if [ ! -f "$SITE_ROOT/sidebars.js" ]; then
  cat > "$SITE_ROOT/sidebars.js" <<'EOF'
/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  tutorialSidebar: [{ type: 'autogenerated', dirName: '.' }]
};

module.exports = sidebars;
EOF
fi

if [ ! -f "$SITE_ROOT/babel.config.js" ]; then
  cat > "$SITE_ROOT/babel.config.js" <<'EOF'
module.exports = {
  presets: [require.resolve('@docusaurus/core/lib/babel/preset')]
};
EOF
fi

mkdir -p "$SITE_ROOT/src/css"
if [ ! -f "$SITE_ROOT/src/css/custom.css" ]; then
  cat > "$SITE_ROOT/src/css/custom.css" <<'EOF'
/* Ajustes visuales minimos para la documentacion */
EOF
fi

rm -f "$readmes_list"
echo "Documentacion regenerada en $SITE_ROOT/docs/ y $SITE_ROOT/static/pdfs/"
