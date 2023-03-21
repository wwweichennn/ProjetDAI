package crtl;

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
 * Servlet implementation class centrale
 */
@WebServlet("/centrale")
public class centrale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("type_action");
		String url;

		// --> Démarrage de l'application ou retour !
		if (action ==  null)
			url = "LeLivreDor";
		else
			{
			switch (action)
				{
				case "Saisir":
					url = "SaisirMessage";
					break;

				case "Modifier":
					try {
						url="ModifierMessage";
						request.setAttribute("message", Bd.lireMessage(request.getParameter("id")));
						}
					catch (ExceptionLivreDor ex)
						{
						url = "LeLivreDor";
						request.setAttribute("msg_erreur", ex.getMessage());
						}
					break;

				case "Afficher":
					try {
						url = "LireMessage";
						request.setAttribute("liste", Bd.lireMessages());
						}
					catch (ExceptionLivreDor e)
						{
						url = "LeLivreDor";
						request.setAttribute("msg_erreur", e.getMessage());
						}
					break;

				case "Supprimer":
					try {
						/*----- Partie pour affichage JSP -----*/
						url = "ChoisirSupprMessage";
						request.setAttribute("liste", Bd.lireMessages());

						/*----- Partie affichage JSTL -----*/
						/*
						 * Le modèle est plus proche du MVC.
						 */
						ArrayList<MessageDor> lt = Bd.lireMessages();
						String[] t = (String[])request.getSession().getAttribute("liste_suppr");

						TreeMap<MessageDor,String> tmap= new TreeMap<>();

						lt.forEach((msg) -> { tmap.put(msg, Util.isChecked(t, msg.getId())); });

						request.setAttribute("liste_triee", tmap);
						}
					catch (ExceptionLivreDor e)
						{
						url = "LeLivreDor";
						request.setAttribute("msg_erreur", e.getMessage());
						}
					break;

				case "Annuler":
					/*----- Suppression d'un élément en session -----*/
					request.getSession().removeAttribute("liste_suppr"); // après type_action=Annuler
				case "Retour": ;

				default:
					url = "LeLivreDor";
				}
			}

		// Chainage.
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
