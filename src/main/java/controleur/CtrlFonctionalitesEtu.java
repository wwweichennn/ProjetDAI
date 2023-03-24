package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CtrlUpdateEtu
 */
@WebServlet("/CtrlFonctionalitesEtu")
public class CtrlFonctionalitesEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	String action = request.getParameter("type_Moi");
	String url;


	if (action ==  null)
		url = "AcceuilEtudiant";
	else
		{
	

		switch (action)
			{
			case "Modif":
				url = "ModifProfil";
				break;

			case "Janvier":
				url = "absparmois";
				break;
			case "Fevrier":
				url = "absparmois";
				break;
			case "Mars":
				url = "absparmois";
				break;
			case "Avril":
				url = "absparmois";
				break;
			case "Mai":
				url = "absparmois";
				break;
			case "Juin":
				url = "absparmois";
				break;
			case "Septembre":
				url = "absparmois";
				break;
			case "Octobre":
				url = "absparmois";
				break;
			case "Novembre":
				url = "absparmois";
				break;
			case "Decembre":
				url = "absparmois";
				break;

			default:
				url = "absparmois";
			}
		
		}
		
	// Chainage.
	request.setAttribute("Mois", action);
	request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
