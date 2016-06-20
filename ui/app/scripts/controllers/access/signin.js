'use strict';

angular.module('curriculumUiApp')
  .controller('Signin', function (Auth) {
    var vm = this;
    vm.user = {};
    vm.authError = Auth.authError;
    vm.login = function () {
      Auth.login(vm.user);
    }
  });
