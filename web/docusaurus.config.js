// @ts-check
const { themes } = require('prism-react-renderer');

const currentYear = new Date().getFullYear();

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'Testing de Software - Documentacion Academica',
  tagline: 'Trabajos practicos y evidencia tecnica',
  url: 'http://localhost',
  baseUrl: '/',
  favicon: 'img/unrc.png',
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
    colorMode: {
      defaultMode: 'light',
      disableSwitch: true
    },
    docs: {
      sidebar: {
        hideable: true,
        autoCollapseCategories: true
      }
    },
    navbar: {
      title: 'Testing de Software',
      hideOnScroll: true,
      logo: {
        alt: 'Escudo UNRC',
        src: 'img/unrc.png'
      },
      items: []
    },
    footer: {
      style: 'light',
      links: [
        {
          title: 'Practicos I',
          items: [
            { label: 'TP1 — JUnit y RIPR', to: '/tp1/' },
            { label: 'TP2 — Parameterized', to: '/tp2/' },
            { label: 'TP3 — ISP', to: '/tp3/' },
            { label: 'TP4 — Grafos', to: '/tp4/' }
          ]
        },
        {
          title: 'Practicos II',
          items: [
            { label: 'TP5 — CACC / RACC', to: '/tp5/' },
            { label: 'TP6 — Pitest & fuzzing', to: '/tp6/' },
            { label: 'TP7 — jqwik (PBT)', to: '/tp7/' },
            { label: 'TP8 — Randoop & EvoSuite', to: '/tp8/' },
            { label: 'TP9 — Trabajo final', to: '/tp9/' }
          ]
        },
        {
          title: 'Tecnicas',
          items: [
            { label: 'Particionado (ISP)', to: '/tp3/' },
            { label: 'Cobertura de grafos', to: '/tp4/' },
            { label: 'Cobertura logica', to: '/tp5/' },
            { label: 'Testing de mutacion', to: '/tp6/' },
            { label: 'Property-Based Testing', to: '/tp7/' }
          ]
        },
        {
          title: 'Catedra',
          items: [
            { label: 'Indice principal', to: '/' },
            {
              label: 'Universidad Nacional de Rio Cuarto',
              href: 'https://www.unrc.edu.ar/'
            },
            {
              label: 'Departamento de Computacion',
              href: 'https://dc.exa.unrc.edu.ar/'
            }
          ]
        }
      ],
      copyright: `(c) ${currentYear} Testing de Software — UNRC · Documentacion academica de trabajos practicos · Construido con Docusaurus.`
    },
    prism: {
      theme: themes.github,
      darkTheme: themes.dracula,
      additionalLanguages: ['java', 'bash', 'markdown']
    }
  }
};

module.exports = config;
