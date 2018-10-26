// Create a new module 
angular.module('myAppModule', []);

// configure the module with a controller
angular.module('myAppModule').controller("myCtrl", function ($scope) {
    var student = {
        firstname: 'Llly',
        lastname: 'Lee',
        dateJoined: new Date(2016, 1, 1),
        gpa: 3.5367,
        phone: '510-555-777'
    };
    $scope.data = student;
});

// configure the module with a filter 
angular.module('myAppModule').filter('removeDashes', function() {
    return function(txt) {
        // filter code would go here
        return txt.split('-').join(' ');
	}; 
});
