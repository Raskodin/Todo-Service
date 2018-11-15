<%@ include file="../common/header.jspf"%>

<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${username}</H1>

	Your Todos are:
	<!--   <display:table name="todos" class="table table-zebra padding nth-child" style="nth-child">
	 	<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th> 
		</thead>
	 	<display:column property="description"/>
	 	<display:column property="category"/>
	 	
	 	
	 	
	 </display:table> -->
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
					<td>${todo.description}</td>
					<td>${todo.category}</td>
					<td><a class="btn btn-default" href="/edit-todo.do?todoid=${todo.id}">Edit</a>&nbsp;
						<a class="btn btn-danger " href="/delete-todo.do?todoid=${todo.id}"  id="deleteButton" >Delete</a>
						<p hidden id="link">/delete-todo.do?todoid=${todo.id}</p>
						<button hidden type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#deleteTodo">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</caption>
	</table>

	<a class="btn btn-success" href="/add-todo.do">Add New Todo</a>

</div>
<div class="modal" id="deleteTodo">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Are you sure?</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">You are about to delete this Todo, are
				you sure about that?</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<a type="button" class="btn btn-danger " href="#link">
					Delete</a>
			</div>

		</div>
	</div>
</div>


<%@ include file="../common/footer.jspf"%>