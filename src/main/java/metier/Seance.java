package metier;

import java.util.Date;
import java.util.HashMap;
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

import enumtype.StatutFicheAppel;
@Entity
@Table(name="Seance")
public class Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	

//	
//    @OneToMany(mappedBy = "seance",cascade = CascadeType.ALL)
//    @MapKeyColumn(name = "CodeUt", updatable = false, insertable = false)
//    private HashMap<Utilisateurs,Participer> validerMap = new HashMap<>();
//


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



	public HashMap<Utilisateurs, Participer> getValiderMap() {
		return validerMap;
	}



	public void setValiderMap(HashMap<Utilisateurs, Participer> validerMap) {
		this.validerMap = validerMap;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dateS, dureeS, ficheAppelStatut, heureDebutS, idSeance, salleS, validerMap);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(dateS, other.dateS)
				&& Double.doubleToLongBits(dureeS) == Double.doubleToLongBits(other.dureeS)
				&& ficheAppelStatut == other.ficheAppelStatut && Objects.equals(heureDebutS, other.heureDebutS)
				&& idSeance == other.idSeance && Objects.equals(salleS, other.salleS)
				&& Objects.equals(validerMap, other.validerMap);
	}



	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", salleS=" + salleS + ", dateS=" + dateS + ", dureeS=" + dureeS
				+ ", heureDebutS=" + heureDebutS + ", ficheAppelStatut=" + ficheAppelStatut + ", validerMap="
				+ validerMap + "]";
	}
	
	
	
    
    
}
