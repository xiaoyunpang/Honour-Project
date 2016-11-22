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
			<li><a name="individuals" href="/nsercServer" data-toggle="tab">Introduction</a></li>
			<li><a href="welcome.html" data-toggle="tab">Detailed List</a></li>
			<li class="active"><a href="year.html" data-toggle="tab" style="background-color:#F6F654;opacity:0.6;">Competition Year</a></li>
			<li><a href="/nsercServer" data-toggle="tab">Competition Year</a></li>
		</ul>

		<table border="1">
                <th>No</th>
                <th>Competition Year</th>
                <th>Title</th>
                <th>Fiscal Year</th>
                <th>Name</th>
                <th>Institution</th>
                <th>Department</th>
                <th>Province</th>
                <th>Amount($)</th>
                <th>Program</th>
                <th>Committee</th>
                <th>Subject</th>

                <tr>
                    <td></td>
                    <td><form action="yearS.html" method="POST"><input type="text" name="cyear"><input type="submit" value="Search" /></form></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                 
                <c:forEach var="research" items="${listResearches}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${research.cYear}</td>
                    <td>${research.title}</td>
                    <td>${research.fYear}</td>
                    <td>${research.name}</td>
                    <td>${research.institution}</td>
                    <td>${research.department}</td>
                    <td>${research.province}</td>
                    <td>${research.amount}</td>
                    <td>${research.program}</td>
                    <td>${research.committee}</td>
                    <td>${research.subject}</td>
                             
                </tr>
                </c:forEach>             
            </table>
		<div style="display:inline-block;float:right;position:relative;right:50%;">
			<a href="yearP.html" style="display:inline-block;">Previous</a>
			<p style="display:inline-block;">${pageNum}</p>
			<a href="yearN.html" style="display:inline-block;">Next</a>
		</div>
	</section>
</body>
</html>