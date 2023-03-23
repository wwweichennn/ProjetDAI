package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeU",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Utilisateur")
public class Utilisateurs {

	//Propriétés
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeU")
	private int codeU;

	@Column(name="SexeU")
	private String sexe;

	@Column(name="NomU")
	private String nom;

	@Column(name="PrenomU")
	private String prenom;

	@Column(name="DateNaissance")
	private String dateNaissance;

	@Column(name="MailU")
	private String mail;

	@Column(name="TelU")
	private String tel;

	@Column(name="MailSupl")
	private String mailSupplement;


	//relation deposer un justificatif
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private Set<Justificatif> justificatifs = new HashSet<>(0);

	//relation Particper à une seance
	@OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodeSea", updatable = false, insertable = false)
	private Map<Seance,Participer> presence = new HashMap<>();

	//Constructerus
	public Utilisateurs() { }

	public Utilisateurs(String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
			String mailSupplement) {
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.tel = tel;
		this.mailSupplement = mailSupplement;
		this.justificatifs = null;
		this.presence = null;
	}

	//Getter & Setter
	public Set<Justificatif> getJustificatifs() { return justificatifs; }
	public void setJustificatifs(Set<Justificatif> justificatifs) { this.justificatifs = justificatifs; }
	public int getCodeU() {	return codeU; }
	public void setCodeU(int codeU) {this.codeU = codeU;}
	public String getSexe() {return sexe;}
	public void setSexe(String sexe) {this.sexe = sexe;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getDateNaissance() {return dateNaissance;}
	public void setDateNaissance(String dateNaissance) {this.dateNaissance = dateNaissance;}
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	public String getTel() {return tel;}
	public void setTel(String tel) {this.tel = tel;}
	public String getMailSupplement() {return mailSupplement;}
	public void setMailSupplement(String mailSupplement) {this.mailSupplement = mailSupplement;}
	public Map<Seance, Participer> getPresence() {return presence;}
	public void setPresence(Map<Seance, Participer> validerMapSeance) {this.presence = validerMapSeance;}

	//Redéfinition
	@Override
	public int hashCode() {
		return Objects.hash(codeU, dateNaissance, justificatifs, mail, mailSupplement, nom, prenom, sexe, tel,
				presence);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateurs other = (Utilisateurs) obj;
		return codeU == other.codeU && Objects.equals(dateNaissance, other.dateNaissance)
				&& Objects.equals(justificatifs, other.justificatifs) && Objects.equals(mail, other.mail)
				&& Objects.equals(mailSupplement, other.mailSupplement) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(sexe, other.sexe)
				&& Objects.equals(tel, other.tel) && Objects.equals(presence, other.presence);
	}

	@Override
	public String toString() {
		return "Utilisateurs [" + codeU + ", sexe=" + sexe + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", mail=" + mail + ", tel=" + tel + ", mailSupplement="
				+ mailSupplement + ", justificatifs=" + justificatifs + ", presence=" + presence
				+ "]";
	}

}
