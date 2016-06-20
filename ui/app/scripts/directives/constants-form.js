'use strict';

angular.module('curriculumUiApp')
  .directive('constantsForm', function () {
    return {
      replace: true,
      restrict: 'E',
      templateUrl: 'views/directives/constants-form.html',
      scope: {
        categoryName: '@',
        originalArray: '=',
        categoryArray: '=',
        saveConstants: "="
      },
      link: function (scope) {
        scope.addCategory = function () {
          this.categoryArray.push('');
        };
        scope.deleteCategory = function (index) {
          this.categoryArray.splice(index, 1);
        };
        scope.cancelCategory = function () {
          angular.copy(this.originalArray, this.categoryArray);
        };
        scope.saveCategory = function () {
          angular.copy(this.categoryArray, this.originalArray);
          this.saveConstants();
        };
      }
    };

  });
