<%@page language="java"contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="model.Cliente"%>
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>Pais</title>

</head>
<body>
<%Cliente cliente = (Cliente)request.getAttribute("cliente"); %>
Id: <%=cliente.getId() %><br>
Pais: <%=cliente.getPais() %><br>
Populacao: <%=cliente.getPopulacao() %><br>
Area: <%=cliente.getArea() %><br>
</body>
</html>