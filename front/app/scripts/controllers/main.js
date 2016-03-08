'use strict';

/**
 * @ngdoc function
 * @name communityApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the communityApp
 */
angular.module('communityApp')
  .controller('MainCtrl', ['$scope', '$resource', function ($scope, $resource) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    var ExpenseResource = $resource('http://localhost:8080/api/expenses', {});
    var DebtResource = $resource('http://localhost:8080/api/debts', {});


    $scope.expense = {};

    $scope.add = function (expense) {
      var newExpense = new ExpenseResource({user: expense.user, amount: expense.amount});
      newExpense.$save(function () {
        $scope.refresh();
      });
      $scope.expense = {};
      //$scope.expenses.push(angular.copy(expense));
    };


    $scope.refresh = function () {
      $scope.expenses = ExpenseResource.query();
      $scope.debts = DebtResource.query();
    };

    $scope.refresh();
    // Mocks

    /*$scope.expenses = [
     {
     'user': 'Alice',
     'amount': 34.0,
     'dateTime': '2016-02-28T21:53:48.427'
     },
     {
     'user': 'Bob',
     'amount': 42.0,
     'dateTime': '2016-02-28T21:53:48.595'
     },
     {
     'user': 'Bob',
     'amount': 3.14,
     'dateTime': '2016-02-28T21:53:48.595'
     }
     ];*/

    /*$scope.debts = [
     {
     'creditor': 'Bob',
     'debtor': 'Alice',
     'amount': 5.57
     }
     ];*/

  }]);
