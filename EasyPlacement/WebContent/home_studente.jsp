<%@page import="bean.ListaRegistro"%>
<%@page import="bean.Studente"%>
<%@page import="bean.ListaTirocini"%>
<%@page import="bean.Azienda"%>
<%@page import="bean.ListaAziende"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EasyPlacement</title>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="javaScript/librerieJQuery/jquery.js"></script>
<script type="text/javascript" src="javaScript/visualizzaCampi.js"></script>
<%@include file="includesPage/stylesheets.html"%>

<style>
table {
	font-family: arial, sans-serif;
	border-color: white;
	width: 100%;
}

td, th {
	border-color: white;
	text-align: left;
	padding: 8px;
	background-color: white;
}

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
</style>

</head>
<body>

	<%
		try {
	%>

	<div id="containerLogo" style="margin-top: 5px; width: 100px">
		<img alt="logo" src="logo/logo2.png" width="200" height="200"
			style="margin-top: 10px">
	</div>
	<div style="position: absolute;" id="leftside">
		<ul id="leftsideNav">
			<li class=richiestaStudente>Richiesta Studente</li>
			<li class=consultaRegistro>Consulta Registro</li>
			<li class=compilaModuli>Compila questionario</li>
			<li class=progettoFormativo>(DA TOGLIERE)Progetto Formativo</li>
		</ul>
	</div>


	<%
		Studente studente1 = (Studente) session.getAttribute("user");
			ListaTirocini listaTirocini = (ListaTirocini) session.getAttribute("listaTirocini");
			String a = "";

			for (int i = 0; i < listaTirocini.getListaTirocini().size(); i++) {
				if (listaTirocini.getListaTirocini().get(i).getId() == studente1.getUserId()) {
					a = "Tirocinio Approvato";
				}
			}
	%>



	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">

		<div id="formRicerca"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<%
				if (a.equalsIgnoreCase("Tirocinio Approvato")) {
			%>

			<h1><%=a%></h1>
			<%
				} else

					{
			%>


			<form action="RicercaAzienda" method="post" name="ricerca">

				<input id="barraRicerca" name="campoRicerca"
					style="position: absolute; border-radius: 10px 10px 10px 10px; width: 80%; left: 44%; top: -20px;"
					type="text" class="form-control"
					placeholder="Inserisci nome azienda..."> <input
					style="top: -50px; left: 95%; width: 10%" class="btn btn-default"
					type="submit" value="Cerca" id="buttonCerca">

			</form>
			<div style="margin-top: -100px;">
				<table>
					<tr>
						<th><h2>Nome Azienda</h2></th>
						<th><h2>Sede</h2></th>
						<th><h2>Numero Telefonico</h2></th>
						<th><h2>Progetto Offerto</h2></th>
					</tr>

					<%
						if (session.getAttribute("listaAziende") == null) {

								} else {

									ListaAziende listaAziende = (ListaAziende) session.getAttribute("listaAziende");
									for (int i = 0; i < listaAziende.getListaAziende().size(); i++) {
					%>

					<tr>
						<td><ul style="margin: 0px 0px; padding: 0px; width: 150px;">
								<a
									href="progettoFormativo.jsp?nomeAzienda=<%=listaAziende.getListaAziende().get(i).getNome()%>"
									style="text-decoration: none; text-align: center; color: black;"><li><%=listaAziende.getListaAziende().get(i).getNome()%></li></a>
							</ul></td>
						<td><%=listaAziende.getListaAziende().get(i).getSede()%></td>
						<td><%=listaAziende.getListaAziende().get(i).getNumerotelefono()%></td>
						<td><%=listaAziende.getListaAziende().get(i).getProgettoofferto()%></td>
					</tr>
					<%
						}
								}
					%>
				</table>
			</div>


			<%
				}
			%>
		</div>
		<div id="consultaRegistro"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<div class="panel-heading">
				<h2
					style="color: #ff8221; size: 100px; font-family: sans-serif; margin-bottom: 20px;">Registro</h2>
			</div>

			<%
				ListaRegistro registro = (ListaRegistro) session.getAttribute("listaRegistro");

					for (int i = 0; i < registro.getListaRegistro().size(); i++) {
			%>
			<form style="margin-top: 10px;">
				<a style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=registro.getListaRegistro().get(i).getData()%></a><label
					style="left: 100px;"><input type="checkbox"
					checked="checked" disabled="disabled" "
						id="chkProdTomove" />
					<span class="check-box-effect"></span> </label>
			</form>

			<%
				}
				} catch (Exception e) {
					response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
				}
			%>

		</div>

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<h1>COMPILA QUESTIONARIO ANCORA NON PRONTO</h1>

		</div>

		<div id="progettoFormativo"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<h1>PROGETTO FORMATIVO ANCORA NON PRONTO</h1>

		</div>
	</div>
</body>
</html>

