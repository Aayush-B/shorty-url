<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shortyurl.shortyurl.models.UrlDbDetails" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shorty URL - URL Shortening Service</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Shorty-URL</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
		  <ul class="navbar-nav mr-auto">
			<li class="nav-item active">
			  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="#recent-urls">Recent URLs</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="#api">API</a>
			</li>
		  </ul>
		  <span class="navbar-text">
			URL Shortening Service
		  </span>
		</div>
	  </nav>
	  
	  <div class="jumbotron">
		<h1 class="display-4" style="margin-top:40px;">Welcome to Shorty URL</h1>
		<p class="lead">Shorty URL is a URL shortening service designed and implemented as a personal project.</p>
		<hr class="my-4">
		<p> It utilises an MVC structure and has been developed using Spring Boot, HTML, CSS, Bootstrap, JSP and Tomcat v9.0. </p>
		<a class="btn btn-primary btn-lg" href="https://aayushb.com/" role="button">About the developer</a>
	  </div>
	  
	  <div id="home" style="margin-top:200px;">
		<h2 class="text-center">Shortify your URL:</h2>
		<div style="display:flex;justify-content:center;margin-top:50px">
			<form action="compress-url" method="post">
				<input type="text" name="userUrl" placeholder="https://www.google.com/" class="form-control"> 
				<br>
				<div style="display:flex;justify-content:center">
					<button type="submit" class="btn btn-warning"><b>Get Shorty URL</b></button>
				</div>
			</form>
		</div>
	</div>

	  <%
			Map<Object,Object> viewParams=(Map<Object,Object>)request.getAttribute("viewParams") ;
		
			if (viewParams.get("compressedUrl") != null) {
	  %>
	  <br>
	  <div class="alert alert-success text-center" role="alert">
		Your Shorty URL : http://shorty-url.aayushb.com/<%= viewParams.get("compressedUrl") %>
	  </div>
	  <%
			}
	  %>
	  
	  <div id="recent-urls" style="margin-top:200px;">
		<h2 class="text-center">Recent URLs</h2><br>
		<ul class="list-group">
			<%
				List<UrlDbDetails> latestUrls=(List<UrlDbDetails>)viewParams.get("latestUrls") ;
			
				if(latestUrls!=null) {
					
					for(UrlDbDetails urlDbDetails:latestUrls){
			%>
			
			<li class="list-group-item text-center"><%= urlDbDetails.getUserUrl() %></li>
			
			<%
					}
				}
				
			%>
		</ul>
	</div>
	
	<div id="api" style="margin-top:200px;">
		<h2 class="text-center">API</h2><br>
		<ul class="list-group">
			<li class="list-group-item text-center font-weight-bold"><h3 style="margin-top:20px;">POST (Compress URL) : </h3><br><br>
			POST Request @ http://shorty-url.aayushb.com/api/compress-url <br><br>
			Request Body Example :
			{
				"userUrl":"www.google.com"
			}
			</li>
			<li class="list-group-item text-center font-weight-bold"><h3 style="margin-top:20px;">GET (Decompress URL) :</h3>
				<br><br>
			GET Request @ http://shorty-url.aayushb.com/api/decompress-url<br><br>
			Request Body Example : For URL - http://shorty-url.aayushb.com/b : 
			{
				"userUrl":"b"
			}
			</li>
		</ul>
	</div>
	
</body>
</html>