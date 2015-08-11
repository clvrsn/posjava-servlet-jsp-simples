package br.edu.up.posjava.app1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.up.posjava.app1.dao.UserDAO;
import br.edu.up.posjava.app1.entities.User;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 5533775744737668339L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("/login.jsp").forward(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password  = req.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		boolean logged = UserDAO.getInstance().validatePassword(user);

		if(logged){
			res.setContentType("text/html");
	
			PrintWriter out = res.getWriter();
			out.println("<h1>Logado com Sucesso.</h1>");
		}else{
			
			
			req.getRequestDispatcher("/login.jsp").forward(req, res);
	
		}
		
	}

}
