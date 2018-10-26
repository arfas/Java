// Create a new module
angular.module('myRouteModule', ['ngRoute']);

angular.module('myRouteModule').config(function ($routeProvider) {
    // configure the routes
    $routeProvider
        .when('/', {
            // route for the home page
            templateUrl: 'pages/home.html',
            controller: 'homeController'
        })
        .when('/order', {
            // route for the order page
            templateUrl: 'pages/order.html',
            controller: 'orderController'
        })
        .when('/cart', {
            // route for the cart page
            templateUrl: 'pages/cart.html',
            controller: 'cartController'
        })
        .otherwise({
        // when all else fails
            templateUrl: 'pages/routeNotFound.html',
            controller: 'notFoundController'
        });
});

angular.module('myRouteModule').controller('homeController', function ($scope) {
    $scope.message = 'Welcome to my home page!';
   
});
angular.module('myRouteModule').controller('orderController', function ($scope,$http) {
    $scope.message = 'Please add more items to your shopping cart!';
         $scope.result="";
             $scope.item={
                 itemName: '',
                 itemQty:''
             }
    
    $scope.addToCart=function(){
    $http({method:'POST',url:'http://localhost:3000/api/addtocart',data:$scope.item}).success(function(){
       $scope.result="The Item was added successfully";  
    }).error(function(data,status,headers,config){
        
         $scope.result="failed";
    })
    }
});
angular.module('myRouteModule').controller('cartController', function ($scope) {
    $scope.message = 'Your shopping cart has many items...';
});
angular.module('myRouteModule').controller('notFoundController', function ($scope) {
    $scope.message = 'There seems to be a problem finding the page you wanted';
});

