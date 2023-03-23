package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.*;

import metier.Participer;

import enumtype.StatutFicheAppel;

@Entity
@Table(name="Seance")
public class Seance {
	//Propriété
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeSea")
	private int idSeance;

	@Column(name = "SalleS")
	private String salleS;

	@Column(name = "DateS")
	@Temporal(TemporalType.DATE)
	private Date dateS;

	@Column(name = "DureeS")
	private double dureeS;

	@Column(name = "HeureS")
	private String heureDebutS;

	@Column(name = "StatutS")
	private StatutFicheAppel ficheAppelStatut;


	//Relation vers Appartenir
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeC")
	private Cours cours;

	//	Relation vers participer
	@OneToMany(mappedBy = "seance",cascade = CascadeType.ALL)
	@MapKeyColumn(name = "CodeU", updatable = false, insertable = false)
	private Map<Utilisateurs,Participer> participationUtilisateur = new HashMap<>();

	//Constructeurs
	public Seance () {	}

	public Seance(String salleS, Date dateS, double dureeS, String heureDebutS,
			StatutFicheAppel ficheAppelStatut, Cours cours) {

		this.salleS = salleS;
		this.dateS = dateS;
		this.dureeS = dureeS;
		this.heureDebutS = heureDebutS;
		this.ficheAppelStatut = ficheAppelStatut;
		this.cours = cours;
		this.participationUtilisateur = null;
	}

	//Gettter & Setter
	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public String getSalleS() {
		return salleS;
	}

	public void setSalleS(String salleS) {
		this.salleS = salleS;
	}

	public Date getDateS() {
		return dateS;
	}

	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}

	public double getDureeS() {
		return dureeS;
	}

	public void setDureeS(double dureeS) {
		this.dureeS = dureeS;
	}

	public String getHeureDebutS() {
		return heureDebutS;
	}

	public void setHeureDebutS(String heureDebutS) {
		this.heureDebutS = heureDebutS;
	}

	public StatutFicheAppel getFicheAppelStatut() {
		return ficheAppelStatut;
	}

	public void setFicheAppelStatut(StatutFicheAppel ficheAppelStatut) {
		this.ficheAppelStatut = ficheAppelStatut;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Map<Utilisateurs, Participer> getParticipationUtilisateur() {
		return participationUtilisateur;
	}

	public void setParticipationUtilisateur(Map<Utilisateurs, Participer> participationUtilisateur) {
		this.participationUtilisateur = participationUtilisateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cours, dateS, dureeS, ficheAppelStatut, heureDebutS, idSeance, participationUtilisateur,
				salleS);
	}

	//Méthode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(cours, other.cours) && Objects.equals(dateS, other.dateS)
				&& Double.doubleToLongBits(dureeS) == Double.doubleToLongBits(other.dureeS)
				&& ficheAppelStatut == other.ficheAppelStatut && Objects.equals(heureDebutS, other.heureDebutS)
				&& idSeance == other.idSeance
				&& Objects.equals(participationUtilisateur, other.participationUtilisateur)
				&& Objects.equals(salleS, other.salleS);
	}

	@Override
	public String toString() {
		return "Seance [" + idSeance + ", salleS=" + salleS + ", dateS=" + dateS + ", dureeS=" + dureeS
				+ ", heureDebutS=" + heureDebutS + ", ficheAppelStatut=" + ficheAppelStatut + ", cours=" + cours
				+ ", participationUtilisateur=" + participationUtilisateur + "]";
	}



}