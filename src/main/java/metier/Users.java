package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;


@Entity(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeU", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Users")

public class Users implements java.io.Serializable
{
	//priorite
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodeU")
	private int CodeU;
	
	private String identifiant;

	@Column(name = "motDePasse")
	private String motDePasse;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "sexe")
	private String sexe;

	@Column(name = "dateNaissance")
	private Date dateNaissance;

	@Column(name = "mailSupplement")
	private String mailSupplement;

	@Column(name = "photo")
	private String photo;
	
	
	//------participer---------
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodeSeance", updatable = false, insertable = false)
	private Map<Seance,Participer> participer = new HashMap(0);
	
	
	//------donner------
	@OneToMany(mappedBy="users",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Seance> seances = new HashSet<>();
	
	//-------deposer------
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Justificatif> justificatifs = new HashSet<>(0);
	
	//-----enseigner------
	@ManyToMany
	@JoinTable(name = "enseigner",
			   joinColumns = @JoinColumn(name = "CodeU"),
		inverseJoinColumns = @JoinColumn(name = "CodeC"))
	private Set<Cours> cours = new HashSet<>(0);
	 
	
	//Constructeur
	public Users() {}

	public Users(String identifiant, String motDePasse, String nom, String prenom, String sexe, Date dateNaissance,
			String mailSupplement, String photo) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.mailSupplement = mailSupplement;
		this.photo = photo;
	}
	

	//Getters & Setters
	public String getIdentifiant() {return identifiant;}
	public void setIdentifiant(String identifiant) {this.identifiant = identifiant;}
	public String getMotDePasse() {return motDePasse;}
	public void setMotDePasse(String motDePasse) {this.motDePasse = motDePasse;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getSexe() {return sexe;}
	public void setSexe(String sexe) {this.sexe = sexe;}
	public Date getDateNaissance() {return dateNaissance;}
	public void setDateNaissance(Date dateNaissance) {this.dateNaissance = dateNaissance;}
	public String getMailSupplement() {return mailSupplement;}
	public void setMailSupplement(String mailSupplement) {this.mailSupplement = mailSupplement;}
	public String getPhoto() {return photo;}
	public void setPhoto(String photo) {this.photo = photo;}
	public Map<Seance, Participer> getParticiper() {return participer;}
	public void setParticiper(Map<Seance, Participer> participer) {this.participer = participer;}
	public Set<Seance> getSeances() {return seances;}
	public void setSeances(Set<Seance> seances) {this.seances = seances;}
	public Set<Justificatif> getJustificatifs() {return justificatifs;}
	public void setJustificatifs(Set<Justificatif> justificatifs) {this.justificatifs = justificatifs;}
	public Set<Cours> getCours() {return cours;}
	public void setCours(Set<Cours> cours) {this.cours = cours;}
	
	public void ajouteCours (Cours c)
	{
	this.cours.add(c);
	c.getUsers().add(this);
	}

	
	public void participe(Seance s,String statutAppel) {
		
		Participer p = (Participer)this.participer.get(s);

		if (p == null)
			{
			/*----- La décision est créée et ajoutée -----*/
			Participer pa = new Participer(new ParticiperID(this.CodeU, s.getIdSeance()), statutAppel,this,s);
			this.participer.put(s,pa);
			s.getParticiper().put(this, pa);
			}
		else
			{
			/*----- Mise à jour de la décision -----*/
			p.setStatutAppel(statutAppel);
			}
		}
		
	public int getCodeU() {
		return CodeU;
	}

	public void setCodeU(int codeU) {
		CodeU = codeU;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(dateNaissance, other.dateNaissance);
	}

	@Override
	public String toString() {
		return "users [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}