package metier;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Scolarite")
public class Scolarite extends Utilisateurs{
	//priorite
	@Column(name="bureauS")
	private String bureauS;

	//Constructeur
	public Scolarite() {}
	
	public Scolarite(String identifiant, String motDePasse, String nom, String prenom, String sexe, Date dateNaissance,
			String mailSupplement, String photo,String parcours,String bureauS) 
	{
		super(identifiant, motDePasse, nom, prenom, sexe, dateNaissance, mailSupplement, photo);
		this.bureauS = bureauS;
	}

	//Getters & Setters
	public String getBureauS() {return bureauS;}
	public void setBureauS(String bureauS) {this.bureauS = bureauS;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bureauS);
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
		Scolarite other = (Scolarite) obj;
		return Objects.equals(bureauS, other.bureauS);
	}

	@Override
	public String toString() {
		return "Scolarite [bureauS=" + bureauS + "]";
	}
}