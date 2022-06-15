<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library</title>
</head>
<body>
<div>
    <h1>Library</h1>
</div>

<div>
    <div>
        <button onclick="location.href='/app/library/?command=login'">Login</button>
        <button onclick="location.href='/app/library/?command=register'">Register</button>
        <c:if test = "${sessionScope.registered == true}">
            <button onclick="location.href='/app/library/?command=booksList'">Books</button>
        </c:if>
        <c:if test = "${sessionScope.admin == true}">
            <button onclick="location.href='/app/library/?command=usersList'">Users</button>
        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                            <button onclick="location.href='/app/library/?command=genresList'">Genres</button>
                </c:if>
        <c:if test = "${sessionScope.registered == true}">
                    <button onclick="location.href='/app/library/?command=logOut'">LogOut</button>
        </c:if>

    </div>
</div>
</body>
</html>