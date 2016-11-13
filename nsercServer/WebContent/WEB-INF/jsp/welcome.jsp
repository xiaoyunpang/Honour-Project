<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>NSERC's Awards Database</title>
<style type="text/css">
body {
	background-image: url('http://bjstlh.com/data/wallpapers/58/WDF_1045830.jpg');
}
</style>
</head>
<body>
	<h1>NSERC's Awards Database</h1>
	<br>
	<div align="center">
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
			<a href="welcome.html">Click here to See Welcome Message... </a>(to
			check Spring MVC Controller... @RequestMapping("/welcome"))
		</h3>
	</div>
</body>
</html>