// Create a new module
angular.module('myModule', []);
// create a surface that creates a data 
angular.module('myModule').factory("Info",
    function () {
        return {
            getName: function () {
                return "NPU";
            }
        };
    }
);
// configure the module with a controller 
angular.module('myModule').controller('MyController',
    function ($scope, Info) {
        $scope.name = Info.getName();
        $scope.time = (new Date()).toLocaleTimeString();
        $scope.updateTime = function () {
            $scope.time = (new Date()).toLocaleTimeString();
        };
    }
);
// configure the module with a filter 
angular.module('myModule').filter('customuppercase',
    function () {
        return function (input) {
            if (input.length > 5) {
                return input.toUpperCase();
            } else {
                return input;
            }
        };
    }
);