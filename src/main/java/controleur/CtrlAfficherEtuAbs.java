package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CtrlAfficherEtuAbs
 */
@WebServlet("/CtrlAfficherEtuAbs")
public class CtrlAfficherEtuAbs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Lecture des paramètres
		String action = request.getParameter("type_promo");
		
		//Actions a effectuer
		switch(action) {
		case "IPM" :
			//Chargement des etudiants concerné dans la Bd
			
			
			//Pour un chainage vers page des IPM :
			request.getRequestDispatcher("EtuAbsentIPM").forward(request, response);
		}
	}

	/**
	 * doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request, response); }

}
