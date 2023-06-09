
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity(name="Seance")
public class Seance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeSeance")
	private int idSeance;
	
	@Column(name="SalleSeance")
	private String SalleS;
	
	@Column(name="DateSeance")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateS;
	
	@Column(name="DureeSeance")
	private int dureeS;
	
	
	@Column(name="HeureDebut")
	@Temporal(javax.persistence.TemporalType.TIME)
	private Date heureDebut;
	
	@Column(name="StatutFicheAppel")
	private String StatutFicheAppel;
	

	//--------participer-----------
	@OneToMany(mappedBy = "seance", cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodeU", updatable = false, insertable = false)
	private Map<Utilisateurs,Participer> participer = new HashMap(0);
	
	//---------donner---------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeU")
	private Utilisateurs users;
	
	//---------appartenir------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeC")
	private Cours cours ;
	
	
	public Seance() {}
	public Seance(String salleS, Date dateS, int dureeS, Date heureDebut, String statutFicheAppel,
			Utilisateurs users, Cours cours) {
		super();
		SalleS = salleS;
		this.dateS = dateS;
		this.dureeS = dureeS;
		this.heureDebut = heureDebut;
		StatutFicheAppel = statutFicheAppel;
		this.users = users;
		this.cours = cours;
	}


	
	public Map<Utilisateurs, Participer> getParticiper() {
		return participer;
	}
	
	public void setParticiper(Map<Utilisateurs, Participer> participer) {this.participer = participer;}
	public Utilisateurs getUsers() {return users;}
	public void setUsers(Utilisateurs users) {this.users = users;}
	public Cours getCours() {return cours;}
	public void setCours(Cours cours) {this.cours = cours;}
	public int getIdSeance() {return idSeance;}
	public void setIdSeance(int idSeance) {this.idSeance = idSeance;}
	public String getSalleS() {return SalleS;}
	public void setSalleS(String salleS) {SalleS = salleS;}
	public Date getDateS() {return dateS;}
	public void setDateS(Date dateS) {this.dateS = dateS;}
	public int getDureeS() {return dureeS;}
	public void setDureeS(int dureeS) {this.dureeS = dureeS;}
	public Date getHeureDebut() {return heureDebut;}
	public void setHeureDebut(Date heureDebut) {this.heureDebut = heureDebut;}
	public String getStatutFicheAppel() {return StatutFicheAppel;}
	public void setStatutFicheAppel(String statutFicheAppel) {StatutFicheAppel = statutFicheAppel;}

	@Override
	public int hashCode() {
		return Objects.hash(idSeance);
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
		return idSeance == other.idSeance;
	}

	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", SalleS=" + SalleS + ", dateS=" + dateS + ", dureeS=" + dureeS
				+ ", heureDebut=" + heureDebut + ", StatutFicheAppel=" + StatutFicheAppel + "]";
	}
	
	

}
=======
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity(name="Seance")
public class Seance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeSeance")
	private int idSeance;
	
	@Column(name="SalleSeance")
	private String SalleS;
	
	@Column(name="DateSeance")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateS;
	
	@Column(name="DureeSeance")
	private int dureeS;
	
	
	@Column(name="HeureDebut")
	@Temporal(javax.persistence.TemporalType.TIME)
	private Date heureDebut;
	
	@Column(name="StatutFicheAppel")
	private String StatutFicheAppel;
	

	//--------participer-----------
	@OneToMany(mappedBy = "seance", cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodeU", updatable = false, insertable = false)
	private Map<Users,Participer> participer = new HashMap(0);
	
	//---------donner---------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeU")
	private Users users;
	
	//---------appartenir------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeC")
	private Cours cours ;
	
	
	public Seance() {}
	public Seance(String salleS, Date dateS, int dureeS, Date heureDebut, String statutFicheAppel,
			Users users, Cours cours) {
		super();
		SalleS = salleS;
		this.dateS = dateS;
		this.dureeS = dureeS;
		this.heureDebut = heureDebut;
		StatutFicheAppel = statutFicheAppel;
		this.users = users;
		this.cours = cours;
	}


	
	public Map<Users, Participer> getParticiper() {
		return participer;
	}
	
	public void setParticiper(Map<Users, Participer> participer) {this.participer = participer;}
	public Users getUsers() {return users;}
	public void setUsers(Users users) {this.users = users;}
	public Cours getCours() {return cours;}
	public void setCours(Cours cours) {this.cours = cours;}
	public int getIdSeance() {return idSeance;}
	public void setIdSeance(int idSeance) {this.idSeance = idSeance;}
	public String getSalleS() {return SalleS;}
	public void setSalleS(String salleS) {SalleS = salleS;}
	public Date getDateS() {return dateS;}
	public void setDateS(Date dateS) {this.dateS = dateS;}
	public int getDureeS() {return dureeS;}
	public void setDureeS(int dureeS) {this.dureeS = dureeS;}
	public Date getHeureDebut() {return heureDebut;}
	public void setHeureDebut(Date heureDebut) {this.heureDebut = heureDebut;}
	public String getStatutFicheAppel() {return StatutFicheAppel;}
	public void setStatutFicheAppel(String statutFicheAppel) {StatutFicheAppel = statutFicheAppel;}

	@Override
	public int hashCode() {
		return Objects.hash(idSeance);
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
		return idSeance == other.idSeance;
	}

	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", SalleS=" + SalleS + ", dateS=" + dateS + ", dureeS=" + dureeS
				+ ", heureDebut=" + heureDebut + ", StatutFicheAppel=" + StatutFicheAppel + "]";
	}
	
	

}
