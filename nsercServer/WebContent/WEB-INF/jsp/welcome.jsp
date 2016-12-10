<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<li class="active"><a href="welcome.html" data-toggle="tab" style="background-color:#F6F654;opacity:0.6;">Detailed List</a></li>
		</ul>

		<div>
  		<form action="welcomeS.html" method="POST">
		<table>
			<tr>
				<td>Competition Year:</td>
				<td><select name="cyear">
					<option selected>${selectedCyear}</option>
					<c:forEach var="c" items="${cyearList}">
                		<option value=${c}>${c}</option>
                	</c:forEach>
				    </select>
                </td>

                <td>Department:</td>
				<td><select name="lname">
					<option selected>${selectedLname}</option>
					<c:forEach var="n" items="${lnameList}">
                		<option value="${n}">${n}</option>
                	</c:forEach>
				    </select>
                </td>
            </tr>

            <tr>
                <td>Province:</td>
				<td><select name="province">
					<option selected>${selectedProvince}</option>
					<c:forEach var="p" items="${provinceList}">
                		<option value="${p}">${p}</option>
                	</c:forEach>
				    </select>
                </td>

                <td>Institution:</td>
				<td><select name="institution">
					<option selected>${selectedInstitution}</option>
					<c:forEach var="i" items="${institutionList}">
                		<option value="${i}">${i}</option>
                	</c:forEach>
				    </select>
                </td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" value="Search"/></td>
			</tr>
		</table>
		</form>
  	</div>

		<table border="1">
                <th>No</th>
                <th>Title</th>
                <th>Competition Year</th>
                <th>Fiscal Year</th>
                <th>Name</th>
                <th>Institution</th>
                <th>Department</th>
                <th>Province</th>
                <th>Amount($)</th>
                <th>Program</th>
                <th>Committee</th>
                <th>Subject</th>
                 
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
                    <td>${research.program}</td>
                    <td>${research.committee}</td>
                    <td>${research.subject}</td>
                             
                </tr>
                </c:forEach>             
            </table>
		<div style="display:inline-block;float:right;position:relative;right:50%;">
			<a href="welcomeP.html" style="display:inline-block;">Previous</a>
			<p style="display:inline-block;">${pageNum}</p>
			<a href="welcomeN.html" style="display:inline-block;">Next</a>
		</div>
	</section>
</body>
</html>