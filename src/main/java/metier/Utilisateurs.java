package metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeU",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Utilisateur")



public class Utilisateurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeU")
	public int id;
	@Column(name="SexeU")
	public String sexe;
	@Column(name="NomU")
	public String nom;
	@Column(name="PrenomU")
	public String prenom;
	@Column(name="DateNaissance")
	public String dateNaissance;
	@Column(name="MailU")
	public String mail;
	@Column(name="TelU")
	public String tel;
	@Column(name="MailSupl")
	public String mailSupplement;


	//relation deposer


	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private Set<Justificatif> justificatifs = new HashSet<>(0);
	public Utilisateurs() {
		super();
	}



	public Utilisateurs( String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
			String mailSupplement) {
		super();
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.tel = tel;
		this.mailSupplement = mailSupplement;
	}




	public Set<Justificatif> getJustificatifs() {
		return justificatifs;
	}



	public void setJustificatifs(Set<Justificatif> justificatifs) {
		this.justificatifs = justificatifs;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMailSupplement() {
		return mailSupplement;
	}
	public void setMailSupplement(String mailSupplement) {
		this.mailSupplement = mailSupplement;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, id, justificatifs, mail, mailSupplement, nom, prenom, sexe, tel);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Utilisateurs other = (Utilisateurs) obj;
		return Objects.equals(dateNaissance, other.dateNaissance) && id == other.id
				&& Objects.equals(justificatifs, other.justificatifs) && Objects.equals(mail, other.mail)
				&& Objects.equals(mailSupplement, other.mailSupplement) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(sexe, other.sexe)
				&& Objects.equals(tel, other.tel);
	}



	@Override
	public String toString() {
		return "Utilisateurs [id=" + id + ", sexe=" + sexe + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", mail=" + mail + ", tel=" + tel + ", mailSupplement=" + mailSupplement
				+ ", justificatifs=" + justificatifs + "]";
	}








}
