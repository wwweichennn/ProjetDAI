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
	String action = request.getParameter("type_action");
	String url = null;

	
	
		switch (action)
			{
			case "Modif":
				url = "ModifProfil";
				break;

			case "Fonct":
				url = "ConsultAbs";
				break;

			}
		System.out.println(url);
		
	// Chainage.
	request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
