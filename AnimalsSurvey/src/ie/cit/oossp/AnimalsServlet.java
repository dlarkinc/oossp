package ie.cit.oossp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnimalsServlet
 */
@WebServlet("/AnimalsServlet")
public class AnimalsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String animalNames[] = { "dog", "cat", "bird", "snake", "none" };

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int animals[] = null, total = 0;

		/*
		 * File location: choose somewhere you can access, e.g. on your network drive
		 */

		File f = new File("survey.txt"); //

		if (f.exists()) {
			// Determine # of survey responses so far
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));

				animals = (int[]) input.readObject();
				input.close(); // close stream

				for (int i = 0; i < animals.length; ++i)
					total += animals[i];
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
		} else
			animals = new int[5];

		// read current survey response
		String value = request.getParameter("animal");
		++total; // update total of all responses

		// determine which was selected and update its total
		for (int i = 0; i < animalNames.length; ++i)
			if (value.equals(animalNames[i]))
				++animals[i];

		// write updated totals out to disk
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(f));

		output.writeObject(animals);
		output.flush();
		output.close();

		// Calculate percentages
		double percentages[] = new double[animals.length];

		for (int i = 0; i < percentages.length; ++i)
			percentages[i] = 100.0 * animals[i] / total;

		// send a thank you message to client
		//response.setContentType("text/html"); // content type

		PrintWriter responseOutput = response.getWriter();
		StringBuffer buf = new StringBuffer();
		buf.append("<html>\n");
		buf.append("<title>Thank you!</title>\n");
		buf.append("Thanks for participating!\n");
		buf.append("<BR>Results:\n<PRE>");

		DecimalFormat twoDigits = new DecimalFormat("#0.00");
		for (int i = 0; i < percentages.length; ++i) {
			buf.append("<BR>");
			buf.append(animalNames[i]);
			buf.append(": ");
			buf.append(twoDigits.format(percentages[i]));
			buf.append("%  responses: ");
			buf.append(animals[i]);
			buf.append("\n");
		}

		buf.append("\n<BR><BR>Total responses: ");
		buf.append(total);
		buf.append("</PRE>\n</html>");

		responseOutput.println(buf.toString());
		responseOutput.close();
	}
}