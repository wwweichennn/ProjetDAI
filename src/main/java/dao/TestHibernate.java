package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import metier.Cours;
import metier.users;


/**
 * Hibernate.
 */
public class TestHibernate
{
	/**
	 * Constante.
	 */

	/*----- Format de date -----*/
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static final SimpleDateFormat DFDATE = new SimpleDateFormat("dd-MM-yyyy");


	/**
	 * Création, enregistrement et lecture d'objets.
	 */

	/*----- Création et enregistrement d'employés -----*/
	public static void createCours ()
		{
		/*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
			/*----- Ouverture d'une transaction -----*/
			Transaction t = session.beginTransaction();

			Cours c1=new Cours("DAI");
			Cours c2=new Cours("management agile");
			Cours c3=new Cours("big data");
			Cours c4=new Cours("application oriente service");
			Cours c5=new Cours("anglaise");
			Cours c6=new Cours("urbanisation et architecture d'entreprise");
			Cours c7=new Cours("innovation");
			Cours c8=new Cours("conception de site web");
			Cours c9=new Cours("base de donneés");
			Cours c10=new Cours("programmation");

			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);
			session.save(c6);
			session.save(c7);
			session.save(c8);
			session.save(c9);
			session.save(c10);


			
			t.commit();
			session.close();
			}
		}

	public static void createUsers () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();

		users u1=new users("weichen@gmail.com","1234","sun","weichen","Mme",DFDATE.parse("15-11-1998"),"aaa@qqq","aaaaaaaaaa");
		users u2=new users("zhibo@gmail.com","1234","xie","zhibo","M",DFDATE.parse("04-04-1998"),"aaa@qqq","aaaaaaaaaa");

		session.save(u1);
		session.save(u2);
	
		t.commit();
		session.close();
		}
	}

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) throws ParseException
		{
		TestHibernate.createCours();
		TestHibernate.createUsers();
		}



} /*----- Fin de la classe TestHibernate -----*/