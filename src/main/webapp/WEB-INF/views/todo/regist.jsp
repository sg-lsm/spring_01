<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
    <form action="/todo/regist" method="post">
        <div>
            Title: <input type="text" name="title" />
        </div>
        <div>
            localDate: <input type="date" name="localDate" value="2022-12-12" />
        </div>
        <div>
            Writer: <input type="text" name="writer"  />
        </div>
        <div>
            Finished: <input type="checkbox" name="finished" />
        </div>
        <div>
            <button type="submit">submit</button>
        </div>
    </form>
</body>
</html>