'use strict';

angular.module('curriculumUiApp')
  .service('Auth', function ($location, $http, $cookies, Storage, toaster) {
    var vm = this;
    vm.user = {
      isPresent: false
    };
    vm.authError = {};

    vm.getToken = function () {
      var token = $cookies.get('X-Auth-Token');
      return token;
    };

    vm.loadUser = function () {
      Storage.get({
          model: 'authentications'
        },
        function (data) {
          vm.authError.message = null;
          vm.user.isPresent = true;
          vm.user.id = data.id;
          vm.user.fullName = data.fullName;
          vm.user.role = data.role;
        },
        function (e) {
          vm.authError.message = e.data.message;
          toaster.error('Error', e.data.message);
        });
    };

    vm.login = function (user) {
      toaster.wait('Логін', null, 1000);
      Storage.save({
          model: 'authentications'
        },
        user,
        function () {
          var toPath = (vm.toPath)?vm.toPath:'/';
          $location.path(toPath);
        },
        function (e) {
          vm.authError.message = e.data.message;
          toaster.error('Error', e.data.message);
        });
    };

    vm.logout = function () {
      vm.user.isPresent = false;
      delete vm.user.id;
      delete vm.user.fullName;
      delete vm.user.role;
      Storage.delete({
          model: 'authentications'
        },
        function () {
          $location.path('/access/signin');
        },
        function (e) {
          vm.authError.message = e.data.message;
          toaster.error('Error', e.data.message);
        });
    }
  });
