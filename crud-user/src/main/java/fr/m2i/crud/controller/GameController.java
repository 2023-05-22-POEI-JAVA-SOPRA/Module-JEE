package fr.m2i.crud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;

import fr.m2i.crud.model.Score;
import fr.m2i.crud.model.User;
import fr.m2i.crud.service.UserService;


@WebServlet("/Game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserService service = new UserService();
	Gson gson = new Gson();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_1 = Integer.parseInt( request.getParameter("id1") );
		String action_1 = request.getParameter("action1");
		
		String result = service.play(id_1, action_1);
		response.getWriter().print("Result is :" + result);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_1 = Integer.parseInt( request.getParameter("id1") );
		int id_2 = Integer.parseInt( request.getParameter("id2") );
		
		String action_1 = request.getParameter("action1");
		String action_2 = request.getParameter("action2");
		
		String result = service.play(id_1, action_1, id_2, action_2);
				
		response.getWriter().print("Result is :" + result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BufferedReader reader = request.getReader();
			Score score = gson.fromJson( reader, Score.class);
			int id = Integer.parseInt( request.getParameter("id") );			
			service.updateScore(id, score);
			
			response.getWriter().print("Score updated");
		} catch (Exception e) {
			response.getWriter().print("Score not updated");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id") );			
			service.updateScore(id, new Score(0, 0, 0));
			
			response.getWriter().print("Score deleted");
		} catch (Exception e) {
			response.getWriter().print("Score not deleted");
		}
	}	
}
