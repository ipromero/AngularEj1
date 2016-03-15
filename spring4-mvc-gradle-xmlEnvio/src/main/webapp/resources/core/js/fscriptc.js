var app=angular.module("app",[]);

function RemoteResource($http,baseUrl) {
  this.get=function(fnOK,fnError) {
        $http({
          method: 'GET', 
          url: baseUrl+'js/datos.json'
        }).success(function(data, status, headers, config) {
            fnOK(data);
        }).error(function(data, status, headers, config) {
            fnError(data,status);
        });
      }
}
 
function RemoteResourceProvider() {
  var _baseUrl;
  this.setBaseUrl=function(baseUrl) {
    _baseUrl=baseUrl;
  }
  this.$get=['$http',function($http) {
    return new RemoteResource($http,_baseUrl);
  }];
}
 
app.provider("remoteResource",RemoteResourceProvider);
 
app.constant("baseUrl", "");
app.config(['baseUrl', 'remoteResourceProvider',function(baseUrl, remoteResourceProvider) {
    remoteResourceProvider.setBaseUrl(baseUrl);
}]);


/*
 * Se coloca el nombre del serivicio log, si queremos mas, se pueden poner mas
 */
app.controller('SttnyController',[ '$scope', '$http', '$log', function($scope, $http, $log) {
	
  $scope.producto={
		  nId:"",
		  sDescripcion:"",
		  sMarca:"",
		  nStock:""
  }
  
	$scope.isNegativo=function(c) {
	  if (c<0) {
	    return true;
	  } else {
	    return false;
	  }
	}
   
	
	$log.debug("Se ha creado el $scope consulta");
	
	$scope.list = [];
	$scope.submit = function() {
		
		var formData = {
				  "nId" : $scope.nId,
				  "sDescripcion" : $scope.sDescripcion,
				  "sMarca" : $scope.sMarca,
				  "nStock" : $scope.nStock
		};
			
		var response = $http.post('PostFormDataC', formData);
		response.success(function(data, status, headers, config) {
			$scope.list.push(data);
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
		//Empty list data after process
		$scope.list = [];
	};
}])