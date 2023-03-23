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
