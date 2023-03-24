package crtl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.bd2;
import dao.SeanceDonner;
import dao.TestHibernate;
import metier.Seance;

/**
 * Servlet implementation class ServletPlanning
 */
@WebServlet("/ServletPlanning")
public class ServletPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPlanning() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*----- Lecture de la requête en UTF-8 -----*/
		request.setCharacterEncoding("UTF-8");

		/*----- Type de la réponse -----*/
		response.setContentType("application/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter out = response.getWriter())
			{
			/*----- Ecriture de la page XML -----*/
			out.println("<?xml version=\"1.0\"?>");
			out.println("<liste_seance>");

			/*----- Récupération des paramètres -----*/
			String id = request.getParameter("id");

			try {
				ArrayList<Seance> lSeances = bd2.consulterSeance(id);
				for (Seance s : lSeances) {
					out.println("<cours><![CDATA[" + s.getCours().getNomCours() + "]]></cours>");
					out.println("<salle>" +  s.getSalleS() + "</salle>");
					out.println("<date>" + s.getDateS() + "</date>");
					out.println("<duree>" + s.getDureeS() + "</duree>");
					out.println("<hdebut>" + s.getHeureDebut() + "</hdebut>");
				}
				}
			catch (Exception ex)
				{
				out.println("<citation>Erreur - " + ex.getMessage() + "</citation>");
				}

			out.println("</liste_seance>");
			}
	}

}
