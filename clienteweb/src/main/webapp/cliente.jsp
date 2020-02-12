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
	<div>
		<%
			Object msg = request.getAttribute("msg");
			if (msg != null) {
				String msgStr = (String) msg;
				out.print(msg);
			}
					%>
	</div>
	<form method="post" action="cliente">
		E-mail: <input type="text" name="email" value="" /> <input
			type="submit" value="Salvar" />
	</form>
	<%
		List<Cliente> listar = (List<Cliente>) request.getAttribute("lista");
	int i = 0;
	for (Cliente c : listar) {
			out.print(c.getEmail() +
			" <a href = 'cliente?i=" + i + "'> excluir	</a><br/>");
			i++;
	}
	
	%>

</body>
</html>