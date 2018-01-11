<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ResponsabileAziendale"%>
<%@page import="model.Studente"%>
<%@page import="model.Utente"%>
<jsp:include page="/includesPage/stylesheets.html"></jsp:include>


<script type="text/javascript">
	$(document).ready(function() {
		$('.utenteLoggato').click(function() {
			$('#buttonLogout').css('display');
			$('#buttonLogout').show();
		});
	});
</script>

<%
System.out.println("sono qui2");
	Utente utente = (Utente) session.getAttribute("user");
	System.out.println("sono qui3");
	if (utente.getUsername().contains("responsabileAziendale")) {
		ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("user");
		String uid = responsabileAziendale.getNomeUtente();
%>

<jsp:include page="/home_responsabileAziendale.jsp"></jsp:include>

<%
	} else {

		Studente studente = (Studente) session.getAttribute("user");
		String userName = studente.getUsername();
		System.out.println(userName);
		int uid = studente.getUserId();

		String inizialeN = studente.getNome().substring(0, 1);
		String finaleN = studente.getNome().substring(1, studente.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = studente.getCognome().substring(0, 1);
		String finaleC = studente.getCognome().substring(1, studente.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a href="LogoutControl">Logout</a></li>
	</ul>
</div>


<%@include file="/home_studente.jsp"%>

<%
	}
%>

