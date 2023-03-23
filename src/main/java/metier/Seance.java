package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import metier.Participer;

import enumtype.StatutFicheAppel;
@Entity
@Table(name="Seance")
public class Seance {
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
	

//	Relation participer
 @OneToMany(mappedBy = "seance",cascade = CascadeType.ALL)
 @MapKeyColumn(name = "CodeU", updatable = false, insertable = false)
   private Map<Utilisateurs,Participer> validerMapUtilisateur = new HashMap<>();


public Seance () {
	
}
	public Seance(int idSeance, String salleS, Date dateS, double dureeS, String heureDebutS,
			StatutFicheAppel ficheAppelStatut) {
	
		this.idSeance = idSeance;
		this.salleS = salleS;
		this.dateS = dateS;
		this.dureeS = dureeS;
		this.heureDebutS = heureDebutS;
		this.ficheAppelStatut = ficheAppelStatut;

	}



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



	public Map<Utilisateurs, Participer> getValiderMapUtilisateur() {
		return validerMapUtilisateur;
	}



	public void setValiderMapUtilisateur(HashMap<Utilisateurs, Participer> validerMapUtilisateur) {
		this.validerMapUtilisateur = validerMapUtilisateur;
	}
	
	



}