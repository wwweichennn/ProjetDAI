package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import enumtype.Formations;
import enumtype.Parcours;
import metier.Etudiant;
import metier.Scolarite;
import metier.Utilisateurs;

public class TestHibernate {
	
	public static void createUtilisateur() {
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			/* transaction*/
			Transaction t = session.beginTransaction();

			Utilisateurs u1 = new Utilisateurs( "M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com");
			Etudiant e1 = new Etudiant("M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com", "0987654321", "altmb@hotmail.com", Parcours.IPM,Formations.FI);
			Scolarite s1 = new Scolarite("M", "Baer", "Mateo", "27/05/1999", "mateobaer@gmail.com","0987654321", "altmb@hotmail.com","M1001");
					
			session.save(u1);
			session.save(e1);
			session.save(s1);
			

			t.commit();

		}
	}

	public static void main(String[] args) {
		TestHibernate.createUtilisateur();
		// TODO Auto-generated method stub

	}

}
