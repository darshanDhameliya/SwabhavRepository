let taskManagementLib=angular.module("taskManagementLib",[]);

taskManagementLib.factory('taskManagementFactory',['$q','$http',function($q,$http){
    let services={};
    let url="http://localhost:8080/api/v1/";
    services.logIn=function(data){
        return $q(function(resolved,rejected){
            $http.post(url+"login",data)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.register=function(data){
        return $q(function(resolved,rejected){
            $http.post(url+"register",data)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.displayTask=function(userId){
        return $q(function(resolved,rejected){
            $http.get(url+"user/"+userId+"/task")
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.displaySubTask=function(userId,taskId){
        return $q(function(resolved,rejected){
            $http.get(url+"user/"+userId+"/task/"+taskId+"/subTask")
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    return services;
}]);