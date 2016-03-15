<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html ng-app="app" lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard for a stationary.Alta</title>
    <spring:url value="/resources/core/js/angular.min.js" var="angular" />
    <spring:url value="/resources/core/js/fscript.js" var="fScript" />
    <spring:url value="/resources/core/js/angular-route.min.js" var="angRoute" />
    
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/core/css/ie10viewportbug.css" var="ie10viewPort" />
    <spring:url value="/resources/core/css/dashboard.css" var="dashBoard" />    
    <spring:url value="/resources/core/js/ie-emulation-modes-warning.js" var="emulationW" />
        
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${ie10viewPort}" rel="stylesheet" />
    <link href="${dashBoard}" rel="stylesheet" />
 	<script src="${emulationW}"></script>
	<script src="${angular}"></script>
	<script src="${fScript}"></script>
    <script src="${angRoute}"></script>
  </head>

  <body ng-controller="StationeryController">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Stationary app</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="alta">Alta Producto</a></li>
            <li><a href="baja">Baja Producto</a></li>
            
            
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Alta de Producto</h1>
		
		<form data-ng-submit="submit()" class="form-horizontal" role="form"> 
		  <div class="form-group">
		    <label for="sDescripcion" class="col-lg-2 control-label">Producto</label>
		    <div class="col-lg-10">
		      <input type="text" class="form-control" data-ng-model="sDescripcion">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="sMarca" class="col-lg-2 control-label">Marca</label>
		    <div class="col-lg-10">
		      <input type="text" class="form-control" data-ng-model="sMarca">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="nStock" class="col-lg-2 control-label">Stock</label>
		    <div class="col-lg-10">
		      <input type="text" class="form-control" data-ng-model="nStock">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-lg-offset-2 col-lg-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"> No cerrar sesión
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-lg-offset-2 col-lg-10">
		      <button type="submit"  class="btn btn-primary btn-sm" >Enviar</button>
		    </div>
		  </div>
		  
		   <div class="col-lg-10">
		      El Nº de productos es:<input type="text" class="form-control" data-ng-model="productos.length">
		    </div>
		    <br/> <br/> 
	Filtrar por producto:<input type="text" ng-model="filtro.sDescripcion" >
     <table>
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Descripcion</th>
	        <th>Marca</th>
	        <th>Stock</th>
	      </tr>
	    </thead>	   
	    <tbody>
	    <tr ng-repeat="producto in productos | filteri18n:{sDescripcion:filtro.sDescripcion}" ng-style="{color:($odd?'red':'green')}">
	    <td><a ng-href="./consulta/{{producto.nId}}">{{producto.nId}}</a></td>
	    	<td>{{producto.sDescripcion}}</td>
	        <td>{{producto.sMarca}}</td>
	        <td>{{producto.nStock}}</td>
	       <td><input type="button" ng-click="eliminar( producto.nId )" value="Eliminar" /></td>
	       <td><input type="button" ng-click="editar( producto.nId )" value="Editar" /></td>
	    </tr>
	    </tbody>
	    </table>
	    
	  
	    
	</form>
		
		
		<form data-ng-submit="salvare()" class="form-horizontal" role="form"> 
		 <br/> <br/><br/> 
	
     <table>
	    <tbody>
	    <tr>
	    <td>Id</td><td>{{productoe.nId}}
	    <input type="hidden" ng-model="productoe.nId" ng-init="nIde='${productoe.nId}'" >
	    </td>
	    </tr>
	    <tr>
	    <td>Poducto</td><td><input type="text" ng-model="productoe.sDescripcion" ng-init="sDescripcion2='${productoe.sDescripcion}'"/> </td>
	    </tr>
	    <tr>
	    <td>Marca</td><td><input type="text" ng-model="productoe.sMarca" ng-init="sMarcae='${productoe.sMarca}'"/> </td>
	    </tr>
	    <tr>
	    <td>Stock</td><td><input type="text" ng-model="productoe.nStock"  ng-init="nStocke='${productoe.nStock}'"/> </td>
	    </tr>
	    <tr>
	    <td>  -</td><td><button type="submit"  class="btn btn-primary btn-sm" >Salvar</button></td>
	    </tr>
	    </tbody>
	    </table>    
	    
		</form>
          
        </div>
      </div>
    </div>

	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../lib/jquery2.js"><\/script>')</script>
    
    
    
    
    <spring:url value="/resources/core/js/holder.min.js" var="holderM" />
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
  <spring:url value="/resources/core/css/ie10viewportbug.css" var="ie10viewportbug" />
  <link href="${ie10viewportbug}" rel="stylesheet" />
  <script src="${holderM}"></script>
  
  </body>
</html>
