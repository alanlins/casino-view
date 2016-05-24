<%@page import="java.util.List"%>
<%@page import="br.com.unibratec.usefull.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">

<title>Casino</title>


<link href="css/dashboard.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>

<body>

	<div class="row placeholders">
		<div class="col-xs-6 col-sm-3 placeholder">
			<img src="img/casino.jpg" width="200" height="200" class="img-fluid"
				alt="casino">
		</div>
		<p>
		<h1>
			<span class="text-muted"><b>Welcome to Casino</b></span>
		</h1>
		</p>

		<p style="margin-top: 80px">
		<h3>
			<span class="text-muted"><u>Players List</u></span>
		</h3>
		</p>
	</div>
	<div class="table-responsive">
	<%
	List<Player> players = new ServicesConsumer().getList();

	if (players != null) {
	
	%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nick</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Jogo</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					

						for (int x = 0; x < players.size(); x++) {
				%>
				<form action="register.jsp" method="post">
					<tr>
						<td>
							<%
								out.print(players.get(x).getId());
							%> <input type="hidden" name="id"
							value="<%=players.get(x).getId()%>">
						</td>
						<td>
							<%
								out.print(players.get(x).getNick());
							%> <input type="hidden" name="nick"
							value="<%=players.get(x).getNick()%>">
						</td>
						<td>
							<%
								out.print(players.get(x).getNome());
							%> <input type="hidden" name="name"
							value="<%=players.get(x).getNome()%>">
						</td>
						<td>
							<%
								out.print(players.get(x).getEmail());
							%> <input type="hidden" name="email"
							value="<%=players.get(x).getEmail()%>">
						</td>
						<td>
							<%
								out.print(players.get(x).getJogo());
							%> <input type="hidden" name="game"
							value="<%=players.get(x).getJogo()%>"> 
						</td>
						<td><a href="javascript:document.forms[<%=x%>].submit()">
								<span class="glyphicon glyphicon-pencil"></span>
						</a> <a style="margin-left: 10px"  href="#" class="idToDelete" data-id ="<%=players.get(x).getId()%>"> <span class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</form>
				<%
					}

					} else {

						out.print("0 results.");

					}
				%>




			</tbody>
		</table>
	</div>
		
</body>

