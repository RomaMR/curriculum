'use strict';

angular.module('curriculumUiApp')
  .controller('Admin', function (Auth, Storage, toaster) {
    var vm = this;
    vm.currentUser = Auth.user;

    /* Users */
    vm.searchQuery = '';
    vm.infiniteScrollLoaded = true;
    vm.infiniteScrollFinished = false;
    vm.users = [];

    vm.saveUser = function (user) {
      Storage.update({
          model: 'users',
          id: user.id,
          action: 'role'
        },
        user,
        function () {
          user.oldRole = user.role;
          toaster.warning('Збережено');
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.loadUsers = (function () {
      var offset = 0;
      return function (refresh) {
        if (refresh || vm.infiniteScrollLoaded) {
          vm.infiniteScrollLoaded = false;
          toaster.wait('Завантаження користувачів', null, 2000);

          if (refresh) {
            offset = 0;
            vm.infiniteScrollFinished = false;
          }

          var request = {};
          request.model = 'users';
          request.limit = 50;
          request.offset = offset += 1;

          if (vm.searchQuery) {
            request.search = vm.searchQuery;
          }

          Storage.get(
            request,
            function (data) {
              vm.infiniteScrollLoaded = true;
              data.content.forEach(function (user) {
                user.oldRole = user.role;
              });
              if (!refresh) {
                Array.prototype.push.apply(vm.users, data.content);
              } else {
                vm.users = data.content;
              }
              if (data.totalElements === vm.users.length) {
                vm.infiniteScrollFinished = true;
              }
            },
            function (e) {
              toaster.error('Error', e.data.message);
            });
        }
      };
    })();

    vm.highlightSearch = function (text) {
      var search = vm.searchQuery;
      return ((search) && (text) && (text.toLowerCase().indexOf(search.toLowerCase()) > -1));
    };

    /* Constants */
    vm.constants = {
      id: 'default'
    };

    vm.temporaryConstants = {};

    vm.constantTypes = [
      {
        title: 'Галузі знань',
        type: 'knowledgeBranch'
      },
      {
        title: 'Напрями підготовки',
        type: 'trainingDirection'
      },
      {
        title: 'Спеціальності',
        type: 'specialty'
      },
      {
        title: 'Факультети',
        type: 'faculty'
      },
      {
        title: 'Кваліфікаційні рівні',
        type: 'qualificationLevel'
      },
      {
        title: 'Тип',
        type: 'type'
      },
      {
        title: 'Форми навчання',
        type: 'studyForm'
      }
    ];

    vm.saveConstants = function () {
      Storage.save({
          model: 'constants'
        },
        vm.constants,
        function () {
          toaster.success('Збережено');
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.activate = function () {
      vm.constantTypes.forEach(function (constantType) {
        vm.constants[constantType.type] = [];
        vm.temporaryConstants[constantType.type] = [];
      });
      Storage.get({
          model: 'constants',
          id: vm.constants.id
        },
        function (data) {
          vm.constantTypes.forEach(function (constantType) {
            if (data[constantType.type]) {
              vm.constants[constantType.type] = data[constantType.type];
              angular.copy(vm.constants[constantType.type], vm.temporaryConstants[constantType.type]);
            }
          });
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.activate();
  });
