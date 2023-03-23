package metier;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import enumtype.Formations;
import enumtype.Parcours;

@Entity
@DiscriminatorValue("Etudiant")

public class Etudiant extends Utilisateurs{

	//proprietes
	private Parcours parcours;
	private Formations formation;

	//constructeur
	public Etudiant() {
		super();
	}

	public Etudiant(String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
			String mailSupplement, Parcours parcours, Formations formation) {
		super(sexe, nom, prenom, dateNaissance, mail, tel, mailSupplement);
		this.formation=formation;
		this.parcours=parcours;
	}

	public Formations getFormation() {
		return formation;
	}

	public void setFormation(Formations formation) {
		this.formation = formation;
	}

	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}

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
		if (!super.equals(obj) || (getClass() != obj.getClass()))
			return false;
		Etudiant other = (Etudiant) obj;
		return formation == other.formation && parcours == other.parcours;
	}

	@Override
	public String toString() {
		return "Etudiant [nom " + this.getNom() + " prenom " + this.getPrenom() + " parcours = " + parcours + ", formation=" + formation + "]";
	}



}
