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
</style>

</head>
<body>

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
	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">

		<div id="formRicerca"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

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
		</div>

		<div id="consultaRegistro"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<h1>CONSULTA REGISTRO ANCORA NON PRONTO</h1>

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

