
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${username}</H1>
	<c:choose>
		<c:when test="${action.equals(\"edit\")}">
			<p>Edit Your Todo</p>
			<form method="post" action="/old-edit-todo.do">
				<input type="hidden" name="todoid" value="${todoid}">
				<input type="hidden" name="action" value="edit">
				<fieldset class="form-group">
					<label> Description: </label><input type="text" name="description" value="${description}"
						class="form-control" />
				</fieldset>
				<fieldset class="form-group">
					<label> Category: </label><input type="text" name="categ" value="${categ}"
						class="form-control" />
				</fieldset>
				<input type="submit" value="Edit" class="btn btn-success" /> &nbsp;
				<a class="btn btn-outline-info" href="/list-todo.do">Back</a>
			</form>
		</c:when>
		<c:when test="${action.equals(\"add\")}">
			<p>Add Your Todo</p>
			<form method="post" action="/old-edit-todo.do">
				<input type="hidden" name="action" value="add">
				<fieldset class="form-group">
					<label> Description: </label><input type="text" name="description"
						class="form-control" />
				</fieldset>
				<fieldset class="form-group">
					<label> Category: </label><input type="text" name="categ"
						class="form-control" />
				</fieldset>
				<input type="submit" value="Add" class="btn btn-success" /> &nbsp;
				<a class="btn btn-outline-info" href="/list-todo.do">Back</a>
			</form>
		</c:when>
	</c:choose>


</div>


<%@ include file="../common/footer.jspf"%>