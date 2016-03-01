'use strict';

/**
 * @ngdoc overview
 * @name communityApp
 * @description
 * # communityApp
 *
 * Main module of the application.
 */
angular
  .module('communityApp', [
    'ngResource',
    'ngRoute',
    'ngSanitize'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
