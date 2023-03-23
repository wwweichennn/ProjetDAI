package controleur;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dao.TestHibernate;
import metier.*;
/**
 * Servlet implementation class CtrlAfficherEtuAbs
 */
@WebServlet("/CtrlAfficherEtuAbs")
public class CtrlAfficherEtuAbs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Lecture des paramètres
		String action;
		if(request.getParameter("type_promo").equals("ISIAD")) {
			action = "1"; 
		} else {
			action ="0";
		}

		//Actions a effectuer
		switch(action) {
		case "0" :
			try {
				//Chargement des etudiants concerné dans la Bd
				List liste = TestHibernate.loadEtuAbsNonJustifier();

				//Pour un chainage vers page des IPM 
				request.setAttribute("listeAbs", liste);
				request.getRequestDispatcher("Scolarite/VerifJustificatif.jsp").forward(request, response);
			}
			catch (ServletException e) {
				request.setAttribute("msg_erreur", e.getMessage());
				request.getRequestDispatcher("Accueil").forward(request, response);

			}
			break;
		}

	}


	/**
	 * doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request, response); }

}
