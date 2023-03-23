package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;


import dao.Util;
import metier.Users;





public class bd2  extends Util<Users> {
	
	//Propriétés
	private static String URL= "jdbc:mysql://localhost:3307/db_22009886_2"; 
	private static String LOGIN= "22009886";
	private static String PWD= "V00WM2";
	
	private static Connection cx;
	
	
	//Methode de connextion a la bdd
	public static void connection() throws Exception{
		
		//Chargement du pilote
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			throw new Exception("Erreur BD.connexion() - Chargement du pilote - " + cnfe.getMessage());
		}
		try {
			cx=DriverManager.getConnection(URL,LOGIN,PWD);
		} catch (SQLException sqle) {
			throw new Exception ("Erreur BD.connexion() - Ouverture à la connexion - "+ sqle.getMessage());
		}
	}
	
	public static int checkLogin(String email, String password) throws Exception {
		
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
			

		/*----- Requête SQL -----*/
		String sql = "SELECT CodeU FROM users WHERE identifiant = ? AND motDePasse = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql))
			{
			st.setString(1, email);
			st.setString(2, password);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery())
				{
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				return rs.getInt(2);
				}
			}
		catch (SQLException ex)
			{
			}
		return 0;

	}
public static String consulterType(int code) throws Exception {
	/*----- Création éventuelle de la connexion à la base de données -----*/
	if (bd2.cx == null) {
		bd2.connection();
	}
	/*----- Requête SQL -----*/
	String sql = "SELECT typeU FROM users WHERE CodeU = ?";

	/*----- Ouverture de l'espace de requête -----*/
	try (PreparedStatement st = bd2.cx.prepareStatement(sql))
		{
		st.setInt(1, code);
		/*----- Exécution de la requête -----*/
		try (ResultSet rs = st.executeQuery())
			{
			/*----- Lecture du contenu du ResultSet -----*/
			rs.next();
			return rs.getString(1);
			}
		}
	catch (SQLException ex)
		{
		}
	return "notype";
		
	}
	
public static Users loginUtilisateur(String email, String pwd) {
    Users users = null;
    try (Session session = bd2.getSession()) {
    	Transaction transaction=bd2.getTransaction(session);
    	session.beginTransaction();
        Query<Users>query = session.createQuery("select u " +
                								"from users u " +
                								"where u.email = :email " +
                								"and u.password = :password ");
        query.setParameter("email", email);
        query.setParameter("password", pwd);
        if (!query.getResultList().isEmpty()) {
        	users = query.uniqueResult();
        }
        transaction.commit();
    }
     catch (Exception e) {
        e.printStackTrace();
    }
    return users;
}

	

}//fin classe