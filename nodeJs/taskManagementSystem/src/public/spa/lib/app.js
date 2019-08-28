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
        .when('/editTask/:taskId', {
            templateUrl: 'fragments/editTask.html',
            controller: 'editTaskController'
        })
        .when('/subTask', {
            templateUrl: 'fragments/subTask.html',
            controller: 'subTaskController'
        })
        .when('/addSubTask', {
            templateUrl: 'fragments/addSubTask.html',
            controller: 'addSubTaskController'
        })
        .when('/editSubTask/:subTaskId', {
            templateUrl: 'fragments/editSubTask.html',
            controller: 'editSubTaskController'
        })
        .when('/profile', {
            templateUrl: 'fragments/profile.html',
            controller: 'profileController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
taskManagementApp.controller('logInController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = true;
    $rootScope.navigationBarVisible = false;
    $window.sessionStorage.removeItem('taskManagementSystem');
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
taskManagementApp.controller('registerController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = true;
    $rootScope.navigationBarVisible = false;
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
                sessionObject.userId = result.data._id;
                $window.sessionStorage.setItem('taskManagementSystem', JSON.stringify(sessionObject));
                $location.path('/task');
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
        $location.path('/editTask/' + taskId);
    };

    $scope.displaySubTask = function (taskId) {
        sessionObject.taskId = taskId;
        $window.sessionStorage.setItem('taskManagementSystem', JSON.stringify(sessionObject));
        $location.path('/subTask');
    };
}]);

taskManagementApp.controller('addTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
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
taskManagementApp.controller('editTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$routeParams','$location', function ($scope, $rootScope, taskManagementFactory, $window, $routeParams,$location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));
    $scope.prioritys = ['important', 'idel'];

    taskManagementFactory.getTaskById(sessionObject.userId, $routeParams.taskId)
        .then(function (result) {
            $scope.tittle = result.data.tittle;
            $scope.description = result.data.description;
            $scope.startDate = new Date(result.data.startDate);
            $scope.dueDate = new Date(result.data.dueDate);
            $scope.assignee = result.data.assignee;
            $scope.priority = result.data.priority;
            $scope.isComplated = result.data.isComplated;
        })
        .catch(function (error) {
            console.log(error);
        })

        $scope.editTask=function(){
            
              taskManagementFactory.editTask(sessionObject.userId,$routeParams.taskId,{
                "tittle": $scope.tittle,
                "description": $scope.description,
                "startDate": $scope.startDate,
                "dueDate": $scope.dueDate,
                "assignee": $scope.assignee,
                "priority": $scope.priority,
                "isComplated": $scope.isComplated
              })
              .then((result)=>{
                $window.alert(result.data.message);
                $location.path('/task');
              })
              .catch((error)=>{
                  console.log(error);
              });
        };
}]);

taskManagementApp.controller('subTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
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

    $scope.addSubTask = function () {
        $location.path('/addSubTask');
    };
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
    $scope.editSubTask = function (subTaskId) {
        $location.path('/editSubTask/' + subTaskId);
    };
}]);

taskManagementApp.controller('addSubTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));
    $scope.addSubTask = function () {
        let subTask = {};
        subTask.tittle = $scope.tittle;
        subTask.description = $scope.description;
        subTask.startDate = $scope.startDate;
        subTask.dueDate = $scope.dueDate;
        subTask.assignee = $scope.assignee;

        taskManagementFactory.addSubTask(sessionObject.userId, sessionObject.taskId, subTask)
            .then(function (result) {
                $window.alert(result.data.message);
                $location.path('/subTask');
            })
            .catch(function (error) {
                console.log(error);
            })
    }
}]);
taskManagementApp.controller('editSubTaskController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$routeParams', function ($scope, $rootScope, taskManagementFactory, $window, $routeParams) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));
    $scope.prioritys = ['important', 'idel'];

    taskManagementFactory.getTaskById(sessionObject.userId, sessionObject.taskId, $routeParams.subTaskId)
        .then(function (result) {
            $scope.tittle = result.data.tittle;
            $scope.description =result.data.description;
            $scope.startDate = new Date(result.data.startDate);
            $scope.dueDate = new Date(result.data.dueDate);
            $scope.assignee = result.data.assignee;
            $scope.isComplated = result.data.isComplated;
        })
        .catch(function (error) {
            console.log(error);
        })
        $scope.editSubTask=function(){
            
            taskManagementFactory.editTask(sessionObject.userId,$routeParams.taskId,{
              "tittle": $scope.tittle,
              "description": $scope.description,
              "startDate": $scope.startDate,
              "dueDate": $scope.dueDate,
              "assignee": $scope.assignee,
              "priority": $scope.priority,
              "isComplated": $scope.isComplated
            })
            .then((result)=>{
              $window.alert(result.data.message);
              $location.path('/task');
            })
            .catch((error)=>{
                console.log(error);
            });
      };
}]);

taskManagementApp.controller('profileController', ['$scope', '$rootScope', 'taskManagementFactory', '$window', '$location', function ($scope, $rootScope, taskManagementFactory, $window, $location) {
    $rootScope.headerVisible = false;
    $rootScope.navigationBarVisible = true;
    sessionObject = JSON.parse($window.sessionStorage.getItem("taskManagementSystem"));

    taskManagementFactory.getUserById(sessionObject.userId).
    then(function(result){
        console.log(result);
        
        $scope.firstName=result.data.firstName;
        $scope.lastName=result.data.lastName;
        $scope.gender=result.data.gender;
        $scope.birthOfDate=new Date(result.data.birthOfDate);
        $scope.contactNo=result.data.contactInfo.contactNo;
        $scope.country=result.data.contactInfo.address.country;
        $scope.state=result.data.contactInfo.address.state;
        $scope.city=result.data.contactInfo.address.city;
        $scope.street=result.data.contactInfo.address.street;
        $scope.houseNumber=result.data.contactInfo.address.houseNumber;
        $scope.emailId=result.data.contactInfo.emailId;
    })
    .catch(function(error){
        console.log(error);
    })

    $scope.profileUpdate=function(){
        taskManagementFactory.updateUser(sessionObject.userId,{
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
            "emailId": $scope.emailId
        })
        .then(function (result) {
            $window.alert(result.data.message);
            $location.path('/task');
        })
        .catch(function (error) {
            console.log(error);
        })
    };
}]);

taskManagementApp.filter('priorityFilter', function () {
    return function (priority) {
        if (priority == "important")
            return "lightblue";
        if (priority == "idel")
            return "#d4d1c9";
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