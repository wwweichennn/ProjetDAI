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
import metier.Users;

/**
 * Servlet implementation class centrale
 */
@WebServlet("/centrale")
public class centrale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email == null && password == null) {
			request.setAttribute("email_error", "Veillez entrer l'addresse email");
			request.setAttribute("password_error", "Veillez entrer un mot de passe");
			request.getRequestDispatcher("index").forward(request, response);
			
		}
		else if (email == null || email.isEmpty()) {
			request.setAttribute("email_error", "Veillez entrer l'addresse email");
			request.getRequestDispatcher("index").forward(request, response);
		}
		else if (password == null || password.isEmpty()) {
			request.setAttribute("password_error", "Veillez entrer un mot de passe");
			request.getRequestDispatcher("index").forward(request, response);
		}
		else  {
			try {
				Users users = bd2.loginUtilisateur(email, password);
	
				if (users == null) {
					request.setAttribute("generale_error", "Email ou mot de passe incorrect ! Veuillez réessayer !");
					request.getRequestDispatcher("index").forward(request, response);
				}
				else  {
					request.getSession().setAttribute("id", users.getCodeU());
					request.getSession().setAttribute("email", users.getIdentifiant());
					request.getSession().setAttribute("nom", users.getNom());
					request.getSession().setAttribute("prenom", users.getPrenom());
					request.getSession().setAttribute("Type", bd2.consulterType(users.getCodeU()));
					request.getSession().setAttribute("mailSup", users.getMailSupplement());
					request.getSession().setAttribute("photo", users.getPhoto());
					
					if(bd2.consulterType(users.getCodeU()) == "Enseignant") {
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
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
