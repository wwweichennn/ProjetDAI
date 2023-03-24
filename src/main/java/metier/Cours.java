
package metier;

import java.util.Objects;

import javax.persistence.*;


@Entity(name="Cours")
public class Cours {

	//Propriétés
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeC")
	private int idCours;
	
	@Column(name="NomC")
	private String nomCours;

	
	//Constructeurs
	public Cours() {}


	public Cours(String nomCours) {
		this.nomCours = nomCours;
	}


	//Getter & Setter
	public int getIdCours() {return idCours;}


	public void setIdCours(int idCours) {this.idCours = idCours;}


	public String getNomCours() {return nomCours;}


	public void setNomCours(String nomCours) {this.nomCours = nomCours;}


	@Override
	public int hashCode() {
		return Objects.hash(idCours, nomCours);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		return idCours == other.idCours && Objects.equals(nomCours, other.nomCours);
	}


	@Override
	public String toString() {
		return "Cours [" + idCours + ", nomCours=" + nomCours + "]";
	}
	
	
	
	
	
}
=======
package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Cours")

public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodeC")
	private int idCours;
	
	@Column(name = "nomCours")
	private String nomCours;
	
	
	/*----- enseigner -----*/	
	@ManyToMany(mappedBy = "cours")
	private Set<Users> users = new HashSet(0);
	
	//--------appartenir-----------
	@OneToMany(mappedBy="cours",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Seance> seances = new HashSet<>(0);
	
	
	public Cours() {}

	public Cours(String nomCours) {
		super();
		this.nomCours = nomCours;
	}



	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public int getIdCours() {return idCours;}
	public void setIdCours(int idCours) {this.idCours = idCours;}
	public String getNomCours() {return nomCours;}
	public void setNomCours(String nomCours) {this.nomCours = nomCours;}

	@Override
	public int hashCode() {
		return Objects.hash(idCours, nomCours);}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		return idCours == other.idCours && Objects.equals(nomCours, other.nomCours);}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", nomCours=" + nomCours + "]";}
	
}

