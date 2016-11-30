<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>NSERC's Awards Database</title>
	<style type="text/css">
	body {
		background-image: url('http://www.planwallpaper.com/static/images/Background.jpg');
	}
	</style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> 
	<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
</head>


<body>
	<header class="container">
    	<div class="row" style="display:flex">
      		<h1 class="col-sm-8">NSERC's Awards Database</h1>
      		<nav class="col-sm-4">
        		<ul class="navBar">
        			<li style="margin-left: 50px;font-family: 'Times New Roman', Georgia, Serif;font-size: 20px;"><a href="/nsercServer">Home</a></li>
					<li style="margin-left: 50px;font-family: 'Times New Roman', Georgia, Serif;font-size: 20px;"><a href="about.html">About</a></li>
        		</ul>
      		</nav>
    	</div>
  	</header>

	
	
	<section class="jumbotron" style="padding:50px;height:500px;background-image:url('http://www.planwallpaper.com/static/images/Background.jpg');">
		<ul class="nav nav-tabs" style="background-image:url('http://www.planwallpaper.com/static/images/Background.jpg');">
			<li class="active"><a name="individuals" href="/nsercServer" data-toggle="tab" style="background-color:#F6F654;opacity:0.6;">Introduction</a></li>
			<li><a href="welcome.html" data-toggle="tab">Detailed List</a></li>
			<li><a href="year.html" data-toggle="tab">Competition Year</a></li>
			<li><a href="institution.html" data-toggle="tab">Institution</a></li>
		</ul>

		<div>
            <ul style="background-image:url('http://www.planwallpaper.com/static/images/Background.jpg');">
                <li><a href="welcome.html">Detailed List</a>
                <p style="font-family: 'Times New Roman', Georgia, Serif;font-size: 15px;"> - displays a full detailed list and allows you to search for a title by keywords. </p></li>
                <li><a href="year.html">Competition Year</a>
                <p style="font-family: 'Times New Roman', Georgia, Serif;font-size: 15px;"> - displays a full detailed list by competition year and allows you to search for a specific year. </p></li>
                <li><a href="institution.html">Institution</a>
                <p style="font-family: 'Times New Roman', Georgia, Serif;font-size: 15px;"> - displays a full detailed list by institution and provides a summary of all institutions. </p></li>
            </ul>
        </div>
	</section>
</body>
</html>