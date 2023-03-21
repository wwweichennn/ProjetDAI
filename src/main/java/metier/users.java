package metier;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeU",discriminatorType=DiscriminatorType.STRING)

public class users {
	//priorite
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodeU")
	private String identifiant;
	
	@Column(name = "CodeU")
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
	
	@Column(name = "phooto")
	private String photo;
	
	//Relation effectuer
	@OneToMany(mappedBy="users",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Seance> seances = new HashSet<>(0);
	
	@OneToMany(mappedBy="users",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Justificatif> justificatifs = new HashSet<>(0);
	
	
	
	
	//Constructeur
	public users() {}
	
	public users(String identifiant, String motDePasse, String nom, String prenom, String sexe, Date dateNaissance,
			String mailSupplement, String photo) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.mailSupplement = mailSupplement;
		this.photo = photo;	}
	
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
		users other = (users) obj;
		return Objects.equals(dateNaissance, other.dateNaissance);}

	@Override
	public String toString() {
		return "users [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
	
}
