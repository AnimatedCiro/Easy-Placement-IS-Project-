<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.ListaProgettiFormativi"%>
<%@page import="bean.TutorAziendale"%>
<%@page import="bean.ListaTirocini"%>
<%@page import="bean.ListaUtenti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPLacement</title>

<%@include file="includesPage/stylesheets.html"%>




<style type="text/css">
label {
	display: unset;
	color: #fff;
	cursor: pointer;
	position: relative;
}

label .check-box-effect {
	display: inline-block;
	position: relative;
	background-color: red;
	width: 25px;
	height: 25px;
	border: 2px solid #dcdcdc;
	border-radius: 10%;
}

label .check-box-effect:before {
	content: "";
	width: 0px;
	height: 2px;
	border-radius: 2px;
	background: #626262;
	position: absolute;
	transform: rotate(45deg);
	top: 13px;
	left: 9px;
	transition: width 50ms ease 50ms;
	transform-origin: 0% 0%;
}

label .check-box-effect:after {
	content: "";
	width: 0;
	height: 2px;
	border-radius: 2px;
	background: #626262;
	position: absolute;
	transform: rotate(305deg);
	top: 16px;
	left: 10px;
	transition: width 50ms ease;
	transform-origin: 0% 0%;
}

label:hover .check-box-effect:before {
	width: 5px;
	transition: width 100ms ease;
}

label:hover .check-box-effect:after {
	width: 10px;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"] {
	display: none;
}

input[type="checkbox"]:checked+.check-box-effect {
	background-color: green !important;
	transform: scale(1.25);
}

input[type="checkbox"]:checked+.check-box-effect:after {
	width: 10px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked+.check-box-effect:before {
	width: 5px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked:hover+.check-box-effect {
	background-color: #dcdcdc;
	transform: scale(1.25);
}

input[type="checkbox"]:checked:hover+.check-box-effect:after {
	width: 10px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked:hover+.check-box-effect:before {
	width: 5px;
	background: #333;
	transition: width 150ms ease 100ms;
}

#nomeUtenteLoggato {
	margin-right: 10px;
	list-style-type: none;
	float: right;
	padding: 5px;
	padding-left: 15px;
	padding-right: 15px;
	border-radius: 5px 5px 5px 5px;
	background-color: #ff8221;
	border-radius: 5px 5px 5px 5px;
}
</style>
</head>
<body>
	<div style="margin-top: 0px;">
		<ul>
			<li style="border: 3px solid;" id="nomeUtenteLoggato"><a
				style="text-decoration: none; color: black;" href="index.jsp">Indietro</a></li>
		</ul>
	</div>
	<div id="containerLogo" style="margin-top: 5px; width: 100px">
		<img alt="logo" src="logo/logo2.png" width="200" height="200"
			style="margin-top: 10px">
	</div>

	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<div class="panel-heading">
				<h2 style="color: #ff8221; size: 100px; font-family: sans-serif;">Firma
					presenza studente</h2>
			</div>


			<%
				String id = request.getParameter("id_studente");
				int idS = Integer.parseInt(id);

				String stringDataInizio = "01/01/2018", stringDataFine = "25/01/2018";

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

				Date dataInizio = df.parse(stringDataInizio);
				Date dataFine = df.parse(stringDataFine);

				GregorianCalendar calInizio = new GregorianCalendar();

				calInizio.setTime(dataInizio);

				GregorianCalendar calFine = new GregorianCalendar();

				calFine.setTime(dataFine);

				

				ListaProgettiFormativi lista = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");

				for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
					if (lista.getListaProgettoFormativo().get(i).getId() == idS) {
						//dataInizio = lista.getListaProgettoFormativo().get(i).getDataInizio();
						//dataFine = lista.getListaProgettoFormativo().get(i).getDataFine();
					}
				}
			%>


			<form action="FirmaPresenza" method="post" name="firmapresenza"
				onsubmit="return(firmaValidator)">
				<input
					style="font-size: 15px; display: none; position: relative; top: 0%; left: 0%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); transform: translate(0%, 0%); width: 150px; padding: 8px; margin-bottom: 0px; margin-top: 0px; border: none; border-radius: 4px; box-sizing: border-box;"
					readonly="readonly" value="<%=id%>"> <label><input
					type="checkbox" id="chkProdTomove" /> <span
					class="check-box-effect"></span> </label> <input
					style="font-size: 15px; background-color: #ff8221; cursor: pointer; position: relative; top: -10px; left: 55%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); curtransform: translate(0%, 0%); width: 70px; padding: 8px; margin-bottom: 0px; margin-top: 0px; display: inline-block; border: 3px solid; border-radius: 4px; box-sizing: border-box;"
					type="submit" value="Firma">
			</form>
			<%
				
			%>
		</div>
	</div>
</body>
</html>