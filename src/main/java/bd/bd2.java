package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Seance;

public class bd2 {

	// Propriétés
	private static String URL = "jdbc:mysql://localhost:3307/db_22009886_2";
	private static String LOGIN = "22009886";
	private static String PWD = "V00WM2";

	private static Connection cx;

	// Methode de connextion a la bdd
	public static void connection() throws Exception {

		// Chargement du pilote
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			throw new Exception("Erreur BD.connexion() - Chargement du pilote - " + cnfe.getMessage());
		}
		try {
			cx = DriverManager.getConnection(URL, LOGIN, PWD);
		} catch (SQLException sqle) {
			throw new Exception("Erreur BD.connexion() - Ouverture à la connexion - " + sqle.getMessage());
		}
	}

	public static int checkLogin(String email, String password) throws Exception {

		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		int id = 0;
		/*----- Requête SQL -----*/
		String sql = "SELECT CodeU FROM users WHERE identifiant = ? AND motDePasse = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, password);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				id = rs.getInt("CodeU");
				return id;
			}
		} catch (SQLException ex) {
		}
		return id;

	}

	public static String consulterType(int code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		String type = "notype";
		/*----- Requête SQL -----*/
		String sql = "SELECT typeU FROM users WHERE CodeU = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setInt(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				type = rs.getString("typeU");
				return type;
			}
		} catch (SQLException ex) {
		}
		return type;

	}
	public static String consulterNom(int code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		String nom = "no";
		String prenom = "no";
		/*----- Requête SQL -----*/
		String sql = "SELECT nom, prenom FROM users WHERE CodeU = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setInt(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				return nom+" "+prenom;
			}
		} catch (SQLException ex) {
		}
		return nom+" "+prenom;

	}

}// fin classe