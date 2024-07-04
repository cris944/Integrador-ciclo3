<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="shortcut icon" href="assets/images/pagina.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/style.css"/>
        <style>
            body {
                background-image: url('assets/images/planeta-tierra-destello-del-sol_3840x2160_xtrafondos.com.jpg');
                background-size: cover;
            }
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                flex-direction: column;
            }
            .header {
                font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
                color: #1877f2;
                font-size: 3rem;
                font-weight: bold;
                margin-bottom: 1rem;
            }
            .login-container {
                background-color: white;
                padding: 2rem;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                width: 28rem;
                background-color: rgba(255, 255, 255, 0.7); /* Color blanco con 70% de opacidad */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1)
            }
            .login-container img {
                height: 5rem;
                margin-bottom: 1rem;
            }
            .login-container .form-control {
                margin-bottom: 1rem;
                height: 3rem;
                font-size: 1rem;
            }
            .login-container .btn {
                background-color: #1877f2;
                color: white;
                font-size: 1.2rem;
                margin-top: 1rem;
                border-radius: 5px;
                height: 3rem;
            }
            .login-container .text-link {
                color: #1877f2;
                font-size: 0.9rem;
            }
            .login-container .text-link:hover {
                text-decoration: underline;
            }
            .separator {
                display: flex;
                align-items: center;
                text-align: center;
                margin: 1.5rem 0;
            }
            .separator::before, .separator::after {
                content: '';
                flex: 1;
                border-bottom: 1px solid #dcdcdc;
            }
            .separator::before {
                margin-right: .5em;
            }
            .separator::after {
                margin-left: .5em;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">BIENVENIDO</div>
            <div class="login-container">
                <div class="d-flex justify-content-center">
                    <img src="assets/images/login-icon.svg" alt="login-icon"/>
                </div>
                <div class="text-center fs-1 fw-bold">Login</div>
                <form action="lc" method="post">
                    <div class="input-group mt-4">
                        <input class="form-control" type="text" name="username" placeholder="Username" />
                    </div>
                    <div class="input-group mt-1">
                        <input class="form-control" type="password" name="clave" placeholder="Password" />
                    </div>
                    <div class="d-flex justify-content-between mt-1">
                        <div class="d-flex align-items-center">
                            <input class="form-check-input" type="checkbox" />
                            <span class="ms-2 text-link">Remember me</span>
                        </div>
                        <a href="#" class="text-link">Forgot your password?</a>
                    </div>
                    <button type="submit" class="btn w-100">Login</button>
                </form>
                <div class="separator">
                    <span>or</span>
                </div>
                <div class="text-center">
                    <a href="#" class="text-link">Contact us</a>
                </div>
            </div>
        </div>
    </body>
</html>

