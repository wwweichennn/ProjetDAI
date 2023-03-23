package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livredor.bd.Bd;
import livredor.bd.ExceptionLivreDor;
import livredor.metier.MessageDor;
import livredor.metier.Util;

/**
 * Servlet implementation class CtrlUpdateEtu
 */
@WebServlet("/CtrlUpdateEtu")
public class CtrlFonctionalitesEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	String action = request.getParameter("type_action");
	String url;

	
	if (action ==  null)
		url = "AcceuilEtudiant";
	else
		{
		switch (action)
			{
			case "Modif":
				url = "verifJustif";
				break;

			case "Fonct":
				url = "consulterAbs";
				break;



			}
		}

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
