<%@ page import="br.com.unibratec.usefull.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">

<link href="css/dashboard.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<title>Casino New Register</title>
</head>
<body>

	<p>
	<h2>
		<label class="text-muted">Register </label>
	</h2>
	</p>
	<%
		Player player = new Player();
	
		if (request.getMethod() == "POST") {

			Long id = Long.parseLong(request.getParameter("id"));
			player.setId(id);
			player.setNick(request.getParameter("nick"));
			player.setNome(request.getParameter("name"));
			player.setEmail(request.getParameter("email"));
			player.setJogo(request.getParameter("game"));

			

		}
	%>
	<form role="form" action="index.jsp" method="post">

		<input type="hidden" name="id" value="<% if(player.getId()!= null)out.print(player.getId());%>">

		<div class="form-group">
			<label for="nick">Nickname</label> <input type="text"
				class="form-control" name="nick" id="nick"
				placeholder="Enter nickname" value="<% if (player.getId()!= null)out.print(player.getNick()); %>" >
		</div>

		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control" name="name" id="name" placeholder="Enter name" value="<% if (player.getId()!= null)out.print(player.getNome()); %>">
		</div>

		<div class="form-group">
			<label for="email">E-mail</label> <input type="text"
				class="form-control" name="email" id="email"
				placeholder="Enter e-mail" value="<% if (player.getId()!= null)out.print(player.getEmail()); %>">
		</div>
        
		<div class="form-group">
			<label for="game">Game</label> <select class="form-control" id="game"
				name="game" >
				<option  <% if (player.getId()!= null && player.getJogo().equalsIgnoreCase("Poker"))out.print("selected"); %> >Poker</option>
				<option  <% if (player.getId()!= null && player.getJogo().equalsIgnoreCase("Black Jack"))out.print("selected"); %> >Black Jack</option>
				<option  <% if (player.getId()!= null && player.getJogo().equalsIgnoreCase("Roulette"))out.print("selected"); %> >Roulette</option>	
				<option  <% if (player.getId()!= null && player.getJogo().equalsIgnoreCase("Bingo"))out.print("selected"); %> >Bingo</option>
			</select>
		</div>

		<button type="submit" class="btn btn-default">Submit</button>
	</form>

</body>
</html>