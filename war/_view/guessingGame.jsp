<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Guessing Game</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="post">
			<c:if test="${empty game}">
				<!-- Sets up game -->
				<input name="startGame" type="submit" value="Start game" />
			</c:if>
			<!-- Two tests to check if their is a game (! empty game) and if the game is over (game.done).
			game.done calls the model's isDone().  If expecting boolean return type for testing, Java will search for is__() in model-->
			<c:if test="${! empty game}">
				<c:if test="${game.done}">
					<div>
						The number you are thinking of is ${game.guess}
					</div>
					<div>
						<input name="startGame" type="submit" value="Play again" />
					</div>
				</c:if>
				<!-- game.guess calls the model's getGuess()-->
				<c:if test="${!game.done}">
					<div>
						Are you thinking of ${game.guess}?
					</div>
					<div>
						<!-- making that buttons, value is the string that will display on the button -->
						<input name="gotIt" type="submit" value="Yes, that's it!" />
						<input name="less" type="submit" value="No, that's too big" />
						<input name="more" type="submit" value="No, that's too small" />
						
						<!-- Way to remeber what min and max are for the browser (we don't want user to see this so its hidden)-->
						<input name="min" type="hidden" value="${game.min}" />
						<input name="max" type="hidden" value="${game.max}" />
					</div>
				</c:if>
			</c:if>
		</form>
	</body>
</html>