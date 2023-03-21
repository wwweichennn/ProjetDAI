package metier;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Cours")

public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodeCours")
	private int idCours;
	
	@Column(name = "nomCours")
	private String nomCours;
	
	
	public Cours() {
		super();
	}


	public Cours(String nomCours) {
		super();
		this.nomCours = nomCours;
	}


	public int getIdCours() {
		return idCours;
	}


	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}


	public String getNomCours() {
		return nomCours;
	}


	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}


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
		return "Cours [idCours=" + idCours + ", nomCours=" + nomCours + "]";
	}

	

}
