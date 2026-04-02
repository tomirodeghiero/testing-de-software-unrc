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
