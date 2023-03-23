package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class bd {
	
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
	
	
	

	

}//fin classe