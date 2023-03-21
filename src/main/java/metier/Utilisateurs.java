package metier;

import java.util.Objects;


@Entity(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeU",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Utilisateur")

public class Utilisateurs {
	
	public int id;
	public String sexe;
	public String nom;
	public String prenom;
	public String dateNaissance;
	public String mail;
	public String tel;
	public String mailSupplement;
	
	
	
	
	public Utilisateurs() {
		super();
	}

	
	
	public Utilisateurs(int id, String sexe, String nom, String prenom, String dateNaissance, String mail, String tel,
			String mailSupplement) {
		super();
		this.id = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.tel = tel;
		this.mailSupplement = mailSupplement;
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
		return Objects.hash(dateNaissance, id, mail, mailSupplement, nom, prenom, sexe, tel);
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
		return Objects.equals(dateNaissance, other.dateNaissance) && id == other.id && Objects.equals(mail, other.mail)
				&& Objects.equals(mailSupplement, other.mailSupplement) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(sexe, other.sexe)
				&& Objects.equals(tel, other.tel);
	}



	@Override
	public String toString() {
		return "Utilisateurs [id=" + id + ", sexe=" + sexe + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", mail=" + mail + ", tel=" + tel + ", mailSupplement=" + mailSupplement + "]";
	}
	
	
	

}
