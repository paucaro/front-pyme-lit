import { Route, Router } from '@vaadin/router';
import './app';

const routes: Route[] = [
  {
    path: '/',
    component: 'lit-app',
    children: [
      {
        path: 'blog',
        component: 'lit-blog',
        action: async () => {
          await import('./blog/blog');
        },
        children: [
          {
            path: '',
            redirect: '/blog/posts',
          },
          {
            path: 'posts',
            component: 'lit-blog-posts',
            action: async () => {
              await import('./blog/blog-posts');
            },
          },
          {
            path: 'posts/:id',
            component: 'lit-blog-post',
            action: async () => {
              await import('./blog/blog-post');
            },
          },
        ],
      },
      {
        path: 'about',
        component: 'lit-about',
        action: async () => {
          await import('./about/about');
        },
      },
      {
        path: 'admin/:section',
        component: 'lit-admin',
        action: async () => {
          await import('./admin/admin');
        },
      },
    ],
  },
];

const outlet = document.getElementById('outlet');
export const router = new Router(outlet);
router.setRoutes(routes);
