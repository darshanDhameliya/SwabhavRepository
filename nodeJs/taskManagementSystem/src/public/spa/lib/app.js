let taskManagementApp = angular.module('taskManagementApp', ['ngRoute', 'taskManagementLib']);

taskManagementApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'fragments/login.html',
            controller: 'logInController'
        })
        .when('/register', {
            templateUrl: 'fragments/register.html',
            controller: 'registerController'
        })
        .when('/task', {
            templateUrl: 'fragments/task.html',
            controller: 'taskController'
        })
        .when('/:taskId/subTask', {
            templateUrl: 'fragments/subTask.html',
            controller: 'subTaskController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
taskManagementApp.controller('logInController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = true;
    $rootScope.navigationBarVisible = false;
    $scope.userLogIn = function () {
        taskManagementFactory.logIn({
                "emailId": $scope.emailId,
                "password": $scope.password
            })
            .then(function (result) {
                if (result.data._id) {
                    $window.sessionStorage.setItem('taskManagementSystem', result.data._id);
                    $location.path('/task');
                }
                if (!result.data._id)
                    $window.alert(result.data.message);
            })
            .catch(function (error) {
                console.log(error);
            })
    };
}]);
taskManagementApp.controller('registerController', ['$scope', 'taskManagementFactory', function ($scope, taskManagementFactory) {
    $scope.userRegister = function () {
        taskManagementFactory.register({
                "firstName": $scope.firstName,
                "lastName": $scope.lastName,
                "gender": $scope.gender,
                "birthOfDate": $scope.birthOfDate,
                "contactNo": $scope.contactNo,
                "country": $scope.country,
                "state": $scope.state,
                "city": $scope.city,
                "street": $scope.street,
                "houseNumber": $scope.houseNumber,
                "emailId": $scope.emailId,
                "password": $scope.password
            })
            .then(function (result) {
                console.log(result);
            })
            .catch(function (error) {
                console.log(error);
            })
    };
}]);
taskManagementApp.controller('taskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
    let userId = $window.sessionStorage.getItem("taskManagementSystem");
    taskManagementFactory.displayTask(userId)
        .then(function (result) {
            $scope.taskList = result.data;
        })
        .catch(function (error) {
            console.log(error);
        })
    $scope.displaySubTask = function (taskId) {
        $location.path('/'+taskId+'/subTask');
    };
}]);
taskManagementApp.controller('subTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$routeParams', function ($scope, $rootScope, taskManagementFactory, $window, $routeParams) {
    let taskId = $routeParams.taskId;
    let userId = $window.sessionStorage.getItem("taskManagementSystem");
    
    taskManagementFactory.displaySubTask(userId, taskId)
        .then(function (result) {
            $scope.subTaskList=result.data;
        })
        .catch(function (error) {
            console.log(error);
        })
}]);
taskManagementApp.filter('priorityFilter', function () {
    return function (priority) {
        if (priority == "important")
            return "rgb(240, 149, 46)";
        if (priority == "idel")
            return "lightblue";
        return "white";
    };
});
taskManagementApp.filter('isComplatedFilter', function () {
    return function (isComplated) {
        if (isComplated == true)
            return "solid red";
        return "solid green";
    };
});