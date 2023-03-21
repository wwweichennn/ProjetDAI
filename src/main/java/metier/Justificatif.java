package metier;

import java.io.File;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Justificatifs")

public class Justificatif {
	private int idJ;
	private StatutJustificatif statut;
	private File pdf;
	private Date dateDebut;
	private Date dateFin;
	
	//relation deposer 
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Etudiant etudiant;

	
	public Justificatif() {
		
	}
	
	public Justificatif(int idJ, File pdf, StatutJustificatif statut, Date dateDebut, Date dateFin) {
		super();
		this.idJ = idJ;
		this.pdf = pdf;
		this.statut=statut;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
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
		return Objects.hash(dateDebut, dateFin, idJ, pdf, statut);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Justificatif other = (Justificatif) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin) && idJ == other.idJ
				&& Objects.equals(pdf, other.pdf) && statut == other.statut;
	}

	@Override
	public String toString() {
		return "Justificatif [idJ=" + idJ + ", statut=" + statut + ", pdf=" + pdf + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

	
	
	
	

}
