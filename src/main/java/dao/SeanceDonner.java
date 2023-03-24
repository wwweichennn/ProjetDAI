package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import metier.Seance;

public class SeanceDonner extends Util<Seance> {
	public static List<Seance> listSeanceDonner(int id){
    	List<Seance> seances = new ArrayList<>();
    	String hql = "from Seance s where s.CodeU = :id";

        try (Session session = getSession()) {
        	Transaction transaction=getTransaction(session);
            @SuppressWarnings("unchecked")
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
}
