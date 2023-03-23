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


import dao.SeanceDonner;
import dao.TestHibernate;
import metier.Seance;

/**
 * Servlet implementation class ServlerAfficherPlanning
 */
@WebServlet("/ServlerAfficherPlanning")
public class ServlerAfficherPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				
				/*----- Lecture de liste de mots dans la BD -----*/
				List<Seance> lSeances = TestHibernate.loadSeancesDonner(id);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				for (Seance s : lSeances) {
					LocalDate date = LocalDate.parse((CharSequence) s.getDateS(), formatter);
					int dayOfWeek = date.getDayOfWeek().getValue();

					out.println("<cours><![CDATA[" + s.getCours().getNomCours() + "]]></cours>");
				    out.println("<salle><![CDATA[" + s.getSalleS() + "]]></salle>");
				    out.println("<date><![CDATA[" + s.getDateS() + "]]></date>");
				    out.println("<jour><![CDATA[" + dayOfWeek + "]]></jour>");
				    out.println("<duree><![CDATA[" + s.getDureeS() + "]]></duree>");
				    out.println("<hdebut><![CDATA[" + s.getHeureDebut() + "]]></hdebut>");
				    }
				}
			catch (Exception ex)
				{
				out.println("<seance>Erreur - " + ex.getMessage() + "</seance>");
				}

			out.println("</liste_seance>");
			}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
