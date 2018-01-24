<%@page import="bean.ListaTirocini"%>
<%@page import="bean.ListaUtenti"%>
<%@page import="bean.TutorAziendale"%>
<%@page import="bean.ListaProgettiFormativi"%>
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
<link rel="stylesheet" type="text/css" href="css/inputfirme.css">


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
			<li class=richiestaStudente>Convalida Documento</li>
			<li class=consultaRegistro>Compila Questionario</li>
			<li class=compilaModuli>Firma Presenze</li>
		</ul>
	</div>


	<%
		TutorAziendale tutor_Aziendale = (TutorAziendale) session.getAttribute("user");

		ListaProgettiFormativi lista = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");
	%>

	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">

		<form action="FirmaDocumento" method="post" name="firmadocumento">

			<div id="formRicerca"
				style="position: absolute; top: 50px; height: 100%; width: 100%;"
				class="row">

				<table class="table" style="position: absolute; top: 50px;">
					<%
						for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {

							System.out.println(lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale());
							System.out.println(tutor_Aziendale.getUsername());
							System.out.println(lista.getListaProgettoFormativo().get(i).getId());

							if (lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale()
									.equalsIgnoreCase(tutor_Aziendale.getUsername())) {
								if (lista.getListaProgettoFormativo().get(i).isFirma_Tutor_Aziendale() == false) {
					%>
					<tr>
						<th><%=lista.getListaProgettoFormativo().get(i).getNome()%></th>
						<th><%=lista.getListaProgettoFormativo().get(i).getCognome()%></th>

						<th><input
							style="width: 100%; height: 50px; margin: 0; top: 20px; background-color: #ff8221; border: 1px solid;"
							type="submit" name="action"
							value="Firma<%=" " + lista.getListaProgettoFormativo().get(i).getId()%>"></th>


					</tr>
					<%
						} else {
					%>
					<tr>
						<th>Nessun Studente</th>
					</tr>
					<%
						}
							} else {
					%>
					<tr>
						<th>Nessun Studente</th>
					</tr>
					<%
						}
						}
					%>
				</table>

			</div>

		</form>


		<div id="consultaRegistro"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<h1>COMPILA QUESTIONARIO ANCORA NON PRONTO</h1>

		</div>

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<%
				ListaUtenti listaUtenti = (ListaUtenti) session.getAttribute("listaUtenti");
				ListaTirocini listaTirocini = (ListaTirocini) session.getAttribute("listaTirocini");

				for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
					if (tutor_Aziendale.getUsername()
							.equalsIgnoreCase(lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale())) {
						int id = lista.getListaProgettoFormativo().get(i).getId();
						for (int y = 0; y < listaTirocini.getListaTirocini().size(); y++) {
							if (id == listaTirocini.getListaTirocini().get(y).getId()) {
								for (int z = 0; z < listaUtenti.getListaUtenti().size(); z++) {
									if (id == listaUtenti.getListaUtenti().get(z).getUserId()) {
			%>

			<form action="FirmaPresenza" method="post" name="firmapresenza">

				<div>
					<input style="font-size: 25px; top: 5px;" id="input2" type="text"
						value="Nome Utente" readonly="readonly"> <input
						style="display: none;  -webkit-appearance: none; background-color: #fafafa; border: 1px solid #cacece; box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05); padding: 9px; display: inline-block; position: relative; overflow: hidden;"
						id="input3" type="checkbox" value=""> <label
						style="-webkit-appearance: none; display: inline; background-color: #fafafa; border: 1px solid #cacece; box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05); padding: 9px; display: inline-block; position: relative; overflow: hidden;"
						id="label1">Firma Presenza</label>

				</div>

			</form>








			<%
				}
								}
							}
						}
					}
				}
			%>

		</div>


	</div>
</body>
</html>

