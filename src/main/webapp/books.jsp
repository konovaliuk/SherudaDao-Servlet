<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Books</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/library/'">Home</button>
     </div>
     <form action="/app/library/" method="post">
                  <div visible="hidden">
                      <input type="hidden" name="command" value="deleteBook">
                  </div>

                  <label><b>Delete book by id</b></label>
                  <input name="book_id" type="text" placeholder="Enter id" required>
                  <button type="submit">Delete</button>

          </form>
          <form action="/app/library/" method="post">
                            <div visible="hidden">
                                <input type="hidden" name="command" value="addBook">
                            </div>

                            <label><b>Add book</b></label>
                            <input name="name" type="text" placeholder="Enter name" required>
                            <button type="submit">Add</button>

                    </form>

           <form action="/app/library/" method="post">
                                       <div visible="hidden">
                                           <input type="hidden" name="command" value="addGenreToBook">
                                       </div>

                                       <label><b>Add genre to book</b></label>
                                       <input name="book_id" type="text" placeholder="Enter book id" required>
                                       <input name="name" type="text" placeholder="Enter name" required>
                                       <input name="genre_id" type="text" placeholder="Enter genre id" required>
                                       <input name="genre_name" type="text" placeholder="Enter genre name" required>
                                       <button type="submit">Add</button>

                               </form>
    <c:forEach var="book" items="${requestScope.books}">
          "${book.id()}"
          "${book.name()}"
          "${book.date()}"
    <hr>

                </c:forEach>
</body>
</html>