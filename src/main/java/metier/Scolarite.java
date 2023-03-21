package metier;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Scolarite")

public class Scolarite extends Utilisateurs{
	
private String bureauS;

public Scolarite() {
	
}

public Scolarite(int id, String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
		String mailSupplement, String bureauS) {
	super(id, sexe, nom, prenom, dateNaissance, mail, tel, mailSupplement);
	this.bureauS=bureauS;

}

public String getBureauS() {
	return bureauS;
}

public void setBureauS(String bureauS) {
	this.bureauS = bureauS;
}

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
