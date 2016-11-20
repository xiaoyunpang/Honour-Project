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
			<li class="active"><a name="individuals" href="/nsercServer" data-toggle="tab" style="background-color:#F6F654;opacity:0.6;">List of Awards</a></li>
			<li><a href="welcome.html" data-toggle="tab">Competition Year</a></li>
			<li><a href="/nsercServer" data-toggle="tab">University</a></li>
			<li><a href="/nsercServer" data-toggle="tab">Competition Year</a></li>
		</ul>

		<table border="1">
                <th>No</th>
                <th>Title</th>
                <th>Competition Year</th>
                <th>Fiscal Year</th>
                <th>Name</th>
                <th>Institution</th>
                <th>Department</th>
                <th>Province</th>
                <th>Amount</th>
                 
                <c:forEach var="research" items="${listResearches}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${research.title}</td>
                    <td>${research.cYear}</td>
                    <td>${research.fYear}</td>
                    <td>${research.name}</td>
                    <td>${research.institution}</td>
                    <td>${research.department}</td>
                    <td>${research.province}</td>
                    <td>${research.amount}</td>
                             
                </tr>
                </c:forEach>             
            </table>
		<h3>
			
		</h3>
	</section>
</body>
</html>