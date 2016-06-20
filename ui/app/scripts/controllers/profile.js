'use strict';

angular.module('curriculumUiApp')
  .controller('Profile', function ($resource, Storage, toaster) {
    var vm = this;
    vm.user = {};
    vm.password = {};
    vm.checkEmail = function (email) {
      if ((email) && (email !== vm.checkedEmail)) {
        Storage.get({
          model: 'users',
          id: 'email',
          action: email
        }, function (data) {
          vm.checkedEmail = email;
          vm.emailError = ((data.value) && (vm.user.oldEmail !== email))?'Email is already in use':null;
        });
      }
      return true;
    };

    this.activate = function() {
      Storage.get({
          model: 'users',
          id: 'current'
        },
        function (data) {
          vm.user = data;
          vm.user.oldEmail = vm.user.email;
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.updateProfile = function () {
      Storage.update({
          model: 'users',
          id: vm.user.id
        },
        vm.user,
        function () {
          toaster.success('Збережено');
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.updatePassword = function () {
      vm.passwordError = null;
      Storage.update({
          model: 'users',
          id: vm.user.id,
          action: 'password'
        },
        vm.password,
        function () {
          vm.password = {};
          toaster.success('Збережено');
        },
        function (e) {
          vm.passwordError = e.data.message;
          toaster.error('Error', e.data.message);
        });
    };

    this.activate();
  });
