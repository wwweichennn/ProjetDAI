package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import metier.Cours;
import metier.Enseignant;
import metier.Etudiant;
import metier.Justificatif;
import metier.Seance;
import metier.Users;


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

			Users u1 =  session.get(Users.class, 1);
			Users u2 =  session.get(Users.class, 2);
			
			u1.ajouteCours(c6);
			u2.ajouteCours(c1);
			
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

		Enseignant u1=new Enseignant("weichen@gmail.com","1234","sun","weichen","Mme",DFDATE.parse("15-11-1998"),"aaa@qqq","aaaaaaaaaa","MF201");
		Enseignant u2=new Enseignant("zhibo@gmail.com","1234","xie","zhibo","M",DFDATE.parse("04-04-1998"),"aaa@qqq","aaaaaaaaaa","MF202");

		Etudiant u3=new Etudiant("weichen@gmail.com","1234","Ma","rong","Mme",DFDATE.parse("15-11-1998"),"aaa@qqq","aaaaaaaaaa","IPM","FI");
		Etudiant u4=new Etudiant("zhibo@gmail.com","1234","abc","def","M",DFDATE.parse("04-04-1998"),"aaa@qqq","aaaaaaaaaa","IPM","FA");

		Users u5=new Users("weichen@gmail.com","1234","zzz","rrr","Mme",DFDATE.parse("15-11-1998"),"aaa@qqq","aaaaaaaaaa");
		Users u6=new Users("zhibo@gmail.com","1234","ppp","vvv","M",DFDATE.parse("04-04-1998"),"aaa@qqq","aaaaaaaaaa");

		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(u4);
		session.save(u5);
		session.save(u6);
	
		t.commit();
		session.close();
		}
	}
	public static void createSeance () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u1 =  session.get(Users.class, 1);
		Cours c1 =  session.get(Cours.class, 1);
		Users u2 =  session.get(Users.class, 2);
		Cours c2 =  session.get(Cours.class, 2);
		
		Seance s1= new Seance("Me401",DFDATE.parse("04-01-2023"),90,DF.parse("04-04-1998 09:00:00"),"validé",u1,c1);
		Seance s2= new Seance("Me401",DFDATE.parse("04-01-2023"),18,DF.parse("04-04-1998 14:00:00"),"validé",u1,c1);
		Seance s3= new Seance("Me401",DFDATE.parse("05-01-2023"),90,DF.parse("04-04-1998 09:00:00"),"validé",u2,c2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		t.commit();
		session.close();
		
		}
	
	}
	public static void createParticipe () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u3 =  session.get(Users.class, 1);
		Users u4 =  session.get(Users.class, 2);

		
		Seance s1= session.get(Seance.class, 1);
		Seance s2= session.get(Seance.class, 2);
		Seance s3= session.get(Seance.class, 3);
		
		u3.participe(s3, "present");
		u4.participe(s1, "absent");
		u4.participe(s2, "present");
		
		t.commit();
		session.close();
		
		}
	
	}
	public static void createDeposerJus () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u3 =  session.get(Users.class, 1);
	

		Justificatif j1=new Justificatif(false,"www",DFDATE.parse("04-01-2023"),DFDATE.parse("05-01-2023"),u3);

		u3.getJustificatifs().add(j1);
		session.save(j1);
		
		t.commit();
		session.close();
		
		}
	
	}

	public static List<Seance> loadSeancesDonner (int id) 
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
    	List<Seance> seances = new ArrayList<>();
    	
    	Query query = session.createQuery("from Seance s where s.CodeU = :id");
    	query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            	seances=query.list();
            }
        return seances;

        } catch (Exception e) {
            e.printStackTrace();
        }
	return null;
        
	}
	/**
	 * Programme de test.
	 */
	public static void main(String[] args) throws ParseException
		{
		
		TestHibernate.createUsers();
		TestHibernate.createCours();
		TestHibernate.createSeance();
		TestHibernate.createParticipe();
		TestHibernate.createDeposerJus();
		
		
		}



} /*----- Fin de la classe TestHibernate -----*/