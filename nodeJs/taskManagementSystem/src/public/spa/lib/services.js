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
    services.getUserById=function(userId){
        return $q(function(resolved,rejected){
            $http.get(url+"user/"+userId)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.updateUser=function(userId,data){
        return $q(function(resolved,rejected){
            $http.put(url+"user/"+userId,data)
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
    services.addTask=function(userId,data){
        return $q(function(resolved,rejected){
            $http.post(url+"user/"+userId+"/task",data)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.getTaskById=function(userId,taskId){
        return $q(function(resolved,rejected){
            $http.get(url+"user/"+userId+"/task/"+taskId)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.editTask=function(userId,taskId,data){
        return $q(function(resolved,rejected){
            $http.put(url+"user/"+userId+"/task/"+taskId,data)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.deleteTask=function(userId,taskId){
        return $q(function(resolved,rejected){
            $http.delete(url+"user/"+userId+"/task/"+taskId)
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
    services.addSubTask=function(userId,taskId,data){
        return $q(function(resolved,rejected){
            $http.post(url+"user/"+userId+"/task/"+taskId+"/subTask",data)
            .then(function(result){
                resolved(result);
            })
            .catch(function(error){
                rejected(error);
            })
        });
    };
    services.deleteSubTask=function(userId,taskId,subTaskId){
        return $q(function(resolved,rejected){
            $http.delete(url+"user/"+userId+"/task/"+taskId+"/subTask/"+subTaskId)
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