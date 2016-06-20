'use strict';

angular.module('curriculumUiApp')
  .controller('Signup', function ($resource, Storage, Auth, toaster) {
    var vm = this;
    vm.user = {};
    vm.checkEmail = function (email) {
      if ((email) && (email !== vm.checkedEmail)) {
        Storage.get({
          model: 'users',
          id: 'email',
          action: email
        }, function (data) {
          vm.checkedEmail = email;
          vm.authError = (data.value) ? 'Email is already in use' : null;
        });
      }
      return true;
    };
    vm.signup = function () {
      Storage.save(
        {
          model: 'users'
        },
        vm.user,
        function () {
          Auth.login(vm.user);
        }, function (e) {
          vm.authError = e.data.message;
          toaster.error('Error', e.data.message);
        });
    }
  });
