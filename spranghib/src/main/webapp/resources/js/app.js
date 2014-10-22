'use strict';

var SprAngHib = {};

var App = angular.module('SprAngHib', ['SprAngHib.filters', 'SprAngHib.services', 'SprAngHib.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {

	$routeProvider.when('/students', {
        templateUrl: 'students/layout',
        controller: StudentController
    });

    $routeProvider.otherwise({redirectTo: '/students'});
}]);
