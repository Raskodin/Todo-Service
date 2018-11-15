<%@ include file="../common/header.jspf"%>

<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${username}</H1>

	Your Todos are:
	<table class="table table-striped">
		<caption />
		<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.name}</td>
					<td>${todo.category}</td>
					<td><a class="btn btn-default "
						href="/old-edit-todo.do?todoid=${todo.id}&action=edit">Edit</a>&nbsp;<a class="btn btn-danger "
						href="/old-edit-todo.do?todoid=${todo.id}&action=delete">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-success" href="/old-edit-todo.do?action=add">Add New Todo</a>

</div>

<%@ include file="../common/footer.jspf"%>