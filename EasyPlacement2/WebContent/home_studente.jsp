<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="includesPage/stylesheets.html"%>
<style type="text/css">
#leftsideNav {
	font-family: sans-serif;
	border: 3px solid;
	margin: 100px 10px;
	padding: 5px;
	width: 150px;
}

#leftside ul li {
	list-style-type: none;
	padding: 10px;
	border: 3px solid;
	margin-top: 15px;
	margin-bottom: 15px;
	margin-left: 10px;
	margin-right: 10px;
	background-color: #ff8221;
	cursor: pointer;
}

#leftside ul li a {
	text-align: center;
	font-size: 11px;
	font-family: sans-serif;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>



	<div id="containerLogo" style="margin-top: 50px; width: 100px">
		<img alt="logo" src="logo/logo.png" width="200" height="200"
			style="margin-top: 10px">
	</div>




	<div id="leftside" class="grid_3">
		<div>
			<ul id="leftsideNav">
				<li><a href=""> Richiesta Studente</a></li>
				<li><a href="">Consulta Registro</a></li>
				<li><a href=""> Compila questionario</a></li>
			</ul>
		</div>
	</div>

</body>
</html>

