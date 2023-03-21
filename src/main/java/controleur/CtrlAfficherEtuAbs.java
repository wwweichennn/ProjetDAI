package controleur;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.hibernate.cfg.*;

import metier.Etudiant;
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

		//		//Actions a effectuer
		//		switch(action) {
		//		case "IPM" :
		//			//Chargement des etudiants concerné dans la Bd
		//			
		//			
		//			//Pour un chainage vers page des IPM :
		//			request.getRequestDispatcher("EtuAbsentIPM").forward(request, response);
		//		}

		//mappage des classes
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(metier.Etudiant.class)
				.addAnnotatedClass(metier.Justificatif.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String queryString = "FROM Etudiant WHERE promotion=" + action + " AND nonValide=true";		//Requete pour recupérer les étudiants

			List<Etudiant> etudiants = session.createQuery(queryString).getResultList();		//recupere le résultat de la requete

			request.setAttribute("etudiants", etudiants);	//cree un attribut étudiant et affecte la valeur
			request.getRequestDispatcher("VerifJustification.jsp").forward(request, response);		//chainage

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}
	}	


	/**
	 * doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request, response); }

}
