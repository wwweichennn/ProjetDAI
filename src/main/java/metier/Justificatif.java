package metier;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import enumtype.StatutJustificatif;

@Entity


public class Justificatif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idJ;
	
	private StatutJustificatif statut;

	private String url;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;

	//relation deposer

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CodeU")
	
    private Utilisateurs utilisateur;


	public Justificatif() {

	}

	public Justificatif(String url, StatutJustificatif statut, Date dateDebut, Date dateFin, Utilisateurs utilisateur) {
		this.url = url;
		this.statut=statut;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.utilisateur=utilisateur;
	}



	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getIdJ() {
		return idJ;
	}

	public void setIdJ(int idJ) {
		this.idJ = idJ;
	}

	public StatutJustificatif getStatut() {
		return statut;
	}

	public void setStatut(StatutJustificatif statut) {
		this.statut = statut;
	}

	public String getUrl() {
		return url;
	}

	public void setPdf(String url) {
		this.url = url;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}





	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dateFin, idJ, url, statut);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Justificatif other = (Justificatif) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin) && idJ == other.idJ
				&& Objects.equals(url, other.url) && statut == other.statut;
	}

	@Override
	public String toString() {
		return "Justificatif [idJ=" + idJ + ", statut=" + statut + ", pdf=" + url + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}






}
