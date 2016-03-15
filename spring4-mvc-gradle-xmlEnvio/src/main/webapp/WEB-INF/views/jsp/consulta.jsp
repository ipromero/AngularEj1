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

    <title>Dashboard for a grocery.Consulta</title>
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

  <body ng-controller="DetalleProductoController">

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
          <form class="navbar	-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
          
         
          
   
<form data-ng-submit="submit()" class="form-horizontal" role="form" method="post"> 
<div class="jumbotron">
	<div class="container">
		Producto
	  <table>
	    <tbody>
	    <tr>
	    <td>Id</td>
	    <td>${producto.nId}<input type="hidden" ng-model="nId"  class="form-control" ng-init="${producto.nId}" >	    
	    </td>
	    </tr>
	    <tr>
	    <td>Descripcion</td>	<td>
	      <input type="text" ng-model = "sDescripcion" class="form-control" ng-init="${producto.sDescripcion}">
	    </tr>
	    <tr>
	    <td>Marca</td>    <td>
	    <input type="text" ng-model="sMarca" class="form-control" ng-init="${producto.sMarca}">
	    </td>
	    </tr>
	    <tr>
	    <td>Stock</td>    <td>
	    <input type="text" ng-model="nStock" class="form-control" ng-init="${producto.nStock}">
	    </td>
	    
	    </tr>
	    <tr>
	    	<td><a ng-href="../regresar/">Regresar</a></td>
	    	<td><input type="button" ng-click="regresar()" value="Regresa" /></td>
	    </tr>
	    <tr>
	    <td><button type="submit"  class="btn btn-primary btn-sm" >Salvar</button></td>
	    
	    
	    </tr>
	    </tbody>
	    </table>
	
	
	
 
   </div>
    </div>
</form>
    
     <form>
           otro<input type="text" data-ng-model="nId" value="${producto.nId}">
          </form>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../lib/jquery2.js"><\/script>')</script>
    
    
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapM" />
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    
    <spring:url value="/resources/core/js/holder.min.js" var="holderM" />
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
  <spring:url value="/resources/core/css/ie10viewportbug.css" var="ie10viewportbug" />
  <link href="${ie10viewportbug}" rel="stylesheet" />
  <script src="${holderM}"></script>
  <script src="${bootstrapM}"></script>    
  </body>
</html>
