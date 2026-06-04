// @ts-check
// Web Docusaurus: espejo navegable de los READMEs de cada TP.
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
      links: [],
      copyright: `${currentYear} Testing de Software — UNRC · Resolución de los trabajos prácticos`
    },
    prism: {
      theme: themes.github,
      darkTheme: themes.dracula,
      additionalLanguages: ['java', 'bash', 'markdown']
    }
  }
};

module.exports = config;
