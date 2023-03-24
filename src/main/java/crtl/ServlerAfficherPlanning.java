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
import jakarta.servlet.http.HttpSession;
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
		    HttpSession se=(HttpSession) request.getSession(true);
			int id = (int) se.getAttribute("idEnseignant");
			List<Seance> lSeances = TestHibernate.loadSeancesDonner(id);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			int i=0;
				for (Seance s : lSeances) {
					i++;
					LocalDate date = LocalDate.parse((CharSequence) s.getDateS(), formatter);
					int dayOfWeek = date.getDayOfWeek().getValue();
					
					request.setAttribute("cours"+i, s.getCours().getNomCours());
					request.setAttribute("salle"+i, s.getSalleS());
					request.setAttribute("date"+i, s.getDateS());
					request.setAttribute("duree"+i,s.getDureeS());
					request.setAttribute("jour"+i, dayOfWeek);
					request.setAttribute("hdebut"+i, s.getHeureDebut());
				}
				request.setAttribute("nb", i);
				request.getRequestDispatcher("emploiDuTemps").forward(request, response);
				
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
