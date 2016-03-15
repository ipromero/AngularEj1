var app=angular.module("app",['ngRoute']);

app.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/consulta/:nId', {
	    templateUrl: "consulta.jsp",
	    controller: "DetalleProductoController"
	     
	    });
	
}]);
  

app.filter("filteri18n",["$filter",function($filter) {
	  var filterFn=$filter("filter");
	   
	  /** Transforma el texto quitando todos los acentos diéresis, etc. **/
	  function normalize(texto) {
	    texto = texto.replace(/[áàäâ]/g, "a");
	    texto = texto.replace(/[éèëê]/g, "e");
	    texto = texto.replace(/[íìïî]/g, "i");
	    texto = texto.replace(/[óòôö]/g, "o");
	    texto = texto.replace(/[úùüü]/g, "u");
	    texto = texto.toUpperCase();
	    return texto;
	  }
	    
	  /** Esta función es el comparator en el filter **/
	  function comparator(actual, expected) {
	      if (normalize(actual).indexOf(normalize(expected))>=0) {
	        return true;
	      } else {
	        return false;
	      }
	  }
	   
	  /** Este es realmente el filtro **/
	  function filteri18n(array,expression) {
	    //Lo único que hace es llamar al filter original pero pasado
	    //la nueva función de comparator
	    return filterFn(array,expression,comparator)
	  }
	   
	  return filteri18n;
	   
	}]);


app.controller('StationeryController',[ '$scope', '$http', '$log', function($scope, $http, $log) {
	$scope.filtro = {
		      sDescripcion: ""
	}
	$scope.productos = [];
	
  $scope.producto={
		  nId:"",
		  sDescripcion:"",
		  sMarca:"",
		  nStock:""
  }
  $scope.productoe={
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
   
	
	$log.debug("Se ha creado el $scope");
	
	$scope.list = [];
	$scope.submit = function() {
		
		
		var formData = {
				  "nId" : $scope.nId,
				  "sDescripcion" : $scope.sDescripcion,
				  "sMarca" : $scope.sMarca,
				  "nStock" : $scope.nStock
		};
			
		var response = $http.post('PostFormData', formData);
		response.success(function(data, status, headers, config) {
			$scope.list.push(data);
			$scope.productos = data;
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
		
		
		//Empty list data after process
		//$scope.list = [];
	};
	
	$scope.consultar = function(id) {
		$log.debug("Consultar  "+id);
		
	}
	
	$scope.eliminar = function(id) {
		$log.debug("Eliinar  "+id);
		
		var response = $http.post('eliminar', id);
		response.success(function(data, status, headers) {
			$scope.productos = data;
			$log.debug("Eliminado  ");
		});
		response.error(function(data, status, headers) {
			alert( "EliminarExceptiondetails:    " + status);
		});
	}
	
	$scope.editar = function(id) {
		$log.debug("Editar... X "+id);
		
		var response = $http.post('editar', id);
		response.success(function(data, status, headers) {
			$scope.productoe = data;
			$log.debug("ParaEditar  ");
		});
		response.error(function(data, status, headers) {
			alert( "EditarExceptiondetails:    " + status);
		});
	}
	
	$scope.salvare=function(){
		$log.debug("Salvar cambios... X "+$scope.productoe.sDescripcion);
		var formDataSE = {
				  "nId" : $scope.productoe.nId,
				  "sDescripcion" : $scope.productoe.sDescripcion,
				  "sMarca" : $scope.productoe.sMarca,
				  "nStock" : $scope.productoe.nStock
		};
		var response = $http.post('salvare', formDataSE);
		response.success(function(data, status, headers) {
			$scope.productos = data;
			$log.debug("Salvado edicion ");
		});
		response.error(function(data, status, headers) {
			alert( "SalvarEditadoExceptiondetails:    " + status);
		});
	}
}])




app.controller('DetalleProductoController',[ '$scope', '$http', '$log', '$config', function($scope, $http, $log, $config ) {
   
	$scope.filtro = {
		      sDescripcion: ""
	}
	$scope.productos = [];
	

	$log.debug("Regreamos");
	
	$scope.regresar = function() {
		var formRes = "regresar";			
		var response = $http.post('regresar', formRes);
		response.success(function(data, status, headers, config) {
			$scope.productos = data;
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception detailsRegresa: " + JSON.stringify({data: data}));
		});
	};
	
	
	$scope.submit = function() {
		$log.debug("n submit");
		var formDataS = {
				  "nId" : $scope.nId,
				  "sDescripcion" : $scope.sDescripcion,
				  "sMarca" : $scope.sMarca,
				  "nStock" : $scope.nStock
		};
			
		var response = $http.post('PostFormDataS', formDataS);
		response.success(function(data, status, headers, config) {
			
			alert(""+data);
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception detailsSalvaModificacion: " );
		});
		
	};
	
	
	$scope.consulta = function(id) {
		$log.debug("Consultar  "+id);
		
	}
}])
