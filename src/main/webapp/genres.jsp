<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Genres</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/library/'">Home</button>
     </div>
    <c:forEach var="genre" items="${requestScope.genres}">
          "${genre.id()}"
          "${genre.name()}"
    <hr>

    </c:forEach>
    <c:forEach var="bookset" items="${requestScope.books}">
              <c:forEach var="book" items="${requestScope.bookset}">
                            "${book.id()}"
                            "${book.name()}"
                            "${book.date()}"

                   </c:forEach>
        <hr>

     </c:forEach>
</body>
</html>