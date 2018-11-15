<%@ include file="../common/header.jspf"%>
<%@ include file="../common/loginnavigation.jspf"%>

<div class="container">
	<br> <br> <br> <br> <br>
	<H1>
		Welcome to Todo Service <br>
	</H1>
	<font size="6" style="font-style: italic;">Pick a Username and Password:</font>


	<form action="/registration.do" method="post">
		<c:choose>
			<c:when test="${errorMessage!=null}">
				<div class="alert alert-danger">
					<strong>${errorMessage}</strong>
				</div>
			</c:when>
		</c:choose>
		
		Name: <input type="text" name="username" class="form-control" autofocus/> <br>
		Password: <input type="password" name="key" class="form-control">
		<br> <input class="btn btn-outline-warning " type="submit"
			value="Register" />
	</form>


</div>
<%@ include file="../common/footer.jspf"%>
