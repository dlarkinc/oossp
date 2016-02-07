package ie.cit.oossp.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieExampleServlet extends HttpServlet {

	private static final long serialVersionUID = -4628573099634298659L;

	private String names[] = { "C", "C++", "Java", "C#", "Python" };
	private String isbn[] = { "0132261197", "0135289106", "0130125075", "1491927062", "1449355730" };

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output;
		String language = request.getParameter("lang");

		Cookie c = new Cookie(language, getISBN(language));
		c.setMaxAge(60); // seconds until cookie removed
		response.addCookie(c); // must precede getWriter

		//response.setContentType("text/html");
		output = response.getWriter();

		// send HTML page to client
		output.println("<HTML><HEAD><TITLE>");
		output.println("Cookies");
		output.println("</TITLE></HEAD><BODY>");
		output.println("<P>Welcome to Cookies!<BR>");
		output.println("<P>");
		output.println(language);
		output.println(" is a great language.");
		output.println("</BODY></HTML>");
		output.close(); // close stream
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output;
		Cookie cookies[];

		cookies = request.getCookies(); // get client's cookies

		response.setContentType("text/html");
		output = response.getWriter();

		output.println("<HTML><HEAD><TITLE>");
		output.println("Cookies II");
		output.println("</TITLE></HEAD><BODY>");

		if (cookies != null && !cookies[0].getName().equals("JSESSIONID")) {
			output.println("<H1>Recommendations</H1>");
			// get the name of each cookie
			for (int i = 0; i < cookies.length; i++)
				if (!cookies[i].getName().equals("JSESSIONID"))
					output.println(cookies[i].getName() + " : Check out the book with this ISBN#: " + cookies[i].getValue() + "<BR>");
		} else {
			output.println("<H1>No Recommendations</H1>");
			output.println("You did not select a language or");
			output.println("the cookies have expired.");
		}

		output.println("</BODY></HTML>");
		output.close(); // close stream
	}

	private String getISBN(String lang) {
		for (int i = 0; i < names.length; ++i)
			if (lang.equals(names[i]))
				return isbn[i];

		return ""; // no matching string found
	}
}