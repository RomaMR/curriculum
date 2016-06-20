'use strict';

angular.module('curriculumUiApp')
  .factory('Storage', function ($resource) {
    return $resource('/api/:model/:id/:action', {}, {
      'replace': {method: 'PUT'},
      'update': {method: 'PATCH'}
    });
  });
