<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<!--This is the index view jsp -->
		<c:if test="${! empty errorMessage}">
			<!-- Displays error message -->
			<div class="error">${errorMessage}</div>
		</c:if>
		
		<!-- There are 3 form sections, each with their own "submit" button.  When a button
		is pressed, it will execute a doGet (method=doGet) to their respective Servlet-->
		
		<!-- JSP must call doGet -->
		<form action="${pageContext.servletContext.contextPath}/addNumbers" method="doGet">
			<table>
				<tr>
					<td><input type="Submit" name="submit" value="Add Numbers"></td>
				</tr>
			</table>
		</form>
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="doGet">
			<table>
				<tr>
					</td><input type="Submit" name="submit" value="Multiply Numbers"></td>
				</tr>
			</table>
		</form>
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="doGet">
			<table>
				<tr>
					<td><input type="Submit" name="submit" value="Guessing Game"></td>
				</tr>
			</table>
		</form>
		<!--
		<input type="submit" name="submit" value="Add Numbers">
		<input type="submit" name="submit" value="Multiply Numbers">
		<input type="submit" name="submit" value="Guessing Game"> -->
	</body>
</html>
