'use strict';

angular.module('curriculumUiApp')
  .controller('Home', function (Storage, Auth, toaster) {
    var vm = this;

    vm.curriculumHost = document.curriculumHost;
    vm.searchQuery = '';
    vm.infiniteScrollLoaded = true;
    vm.infiniteScrollFinished = false;
    vm.curriculums = [];

    vm.isEditor = function () {
      return (('ROLE_WRITE' === Auth.user.role) || ('ROLE_ADMIN' === Auth.user.role));
    };

    vm.isAuthor = function (curriculum) {
      return curriculum.createdBy === Auth.user.id;
    };

    vm.loadCurriculums = (function () {
      var offset = 0;
      return function (refresh) {
        if (refresh || vm.infiniteScrollLoaded) {
          vm.infiniteScrollLoaded = false;
          toaster.wait('Завантаження навчальних планів', null, 2000);

          if (refresh) {
            offset = 0;
            vm.infiniteScrollFinished = false;
          }

          var request = {};
          request.model = 'curriculums';
          request.limit = 9;
          request.offset = offset += 1;

          if (vm.searchQuery) {
            request.search = vm.searchQuery;
          }

          Storage.get(
            request,
            function (data) {
              vm.infiniteScrollLoaded = true;
              if (!refresh) {
                Array.prototype.push.apply(vm.curriculums, data.content);
              } else {
                vm.curriculums = data.content;
              }
              if (data.totalElements === vm.curriculums.length) {
                vm.infiniteScrollFinished = true;
              }
            },
            function (e) {
              toaster.error('Error', e.data.message);
            });
        }
      };
    })();
  });
