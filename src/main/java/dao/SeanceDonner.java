package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import metier.Seance;

public class SeanceDonner extends Util<Seance> {
	public List<Seance> listAbsencesEtudiant(int id){
    	List<Seance> seances = new ArrayList<>();
    	String hql = "from Seance s where s.CodeU = :id";

        try (Session session = getSession()) {
        	Transaction transaction=getTransaction(session);
            Query<Seance>query = session.createQuery(hql);
            query.setParameter("id", id);
            if (!query.getResultList().isEmpty()) {
            	seances=query.list();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seances;
    }
}
