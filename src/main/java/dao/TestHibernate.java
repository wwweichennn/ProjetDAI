package dao;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import metier.Justificatif;

/**
 * Classe de test pour Hibernate.
 */
public class TestHibernate {

	/**
	 * Constance de classe
	 */
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-mm-yyyy");

	//Retourne une liste des etudiants avec absences non justifier
	public static Set<Justificatif> etuAbsenceNonJustifier() {
		Set<Justificatif> justificatifs = new HashSet<>();

		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			Query<> query = session.createQuery("FROM Justificatif WHERE statut = NonValide");

			if(!query.getResultList().isEmpty()) {
				justificatifs = query.list();
			}

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return justificatifs;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
