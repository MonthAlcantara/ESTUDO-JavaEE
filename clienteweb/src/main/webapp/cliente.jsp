<!DOCTYPE html>
<%@page import="br.com.monthalcantara.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="cliente">
		Registro de Cliente<br /> E-mail: <input type="text" name="email"
			value="" /><br /> <br /> <input type="submit" value="Salvar" />
	</form>
	<%
		List<Cliente> listar = (List<Cliente>) request.getAttribute("lista");
		for (Cliente c : listar) {
			out.print(c.getEmail() + "<br/>");
		}
	%>

</body>
</html>