'use strict';

angular
  .module('curriculumUiApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ui.router',
    'ui.bootstrap',
    'ui.utils',
    'ui.jq',
    'ui.select',
    'infinite-scroll',
    'toaster'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'views/home.html',
        controller: 'Home',
        controllerAs: 'home'
      })
      .state('curriculum', {
        url: '/curriculum/:id',
        templateUrl: 'views/curriculum.html',
        controller: 'Curriculum',
        controllerAs: 'curriculum'
      })
      .state('profile', {
        url: '/profile',
        templateUrl: 'views/profile.html',
        controller: 'Profile',
        controllerAs: 'profile'
      })
      .state('admin', {
        url: '/admin',
        templateUrl: 'views/admin.html',
        controller: 'Admin',
        controllerAs: 'admin'
      })
      .state('forgotpwd', {
        url: '/access/forgotpwd',
        templateUrl: 'views/access/forgotpwd.html',
        controller: 'Forgotpwd',
        controllerAs: 'forgotpwd'
      })
      .state('signin', {
        url: '/access/signin',
        templateUrl: 'views/access/signin.html',
        controller: 'Signin',
        controllerAs: 'signin'
      })
      .state('signup', {
        url: '/access/signup',
        templateUrl: 'views/access/signup.html',
        controller: 'Signup',
        controllerAs: 'signup'
      });

    $urlRouterProvider.otherwise('/');
  })
  .config(function ($httpProvider) {
    //todo profiles
    document.curriculumHost =
      //dev
      // 'http://localhost:8080';
      //prod
      window.location.origin;
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    $httpProvider.interceptors.push(['$q', '$location', '$window', function ($q, $location, $window) {
      return {
        'request': function (config) {
          //todo profiles
          if (config.url.startsWith('/api')) {
            config.url = document.curriculumHost + config.url;
          }
          return config || $q.when(config);
        },
        'responseError': function (response) {
          if ($location.$$url.indexOf("/access/") === -1) {
            if (response.status === 401) {
              $location.path('/access/signin');
            } else if (response.status === 403) {
              $location.path("/");
            }
          }
          return $q.reject(response);
        }
      };
    }]);
  })
  .run(function ($rootScope, $window, $location, Auth) {
    $rootScope.$on('$stateChangeStart', function (event) {
      var token = Auth.getToken();
      var indexOfAccess = $location.$$url.indexOf("/access/");
      if (!token && indexOfAccess === -1) {
        event.preventDefault();
        Auth.toPath = $location.$$url;
        $window.location.assign('/#/access/signin');
      } else if (token && indexOfAccess > -1) {
        event.preventDefault();
        $location.path('/');
      } else if (token && !Auth.user.isPresent) {
        Auth.loadUser();
      }
    });
  });
