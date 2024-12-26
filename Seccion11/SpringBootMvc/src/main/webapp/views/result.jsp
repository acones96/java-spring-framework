<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <h2>
            <!-- We search for the result value by using jsp code -->
            Result using jsp code : <%= session.getAttribute("result") %>
        </h2>

        <h2>
            <!-- There are certain tags to get the values too -->
            Result using tags : ${result}
        </h2>
    </body>
</html>
