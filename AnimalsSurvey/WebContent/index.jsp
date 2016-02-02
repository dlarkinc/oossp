<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <FORM METHOD="POST" ACTION=
         "AnimalsServlet">
         What is your favorite pet?<BR><BR>

         <INPUT TYPE=radio NAME=animal VALUE=dog>Dog<BR>
         <INPUT TYPE=radio NAME=animal VALUE=cat>Cat<BR>
         <INPUT TYPE=radio NAME=animal VALUE=bird>Bird<BR>
         <INPUT TYPE=radio NAME=animal VALUE=snake>Snake<BR>
         <INPUT TYPE=radio NAME=animal VALUE=none CHECKED>None
         <BR><BR><INPUT TYPE=submit VALUE="Submit">
         <INPUT TYPE=reset>

      </FORM>
    </body>
</html>