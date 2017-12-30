<script type="text/javascript" src="javaScript/headerJoinScript.js"></script>
<div id="containerBottoneRegistrazione">
	<ul>
		<li id="buttonRegistrati" class="showForm">Registrati</li>
	</ul>
	<ul>
		<li id="buttonAccedi" class="showForm1">Accedi</li>
	</ul>
</div>

<div id="containerLogo" style="border: medium;">
	<a href="index.jsp"><img alt="logo" src="logo/logo.png" width="200" height="200"></a>
</div>

<div id="containerAutenticazione">
	<div id="containerForm">
		<div id="registerForm">
			<form method="post" action="RegisterServlet" name="register">

				<div id="divLabel">
					<label>Email</label>
				</div>

				<input type="text" name="emailRegistrazione" />

				<div id="divLabel">
					<label>Numero di Telefono</label>
				</div>

				<input type="text" name="numTelefono" />

				<div id="divLabel">
					<label>Nome</label>
				</div>

				<input type="text" name="nome" />

				<div id="divLabel">
					<label>Cognome</label>
				</div>

				<input type="text" name="cognome" />

				<div id="divLabel">
					<label>Username</label>
				</div>

				<input type="text" name="username" />

				<div id="divLabel">
					<label>Password</label>
				</div>
				
				<input type="password" name="passwordRegistrazione" /> 
				
				<input type="submit"
					value="Registrati" id="inputRegistrati" />

			</form>
		</div>

		<div id="loginForm">
			<form method="post" action="LoginServlet" name="login">

				<div id="divLabel">
					<label>Username</label>
				</div>

				<input type="text" name="usernameLogin" />

				<div id="divLabel">
					<label>Password</label>
				</div>

				<input type="password" name="passwordLogin" /> <input type="submit"
					value="Accedi" id="inputAccedi" />
			</form>
		</div>
	</div>
</div>