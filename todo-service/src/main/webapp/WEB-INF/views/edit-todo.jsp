
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	
	<p>Edit Your Todo:</p>
	<form method="post" action="/edit-todo.do">
		<input type="hidden" name="todoid" value="${todoid}">
		<fieldset class="form-group">
			<label> Description: </label><input type="text" name="description" value="${description}" autofocus
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label> Category: </label><input type="text" name="categ" value="${categ}"
				class="form-control" />
		</fieldset>
		<input type="submit" value="Save" class="btn btn-success" /> &nbsp;
		<a class="btn btn-danger " href="/delete-todo.do?todoid=${todoid}">Delete</a> &nbsp;
		 <a class="btn btn-outline-warning" href="/list-todo.do">Back</a>
	</form>
</div>


<%@ include file="../common/footer.jspf"%>