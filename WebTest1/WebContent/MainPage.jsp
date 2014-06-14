
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="SimpleServlet" >
		Username: <input name="Username" /> 
		Password: <input name="Password" /> 
		<button type = "submit" > Login </button>
	</form>
	
	<br>

	<table>
		<c:forEach items = "${DataBase.getForums()}" var = "forum">
			<tr>
				<td>${forum.name}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>

	<form method = "post" action ="EnterForumServlet" >
		Forum List: <select name = "Forums" multiple size = 5 >
		<c:forEach items = "${DataBase.getForums()}" var = "forum">
			<option value = "${forum.name}">  ${forum.name} </option>
				</c:forEach>
		</select>
		<button type = "submit" > Enter </button>
	</form>

</body>
</html>