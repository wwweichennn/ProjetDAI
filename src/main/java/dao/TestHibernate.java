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

import javax.persistence.*;
import java.util.*;


import enumtype.Formations;
import enumtype.Parcours;
import metier.Etudiant;
import metier.Justificatif;
import metier.Scolarite;
import metier.Utilisateurs;


public class TestHibernate {

	//constante de classe pour les dates
		private static final SimpleDateFormat DF = new SimpleDateFormat("dd-mm-yyyy");

	public static void createUtilisateur() {
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();

			//Utilisateurs u1 = new Utilisateurs( "M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com");
			Etudiant e1 = new Etudiant("M", "Folvert", "Kevin", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.IPM,Formations.FI);
			Etudiant e2 = new Etudiant("M", "Weichen", "Sun", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.ISIAD,Formations.FA);
			Etudiant e3 = new Etudiant("M", "Zhibo", "Xie", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.ISIAD,Formations.FA);
			//Scolarite s1 = new Scolarite("M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com","0987654321", "altmb@hotmail.com","M1001");

			session.save(e2);
			session.save(e1);
			session.save(e3);


			t.commit();

			session.close();

		}
	}

	/**
	 * Methode pour creer et associer un justificatif
	 */
	public static void createJustificatif() {
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();

			Utilisateurs u = session.get(Utilisateurs.class,2);
			Justificatif j = new Justificatif("www.projet.com",enumtype.StatutJustificatif.NonValide,DF.parse("03-09-2012"),DF.parse("09-09-2022"),u);

			session.save(j);

			t.commit();

			session.close();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadEtudiant() {
		
		
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();
		

			String  hql = "FROM Utilisateurs u left join u.justificatifs as j where j.statut = 1 and parcour=0" ;		//Requete pour recupérer les étudiants
			
			Query<Etudiant>query = session.createQuery(hql);
		
			 List<Etudiant>  etudiants = query.list();		//recupere le résultat de la requete

			for (metier.Etudiant e : etudiants) {
				System.out.println(e.getNom());
			}

			t.commit();

			
			}
	
		

		
	}
	
	


	public static void main(String[] args) {
		System.out.println("-----Creations des users------");
		//TestHibernate.createUtilisateur();
		System.out.println("-----Creations des justificatifs------");
		//TestHibernate.createJustificatif
		//requte pour obtenir les etudinats qui ont pas unjustificatif 
		TestHibernate.loadEtudiant();

		System.out.println("------Load Etudiant ----------");
		//TestHibernate.afficherEtudiantAbs();


	

	}

}
