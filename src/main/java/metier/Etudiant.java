package metier;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;

@Entity (name="Etudiant")
public class Etudiant extends users {
	//priorite
	private String parcours;
	private String formation;
	
	
	//Constructeur
	public Etudiant() {}
	
	public Etudiant(String identifiant, String motDePasse, String nom, String prenom, String sexe, Date dateNaissance,
			String mailSupplement, String photo,String parcours, String formation) {
		super(identifiant, motDePasse, nom, prenom, sexe, dateNaissance, mailSupplement, photo);
		this.parcours = parcours;
		this.formation = formation;
	}

	//Getters & Setters 
	public String getParcours() {return parcours;}
	public void setParcours(String parcours) {this.parcours = parcours;}
	public String getFormation() {return formation;}
	public void setFormation(String formation) {this.formation = formation;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(formation, parcours);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		return Objects.equals(formation, other.formation) && Objects.equals(parcours, other.parcours);
	}

	@Override
	public String toString() {
		return "Etudiant [parcours=" + parcours + ", formation=" + formation + "]";
	}
	
	

	
	

	
	
}
