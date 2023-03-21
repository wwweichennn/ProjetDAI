package metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@DiscriminatorValue("Etudiant")

public class Etudiant extends Utilisateurs{

	//proprietes
	
	private Parcours parcour;
	private Formations formation;
	
	//Relation deposer

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Justificatif> justificatifs = new HashSet<>();
	
	//constructeur
	public Etudiant(int id, String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
		String mailSupplement, Parcours parcour, Formations formation) {
		super(id, sexe, nom, prenom, dateNaissance, mail, tel, mailSupplement);
		this.formation=formation;
		this.parcour=parcour;

	}

	public Parcours getParcour() {
		return parcour;
	}

	public void setParcour(Parcours parcour) {
		this.parcour = parcour;
	}

	public Formations getFormation() {
		return formation;
	}

	public void setFormation(Formations formation) {
		this.formation = formation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(formation, parcour);
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
		return formation == other.formation && parcour == other.parcour;
	}

	@Override
	public String toString() {
		return "Etudiant [parcour=" + parcour + ", formation=" + formation + "]";
	}
	
	
	
}
