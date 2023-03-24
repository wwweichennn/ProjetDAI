//package metier;
//
//import java.util.Date;
//import java.util.Objects;
//
//import javax.persistence.*;
//
//import enumtype.StatutJustificatif;
//
//@Entity
//
//@Table(name = "Justificatif")
//public class Justificatif {
//	
//	//Propriétés
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int idJ;
//	
//	@Column(name="StatutJ")
//	private StatutJustificatif statut;
//	
//	@Column(name="Pdf")
//	private String url;
//	
//	@Column(name="DateDebut")
//	@Temporal(javax.persistence.TemporalType.DATE)
//	
//	private Date dateDebut;	
//	@Column(name="DateFin")
//	
//	@Temporal(javax.persistence.TemporalType.DATE)
//	private Date dateFin;
//
//
//	//relation deposer
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "CodeU")
//	
//    private Users utilisateur;
//
//	
//	//Constructeurs
//	public Justificatif() {	}
//
//	public Justificatif (StatutJustificatif statut, String url,  Date dateDebut, Date dateFin, Users utilisateur) {
//		this.statut = statut;
//		this.url = url;
//		this.dateDebut = dateDebut;
//		this.dateFin = dateFin;
//		this.utilisateur = utilisateur;
//	}
//	
//	//Getter & Setter
//	public Users getUtilisateur() {
//		return utilisateur;
//	}
//
//	public void setUtilisateur(Users utilisateur) {
//		this.utilisateur = utilisateur;
//	}
//
//	public int getIdJ() {
//		return idJ;
//	}
//
//	public void setIdJ(int idJ) {
//		this.idJ = idJ;
//	}
//
//	public StatutJustificatif getStatut() {
//		return statut;
//	}
//
//	public void setStatut(StatutJustificatif statut) {
//		this.statut = statut;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setPdf(String url) {
//		this.url = url;
//	}
//
//	public Date getDateDebut() {
//		return dateDebut;
//	}
//
//	public void setDateDebut(Date dateDebut) {
//		this.dateDebut = dateDebut;
//	}
//
//	public Date getDateFin() {
//		return dateFin;
//	}
//
//	public void setDateFin(Date dateFin) {
//		this.dateFin = dateFin;
//	}
//
//	//Méthode
//	@Override
//	public int hashCode() {
//		return Objects.hash(dateDebut, dateFin, idJ, url, statut);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if ((obj == null) || (getClass() != obj.getClass()))
//			return false;
//		Justificatif other = (Justificatif) obj;
//		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin) && idJ == other.idJ
//				&& Objects.equals(url, other.url) && statut == other.statut;
//	}
//
//	@Override
//	public String toString() {
//		return "Justificatif [idJ=" + idJ + ", statut=" + statut + ", pdf=" + url + ", dateDebut=" + dateDebut
//				+ ", dateFin=" + dateFin + "]";
//	}
//
//}
