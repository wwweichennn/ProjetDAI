package crtl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.bd2;
import jakarta.servlet.http.HttpSession;
import metier.Users;

/**
 * Servlet implementation class centrale
 */
@WebServlet("/centrale")
public class centrale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email.equals("")&& password.equals("")) {
			request.setAttribute("email_error", "Veillez entrer l'addresse email");
			request.setAttribute("password_error", "Veillez entrer un mot de passe");
			request.getRequestDispatcher("index").forward(request, response);
			
		}
		else if (email.equals("")) {
			
			request.setAttribute("email_error", "Veillez entrer l'addresse email");
			request.getRequestDispatcher("index").forward(request, response);
		}
		else if (password.equals("")) {
			request.setAttribute("email", email);
			request.setAttribute("password_error", "Veillez entrer un mot de passe");
			request.getRequestDispatcher("index").forward(request, response);
		}
		else  {
			try {
				int CodeU=bd2.checkLogin(email, password);
				
				if(CodeU==0) {
					request.setAttribute("generale_error", "Email ou mot de passe incorrect ! Veuillez réessayer !");
					request.getRequestDispatcher("index").forward(request, response);	
				}else {
				
					if(bd2.consulterType(CodeU).equals("Enseignant")) {
						request.setAttribute("nom", bd2.consulterNom(CodeU));
						request.setAttribute("id", CodeU);
						request.getRequestDispatcher("emploiDuTemps").forward(request, response);
						}
					}
				}
		 catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("generale_error", "Probleme technique ! Veuillez contacter l'administrateur.");
				request.getRequestDispatcher("index").forward(request, response);
			}
		}
	}

}
