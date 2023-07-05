

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static java.time.temporal.ChronoUnit.SECONDS;


@WebServlet("/Calculate")
public class Calculate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(true);
		
		
		
		Date date = new Date();
		
		session.setAttribute("day", date.getDay());
		session.setAttribute("month", date.getMonth());
		session.setAttribute("year", 1900 + date.getYear());
		
		request.getRequestDispatcher("/Calculate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int birthDay = Integer.parseInt( request.getParameter("birthDay") );
			int birthMonth = Integer.parseInt( request.getParameter("birthMonth") );
			int birthYear = Integer.parseInt( request.getParameter("birthYear") );
			int currentDay = Integer.parseInt( request.getParameter("currentDay") );
			int currentMonth = Integer.parseInt( request.getParameter("currentMonth") );
			int currentYear = Integer.parseInt( request.getParameter("currentYear") );	
			

		    LocalDateTime now = LocalDateTime.of(currentYear, currentMonth, currentDay, 0, 0);
		    LocalDateTime birthday = LocalDateTime.of(birthYear, birthMonth, birthDay, 0, 0);
			CalculateService service = new CalculateService(now, birthday);

		    HttpSession session = request.getSession(true);
		    session.setAttribute("service", service);
		    
		    request.getRequestDispatcher("/Result.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			doGet(request, response);
			return;
		}


	}

}
