<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<h1>What you want to say is : ${saying}</h1>
${data}

<form role="form" method="get" action="/show">
	<label>phenotype:</label>
	<input name="phenotype" type="text"></input><button class="btn btn-primary" type="submit">submit</button>
</form>
</body>
</html>
