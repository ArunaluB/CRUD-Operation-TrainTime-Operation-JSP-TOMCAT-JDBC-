<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Train Reservation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #00A9FF">
        <div>
            <!-- Your logo or branding can be placed here -->
        </div>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a href="<c:url value='/list'/>" class="nav-link">TRAIN RIDERS</a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Logout</a>
            </li>
        </ul>
    </nav>
</header>

	<main>
		<div class="container">
			<h1>Welcome to Online Train Reservation</h1>
			<p>Book your train tickets online and enjoy a hassle-free
				experience.</p>
		</div>
	</main>

	<div class="container">
		<h3 class="text-center">Views Of Train Times</h3>
		<hr>
		<div class="text-left">
			<a href="<c:url value='/new'/>" class="btn btn-success">Add New
				Train Time</a>
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
						<th>Train Name</th>
						<th>Start Station</th>
						<th>End Station</th>
						<th>Date</th>
						<th>Start Time</th>
						<th>End Time</th>
						<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="train" items="${listTime}">
					<tr>
						<td><c:out value="${train.id}" /></td>
						<td><c:out value="${train.trainname}" /></td>
						<td><c:out value="${train.startstation}" /></td>
						<td><c:out value="${train.endstation}" /></td>
						<td><c:out value="${train.date}" /></td>
						<td><c:out value="${train.starttime}" /></td>
						<td><c:out value="${train.endtime}" /></td>
						<td><a
							href="<c:url value='/edit'><c:param name='id' value='${train.id}'/></c:url>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="<c:url value='/delete'><c:param name='id' value='${train.id}'/></c:url>">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<footer>
		<div class="container">
			<p>&copy; 2023 Online Train Reservation ArunaluBamunusinghe IT22515612. All rights reserved.</p>
		</div>
	</footer>
</body>
</html>
