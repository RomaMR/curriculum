'use strict';

angular.module('curriculumUiApp')
  .controller('Curriculum', function ($stateParams, Storage, toaster) {
    var vm = this;

    vm.addModule = function () {
      if (!vm.curriculum.modules) {
        vm.curriculum.modules = [];
      }
      vm.curriculum.modules.push({
        code: vm.curriculum.modules.length + 1
      });
    };
    vm.removeModule = function (index) {
      vm.curriculum.modules.splice(index, 1);
      var i = 0;
      vm.curriculum.modules.forEach(function (module) {
        module.code = ++i;
      });
    };
    vm.addTextbook = function () {
      if (!vm.curriculum.textbooks) {
        vm.curriculum.textbooks = [];
      }
      vm.curriculum.textbooks.push({
        code: vm.curriculum.textbooks.length + 1
      });
    };
    vm.removeTextbook = function (index) {
      vm.curriculum.textbooks.splice(index, 1);
      var i = 0;
      vm.curriculum.textbooks.forEach(function (textbook) {
        textbook.code = ++i;
      });
    };
    vm.save = function () {
      if (vm.curriculum.id) {
        Storage.update({
            model: 'curriculums',
            id: vm.curriculum.id
          },
          vm.curriculum,
          function () {
            toaster.success('Збережено');
          },
          function (e) {
            toaster.error('Error', e.data.message);
          });
      } else {
        Storage.save({
            model: 'curriculums'
          },
          vm.curriculum,
          function (data) {
            toaster.success('Збережено');
            vm.curriculum = data;
          },
          function (e) {
            toaster.error('Error', e.data.message);
          });
      }
    };

    vm.activate = function () {
      Storage.get({
          model: 'constants',
          id: 'default'
        },
        function (data) {
          vm.constants = data;
          vm.activateCurriculum();
        },
        function (e) {
          toaster.error('Error', e.data.message);
        });
    };

    vm.activateCurriculum = function () {
      if ($stateParams.id) {
        Storage.get({
            model: 'curriculums',
            id: $stateParams.id
          },
          function (data) {
            vm.curriculum = data;
          },
          function (e) {
            toaster.error('Error', e.data.message);
          });
      } else {
        vm.curriculum = {
          knowledgeBranch: vm.constants.knowledgeBranch[0],
          trainingDirection: vm.constants.trainingDirection[0],
          specialty: vm.constants.specialty[0],
          faculty: vm.constants.faculty[0],
          qualificationLevel: vm.constants.qualificationLevel[0],
          type: vm.constants.type[0],
          studyForm: vm.constants.studyForm[0],
          modules: [{
            code: 1
          }],
          textbooks: [{
            code: 1
          }]
        };
      }
    };

    vm.activate();
  });
