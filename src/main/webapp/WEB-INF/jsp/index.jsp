<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz - Login</title>
    <mvc:resources mapping="/resources/**" location="/resources/static/" />
    <link href="/style/style.css" rel="stylesheet"/>
</head>
<body>
    <main>
        <div>
            <h1>Quiz - Login</h1>
            <form action="/login" method="post">
                <div>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" />
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" />
                </div>
                <div>
                    <input type="submit" value="Login" />
                </div>
            </form>
        </div>
        <div>
            <h1>Quiz - Register</h1>
            <form action="/reg" method="post">
                <div>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" />
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" />
                </div>
                <div>
                    <label for="password2">Repeat password</label>
                    <input type="password" name="password2" id="password2" />
                </div>
                <div>
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" />
                </div>
                <div>
                    <input type="submit" value="Register" />
                </div>
            </form>
        </div>
    </main>
</body>
</html>