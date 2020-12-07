
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name1");
		String[] p1 = request.getParameterValues("option1");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Date date = new Date();
		SimpleDateFormat sfd = new SimpleDateFormat("HH:mm");
		PrintWriter pw = response.getWriter();

		
			
		
		
		Parser parser = new Parser();
		if (name==null) {
			pw.println("<b>Hello Anon "   + " Время сейчас: " + sfd.format(date) + "</b> " + "<p>"
					+ parser.getWeatheStatus());
			pw.println("<p><Big> Коронавирус статистика: "+parser.getCovidStatus()+"</Big>");
		} else {
		pw.println("<b>Hello " + name + " " + "Время сейчас: " + sfd.format(date) + "</b> " + "<p>"
				+ parser.getWeatheStatus());
		pw.println("<p><Big> Коронавирус статистика: "+parser.getCovidStatus()+"</Big>");}
		pw.println("<p><iframe src=\"https://embed.waze.com/iframe?zoom=15&lat=50.454458&lon=30.605121&ct=livemap\" width=\"600\" height=\"450\" allowfullscreen></iframe>");
			
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
