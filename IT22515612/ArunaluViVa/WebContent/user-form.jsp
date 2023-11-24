<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Data Enter Form</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script>
        function validateForm() {
            var startTime = document.forms["updateForm"]["starttime"].value;
            var endTime = document.forms["updateForm"]["endtime"].value;

            // Convert start time to lowercase
            document.forms["updateForm"]["starttime"].value = startTime.toLowerCase();

            // Convert end time to lowercase
            document.forms["updateForm"]["endtime"].value = endTime.toLowerCase();

            // Ensure the values entered in the first and fifth columns are strings
            var trainName = document.forms["updateForm"]["trainname"].value;
            var date = document.forms["updateForm"]["date"].value;

            // Check if the values are strings
            if (typeof trainName !== 'string' || typeof date !== 'string') {
                alert("Please enter string values for Train Name and Date.");
                return false;
            }

            // Time format validation
            var timeRegex = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/;
            if (!timeRegex.test(startTime) || !timeRegex.test(endTime)) {
                alert("Invalid time format. Please enter time in the format HH:MM.");
                return false;
            }

            // Check if end time is after start time
            var start = new Date("2000-01-01 " + startTime);
            var end = new Date("2000-01-01 " + endTime);

            if (end <= start) {
                alert("End time should be after start time.");
                return false;
            }

            return true; // Allow form submission if validation passes
        }
    </script>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            Train Reservation System
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">TRAINRIDERS</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${train != null}">
                <form name="updateForm" action="update" method="post">

            </c:if>
            <c:if test="${train == null}">
                <form name="updateForm" action="insert" method="post">
            </c:if>

            <caption>
                <h2>
                    <c:if test="${train != null}">Edit User</c:if>
                    <c:if test="${train == null}">Add New User</c:if>
                </h2>
            </caption>

            <c:if test="${train != null}">
                <input type="hidden" name="id" value="<c:out value='${train.id}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>Train Name</label>
                <input type="text" class="form-control" name="trainname" value="<c:out value='${train.trainname}' />" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Start Station</label>
                <input type="text" class="form-control" name="startstation" value="<c:out value='${train.startstation}' />">
            </fieldset>

            <fieldset class="form-group">
                <label>End Station</label>
                <input type="text" class="form-control" name="endstation" value="<c:out value='${train.endstation}' />">
            </fieldset>

            <fieldset class="form-group">
                <label>Date</label>
                <input type="text" class="form-control" name="date" value="<c:out value='${train.date}' />">
            </fieldset>

            <fieldset class="form-group">
                <label>Start Time</label>
                <input type="text" class="form-control" name="starttime" value="<c:out value='${train.starttime}' />">
            </fieldset>

            <fieldset class="form-group">
                <label>End Time</label>
                <input type="text" class="form-control" name="endtime" value="<c:out value='${train.endtime}' />">
            </fieldset>

            <button type="submit" class="btn btn-success" onclick="return validateForm()">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
