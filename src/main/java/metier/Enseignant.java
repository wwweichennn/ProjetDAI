package metier;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;

@Entity (name="Enseignant")
public class Enseignant extends Users {
	//priorite
	private String bureauE;

	//Constructeur
	public Enseignant() {
	}

	public Enseignant(String identifiant, String motDePasse, String nom, String prenom, String sexe, Date dateNaissance,
			String mailSupplement, String photo, String bureauE) {
		super(identifiant, motDePasse, nom, prenom, sexe, dateNaissance, mailSupplement, photo);
		this.bureauE = bureauE;
	}

	//Getters & Setters
	public String getBureauE() {return bureauE;}
	public void setBureauE(String bureauE) {this.bureauE = bureauE;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bureauE);
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
		Enseignant other = (Enseignant) obj;
		return Objects.equals(bureauE, other.bureauE);
	}

	@Override
	public String toString() 
	{
		return "Enseignant [bureauE=" + bureauE + "]";
	}
	
// fin de la class
}
