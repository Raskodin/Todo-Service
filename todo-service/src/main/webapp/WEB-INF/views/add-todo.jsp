
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${username}</H1>
	<p>Add New Todo</p>
	<form method="post" action="/add-todo.do">
		<fieldset class="form-group">
			<label> Description: </label>
			<textarea class="form-control" rows="3" id="desc" name="todo"
				autofocus></textarea>
		</fieldset>
		<fieldset class="form-group">
			<label> Category: </label>
			<textarea class="form-control" rows="2" id="cat" name="categ"></textarea>
		</fieldset>
		<input type="submit" value="Add" class="btn btn-success" /> &nbsp; <a
			class="btn btn-outline-warning" href="/list-todo.do">Back</a>
	</form>
</div>


<%@ include file="../common/footer.jspf"%>
<!-- <script>
    // Run on page load
    window.onload = function() {

        // If sessionStorage is storing default values (ex. name), exit the function and do not restore data
     //   if (sessionStorage.getItem('todo') == "name") {
      //      return;
      //  }

        // If values are not blank, restore them to the fields
        var name = sessionStorage.getItem('todo');
        if (name !== null) $('#desc').val(name);

        var categ = sessionStorage.getItem('categ');
        if (categ !== null) $('#cat').val(categ);


    }

    // Before refreshing the page, save the form data to sessionStorage
    window.onbeforeunload = function() {
        sessionStorage.setItem("todo", $('#desc').val());
        sessionStorage.setItem("categ", $('#cat').val());
    }
</script>  -->