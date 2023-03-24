

package metier;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumtype.StatutAppel;


@Entity
@Table(name="Participer")
public class Participer {

	//Propriétés
	@EmbeddedId
	private ParticiperId idP;

	@Column(name="StatutP")
	private StatutAppel statut;


	//relation vers Utilisateur
	@ManyToOne
	@JoinColumn(name = "CodeU", insertable = false,updatable = false)
	private Utilisateurs utilisateur;

	//Relation vers Seance
	@ManyToOne
	@JoinColumn(name = "CodeSea", insertable = false,updatable = false)
	private Seance seance;

	public Participer () {	}

	public Participer(ParticiperId idP, StatutAppel statut) {
		this.idP = idP;
		this.statut = statut;

	}

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

=======
package metier;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "Participer")
public class Participer {
	
	@EmbeddedId
	private ParticiperID id;
	
	@Column(name = "Status")
	private String StatutAppel;
	
	/*----- participer vers users -----*/
	
	@ManyToOne
	@JoinColumn(name = "CodeU", insertable = false, updatable = false)	
	private Users users;												

	/*----- participer vers seance -----*/
	@ManyToOne
    @JoinColumn(name = "CodeSeance", insertable = false, updatable = false)
	private Seance seance;
	
	
	public Participer() {}
	public Participer(ParticiperID id, String statutAppel, Users users, Seance seance) {
		super();
		this.id = id;
		this.StatutAppel = statutAppel;
		this.users = users;
		this.seance = seance;
	}


	public String getStatutAppel() {return StatutAppel;}
	public void setStatutAppel(String statutAppel) {StatutAppel = statutAppel;}
	public ParticiperID getId() {return id;}
	public void setId(ParticiperID id) {this.id = id;}
	public Users getUsers() {return users;}
	public void setUsers(Users users) {this.users = users;}
	public Seance getSeance() {return seance;}
	public void setSeance(Seance seance) {this.seance = seance;}

	@Override
	public int hashCode ()
		{
		int hash = 5;
		hash = 43 * hash + Objects.hashCode(this.getId());
		return hash;
		}

	@Override
	public boolean equals (Object obj)
		{
		if (obj == null) return false;
		if (!(obj instanceof Participer)) return false;

		return Objects.equals(this.getId(), ((Participer)obj).getId());
		}

	@Override
	public String toString() {
		return "Participer [id=" + id + ", StatutAppel=" + StatutAppel + ", users=" + users + ", seance=" + seance
				+ "]";
	}
}

