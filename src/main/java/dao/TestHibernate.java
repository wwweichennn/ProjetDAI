package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.*;
import java.util.*;


import enumtype.Formations;
import enumtype.Parcours;
import enumtype.StatutAppel;
import enumtype.StatutFicheAppel;
import enumtype.StatutJustificatif;
import metier.Cours;
import metier.Etudiant;
import metier.Justificatif;
import metier.Participer;
import metier.ParticiperId;
import metier.Scolarite;
import metier.Seance;
import metier.Utilisateurs;


public class TestHibernate {

	//constante de classe pour les dates
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-mm-yyyy");

	/**
	 * Methode qui creer et enregistre utilisateur/etudiant/scolarite
	 */
	public static void createUtilisateur() {
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();

			Utilisateurs u1 = new Utilisateurs("M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com");
			Utilisateurs u2 = new Utilisateurs("F", "Reab", "Matias", "27/05/2000", "ReabMatias@gmail.com", "0987654321", "altmb@hotmail.com");

			Etudiant e1 = new Etudiant("M", "Folvert", "Kevin", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.IPM, Formations.FI);
			Etudiant e2 = new Etudiant("F", "Weichen", "Sun", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.ISIAD, Formations.FA);
			Etudiant e3 = new Etudiant("M", "Zhibo", "Xie", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.ISIAD, Formations.FA);
			Etudiant e4 = new Etudiant("M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.IPM, Formations.FI);


			session.save(u1);
			session.save(u2);
			session.save(e2);
			session.save(e1);
			session.save(e3);
			session.save(e4);

			t.commit();
			session.close();

		}
	}

	/**
	 * Methode qui affiche un etudiant
	 */
	public static Utilisateurs loadUtilisateur(int id) 
	{
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
			Transaction t = session.beginTransaction();

			Utilisateurs u = session.get(Utilisateurs.class, id);
			System.out.println("------ Utilisateur "+ id + "------");
			System.out.println(u.toString());

			return u;
		}
	}


	/**
	 * Creation de cours
	 */
	public static void createCours() {

		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			Cours c1 = new Cours("DAI");
			Cours c2 = new Cours("Big Data");
			Cours c3 = new Cours("Programmation Oriente Objet");
			Cours c4 = new Cours("Management Agile");
			Cours c5 = new Cours("Urbanisation du SI");

			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);

			t.commit();
			session.close();	
		}
	}
	/**
	 * Creation et enregistrement d'une seance 
	 * @throws ParseException 
	 */
	public static void createSeances() throws ParseException {

		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			//Recuperation des cours
			Cours c1 = session.get(Cours.class, 11);
			Cours c2 = session.get(Cours.class, 12);

			Seance s1 = new Seance("Me401", DF.parse("23-03-2023"), 90, "9h30", StatutFicheAppel.Vide, c1);
			Seance s2 = new Seance("Mf103", DF.parse("23-03-2023"), 90, "9h30", StatutFicheAppel.Vide, c2);
			Seance s3 = new Seance("Me310", DF.parse("23-03-2023"), 180, "14h00", StatutFicheAppel.Vide, c2);

			session.save(s1);
			session.save(s2);
			session.save(s3);

			t.commit();

			session.close();
		}
	}

	/**
	 * Methode pour creer et associer un justificatif
	 * @throws ParseException 
	 */
	public static void createJustificatif() throws ParseException {
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();

			Utilisateurs u1 = session.get(Utilisateurs.class, 5);
			Utilisateurs u2 = session.get(Utilisateurs.class, 4);

			Justificatif j1 = new Justificatif(StatutJustificatif.NonValide, "www.projet.com", DF.parse("12-03-2023"),DF.parse("13-03-2023"), u1);
			Justificatif j2 = new Justificatif(StatutJustificatif.Valide, "www.excuse.com", DF.parse("20-03-2023"),DF.parse("20-03-2023"), u1);
			Justificatif j3 = new Justificatif(StatutJustificatif.NonValide, "www.kevin.com", DF.parse("09-03-2023"),DF.parse("09-03-2023"), u2);

			session.save(j1);
			session.save(j2);
			session.save(j3);

			t.commit();

			session.close();

		}
	}

	/**
	 * Ajout d'un statut de présence d'un etudiant à une seance
	 */
	public static void addParticiper(int idUtilisateur, int idSeance, StatutAppel statutAppel) {

		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			//Recupération d'étudiants
			Utilisateurs u = session.get(Utilisateurs.class, idUtilisateur);

			//Récupération de seances
			Seance s = session.get(Seance.class,idSeance);

			//*** Ajout ***//
			//On regarde si l'appel à deja ete fait 
			Participer participe = u.getPresence().get(s);
			System.out.println(participe);

			if(participe == null) {
				//Creation de la participation
				Participer p = new Participer(new ParticiperId(idUtilisateur, idSeance), statutAppel);
				p.setUtilisateur(u);
				p.setSeance(s);

				//Mise a jour de la presence dans les classe u et s
				//				u.getPresence().put(s, p);
				//				s.getParticipationUtilisateur().put(u, p);
			}
			else {
				//Modification
				participe.setStatut(statutAppel);
			}


			//			t.commit();
			session.close();
		}
	}

	/**
	 * Recupère et affiche les etudiants qui n'ont pas justifier leur presence
	 */
	public static List loadEtuAbsNonJustifier() {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			//Liste des etudiants absence non justifier
			String  hql = "FROM Etudiant u left join u.justificatifs as j where j.statut = 1 and parcours = 0" ;		//Requete pour recupérer les étudiants

			List queryResponse = session.createQuery(hql).list();

			
			TestHibernate.lire(queryResponse);
			
			t.commit();
			return queryResponse;
		}
	}


	public static void main(String[] args) throws Exception {
		System.out.println("-----Creations des users------");
		//TestHibernate.createUtilisateur();

		System.out.println("------- Affichage de l'utilisateur -------");
		TestHibernate.loadUtilisateur(4);

		System.out.println("----- Creation des cours -----");
		//TestHibernate.createCours();

		System.out.println("----- Creation des seances -----");
		//TestHibernate.createSeances();

		System.out.println("-----Creations des justificatifs------");
		//TestHibernate.createJustificatif();

		System.out.println("-----Creations des participations ------");
		//TestHibernate.addParticiper(5, 3, StatutAppel.Absent);;

		//requte pour obtenir les etudinats qui ont pas unjustificatif 
		TestHibernate.loadEtuAbsNonJustifier();

		System.out.println("------ Fin Test ----------");

	}

	/**Lecture d'une liste de tableau d'objets
	 * @param l
	 */
	public static void lire (List l) {
		for(int i = 0; i < l.size(); i++) {
			Object[] tab = (Object[])l.get(i);
			for( Object obj : tab) {
				System.out.println(obj + " ");
			}
			System.out.println();
		}
	}

}
