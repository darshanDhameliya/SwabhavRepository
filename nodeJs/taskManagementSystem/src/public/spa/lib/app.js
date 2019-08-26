let taskManagementApp = angular.module('taskManagementApp', ['ngRoute', 'taskManagementLib']);
let sessionObject = {};
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
        .when('/addTask', {
            templateUrl: 'fragments/addTask.html',
            controller: 'addTaskController'
        })
        .when('/editTask', {
            templateUrl: 'fragments/editTask.html',
            controller: 'editTaskController'
        })
        .when('/subTask', {
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
                    sessionObject.userId = result.data._id;
                    $window.sessionStorage.setItem('taskManagementSystem', JSON.stringify(sessionObject));
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
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));


    let displayTask = function () {
        taskManagementFactory.displayTask(sessionObject.userId)
            .then(function (result) {
                if (result.data[0] != null)
                    $scope.taskList = result.data;
                if (result.data[0] == null)
                    $window.alert('Task Not Found');
            })
            .catch(function (error) {
                console.log(error);
            })
    };

    displayTask();
    $scope.addTask = function () {
        $location.path('/addTask');
    };

    $scope.deleteTask = function (taskId) {
        let deleteData = confirm("Are you sure you want to delete this?");
        if (deleteData == true) {
            taskManagementFactory.deleteTask(sessionObject.userId, taskId)
                .then(function (result) {
                    displayTask();
                    $window.alert(result.data.message);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    };
    $scope.editTask = function (taskId) {
        sessionObject.taskId = taskId;
        $window.sessionStorage.setItem('taskManagementSystem', JSON.stringify(sessionObject));
        $location.path('/editTask');
    };

    $scope.displaySubTask = function (taskId) {
        sessionObject.taskId = taskId;
        $window.sessionStorage.setItem('taskManagementSystem', JSON.stringify(sessionObject));
        $location.path('/subTask');
    };
}]);

taskManagementApp.controller('addTaskController', ['$scope', 'taskManagementFactory', '$window', '$location', function ($scope, taskManagementFactory, $window, $location) {
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));
    $scope.prioritys = ['important', 'idel'];

    $scope.addTask = function () {
        let task = {};
        task.tittle = $scope.tittle;
        task.description = $scope.description;
        task.startDate = $scope.startDate;
        task.dueDate = $scope.dueDate;
        task.assignee = $scope.assignee;
        task.priority = $scope.priority;

        taskManagementFactory.addTask(sessionObject.userId, task)
            .then(function (result) {
                $window.alert(result.data.message);
                $location.path('/task');
            })
            .catch(function (error) {
                console.log(error);
            })
    }
}]);
taskManagementApp.controller('editTaskController', ['$scope', 'taskManagementFactory', '$window', '$location', function ($scope, taskManagementFactory, $window, $location) {
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));
    $scope.prioritys = ['important', 'idel'];

    taskManagementFactory.getTaskById(sessionObject.userId, sessionObject.taskId)
        .then(function (result) {
            $scope.tittle = result.data.tittle;
            $scope.description = result.data.description;
            $scope.startDate = result.data.startDate;
            $scope.dueDate = result.data.dueDate;
            $scope.assignee = result.data.assignee;
            $scope.priority = result.data.priority;
            $scope.isComplated = result.data.isComplated;
        })
        .catch(function (error) {
            console.log(error);
        })

    // $scope.addTask = function () {
    //     let task = {};       
    //     task.tittle = $scope.tittle;
    //     task.description = $scope.description;
    //     task.startDate = $scope.startDate;
    //     task.dueDate = $scope.dueDate;
    //     task.assignee = $scope.assignee;
    //     task.priority = $scope.priority;

    //     taskManagementFactory.addTask(sessionObject.userId, task)
    //         .then(function (result) {
    //             $window.alert(result.data.message);
    //             $location.path('/task');
    //         })
    //         .catch(function (error) {
    //             console.log(error);
    //         })
    // }
}]);

taskManagementApp.controller('subTaskController', ['$scope', 'taskManagementFactory', '$window', function ($scope, taskManagementFactory, $window) {
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));

    let displaySubTask = function () {
        taskManagementFactory.displaySubTask(sessionObject.userId, sessionObject.taskId)
            .then(function (result) {
                if (result.data[0] != null)
                    $scope.subTaskList = result.data;
                if (result.data[0] == null)
                    $window.alert('Sub Task Not Found');
            })
            .catch(function (error) {
                console.log(error);
            })
    };

    displaySubTask();

    $scope.deleteSubTask = function (subTaskId) {
        let deleteData = confirm("Are you sure you want to delete this?");
        if (deleteData == true) {
            taskManagementFactory.deleteSubTask(sessionObject.userId, sessionObject.taskId, subTaskId)
                .then(function (result) {
                    displaySubTask();
                    $window.alert(result.data.message);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    };
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