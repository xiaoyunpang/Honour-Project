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
			<li><a href="year.html" data-toggle="tab">Competition Year</a></li>
			<li class="active"><a href="institution.html" data-toggle="tab" style="background-color:#F6F654;opacity:0.6;">Institution</a></li>
		</ul>

		<table border="1">
                <th>No</th>
                <th>Institution</th>
                <th><a href="summaryO.html">Number</a></th>
                <th>Amount($)</th>
                <th>Average Award($)</th>

                <tr>
                    <a href="institution.html" style="font-size:30px;">Back</a>
                </tr>
                 
                <c:forEach var="research" items="${listResearches}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${research.name}</td>
                    <td>${research.number}</td>
                    <td>${research.amount}</td>
                    <td>${research.avg}</td>
                             
                </tr>
                </c:forEach>             
            </table>
		<div style="display:inline-block;">
			<a href="summaryP.html" style="display:inline-block;">Previous</a>
			<p style="display:inline-block;">${pageNum}</p>
			<a href="summaryN.html" style="display:inline-block;">Next</a>
		</div>
	</section>
</body>
</html>