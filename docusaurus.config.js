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
      items: [
        {
          to: '/',
          label: 'Portada',
          position: 'left'
        },
        {
          type: 'docSidebar',
          sidebarId: 'tutorialSidebar',
          position: 'left',
          label: 'Documentacion'
        }
      ]
    },
    footer: {
      style: 'light',
      links: [
        {
          title: 'Contenido',
          items: [
            {
              label: 'Indice principal',
              to: '/'
            },
            {
              label: 'TP1 a TP9',
              to: '/tp1/'
            }
          ]
        },
        {
          title: 'Catedra',
          items: [
            {
              label: 'Testing de Software',
              to: '/'
            }
          ]
        }
      ],
      copyright: `(c) ${currentYear} Documentacion academica de trabajos practicos.`
    },
    prism: {
      theme: themes.github,
      darkTheme: themes.dracula,
      additionalLanguages: ['java', 'bash', 'markdown']
    }
  }
};

module.exports = config;
