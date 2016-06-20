'use strict';

angular.module('curriculumUiApp')
  .controller('Main', function (Auth) {
    var vm = this;
    vm.user = Auth.user;

    vm.logout = function () {
      Auth.logout();
    }
  });
