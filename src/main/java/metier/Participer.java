package metier;

import java.util.Objects;

import javax.persistence.*;

import enumtype.StatutAppel;

@Entity
public class Participer {

	//Propriété
	@EmbeddedId
	private ParticiperId idP;

	private StatutAppel statut;


	//relation vers Utilisateur
	@ManyToOne
	@JoinColumn(name = "CodeUt", insertable = false,updatable = false)
	private Utilisateurs utilisateur;

	//Relation vers Seance
	@ManyToOne
	@JoinColumn(name = "CodeSea", insertable = false,updatable = false)
	private Seance seance;

	//Constructeurs
	public Participer () { }

	public Participer(ParticiperId idP, StatutAppel statut, Utilisateurs utilisateur, Seance seance) {
		this.idP = idP;
		this.statut = statut;
		this.utilisateur = utilisateur;
		this.seance = seance;
	}

	//Getter & Setter
	public ParticiperId getIdP() {
		return idP;
	}

	public void setIdP(ParticiperId idP) {
		this.idP = idP;
	}

	public StatutAppel getStatut() {
		return statut;
	}

	public void setStatut(StatutAppel statut) {
		this.statut = statut;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	//Méthode
	@Override
	public int hashCode() {
		return Objects.hash(idP, seance, statut, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participer other = (Participer) obj;
		return Objects.equals(idP, other.idP) && Objects.equals(seance, other.seance) && statut == other.statut
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Participer [idP=" + idP + ", statut=" + statut + ", utilisateur=" + utilisateur + ", seance=" + seance
				+ "]";
	}





}
