<%@ include file="../common/header.jspf"%>
<%@ include file="../common/loginnavigation.jspf"%>

<div class="container">
	<br> <br> <br> <br> <br>
	<H1>
		Welcome to Todo Service <br>
	</H1>
	<font size="4" style="font-style: italic;">Please Login:</font>


	<form action="/login.do" method="post">
		<c:choose>
			<c:when test="${errorMessage!=null}">
				<div class="alert alert-danger">
					<strong>${errorMessage}</strong> Try again please:
				</div>
			</c:when>
		</c:choose>
		
		Name: <input type="text" name="username" class="form-control" autofocus /> <br>
		Password: <input type="password" name="key" class="form-control">
		<br> <input class="btn btn-outline-info " type="submit"
			value="Login" />
	</form>


</div>
<%@ include file="../common/footer.jspf"%>
