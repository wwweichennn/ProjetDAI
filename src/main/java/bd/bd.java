package bd;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.hibernate.engine.jdbc.BinaryStream;


import metier.Users;




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
	
	public static void uploadPhoto(Users user,String filePath) throws Exception{
	if(bd.cx==null) {
		bd.connection();}
				
		  String updateSQL = "UPDATE users SET Photo = ? WHERE identifiant = ?";
		  PreparedStatement statement = cx.prepareStatement(updateSQL);
		  		  
		  statement.setString(1, filePath);
		  statement.setString(2, user.getIdentifiant());
		  
		  statement.executeUpdate();

		// 关闭连接和语句对象
		  statement.close();
		  cx.close();  
}
	public static String TelechargerPhoto(Users user) throws Exception{
		if(bd.cx==null) {
			bd.connection();}
		String photo = "";			
	    String SQL = "SELECT photo FROM users WHERE identifiant = ?";
	    PreparedStatement statement = cx.prepareStatement(SQL);
			  		
		statement.setString(1,  user.getIdentifiant());
		  
		ResultSet rs = statement.executeQuery();

	    if (rs.next()) {
	        photo = rs.getString("photo");
	    }
			
	 // 关闭连接和语句对象
	    rs.close();
	    statement.close();
	    cx.close();  
	return photo;
	}
	
	

	

}//fin classe