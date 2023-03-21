package metier;

import java.io.File;
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
import javax.persistence.Temporal;
import enumtype.StatutJustificatif;

@Entity(name = "Justificatifs")

public class Justificatif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeJ")	
	private int idJ;
	@Column(name="Statut")
	private StatutJustificatif statut;
	@Column(name="Pdf")
	private File pdf;
	@Column(name="DateDebut")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
	@Column(name="DateFin")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;
	
	//relation deposer 
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Utilisateurs user;

	
	public Justificatif() {
		
	}
	
	public Justificatif(int idJ, File pdf, StatutJustificatif statut, Date dateDebut, Date dateFin, Utilisateurs user) {
		super();
		this.idJ = idJ;
		this.pdf = pdf;
		this.statut=statut;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.user=user;
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
	
	

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
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
