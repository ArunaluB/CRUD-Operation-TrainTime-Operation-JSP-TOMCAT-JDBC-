<!DOCTYPE html>
<html>

<head>
    <title>Login </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS to center the form */
        .centered-form {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh; /* Use min-height instead of height to ensure it adjusts to content */
        }

        /* Custom CSS for the footer */
        .footer {
            text-align: center;
            padding: 10px;
            background-color: #f8f9fa;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>

<body>

<div class="container">
    <!-- Header -->
    
      
    <!-- Login Form -->
    <div class="row centered-form">
        <div class="col-md-4">
        
            <h2 class="text-center">Train Rider Login</h2>
            <form action="<%=request.getContextPath()%>/login" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
        </div>
    </div>
    <!-- Footer -->
    <p class="mt-3 text-center">&copy; 2023 IT22515612. All rights reserved.</p>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
