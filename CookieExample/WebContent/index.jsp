<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <FORM ACTION="/CookieExample/CookiesExampleServlet"
              METHOD="POST">      
       <STRONG>Select a programming language:<br>
            </STRONG><BR>
            <PRE>
      <INPUT TYPE="radio" NAME="lang" VALUE="C">C<BR>
      <INPUT TYPE="radio" NAME="lang" VALUE="C++">C++<BR>
      <INPUT TYPE="radio" NAME="lang" VALUE="Java"  CHECKED>Java<BR>
      <INPUT TYPE="radio" NAME="lang" VALUE="C#">C#
      <INPUT TYPE="radio" NAME="lang" VALUE="Python">Python
            </PRE>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
        <br>
        Customer returns later for Recommendations (if &lt; 60 seconds) using this <a href="/CookieExample/RecommendUsingCookie.html" target="_blank">web page</a>
    </body>
</html>
