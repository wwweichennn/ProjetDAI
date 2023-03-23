package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity(name="Justificatif")
public class Justificatif implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodeJ")
	private int CodeJ;

	@Column(name="Validation")
	private boolean validation;
	
	@Column(name="Url")
	private String url;

	@Column(name="DateDebut")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDeb;

	@Column(name="DateFin")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;
	
	/**
	 * Relations.
	 */	
	
	/*----- DEPOSER -----*/
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name="CodeU")
	private Users users;

	public Users getUsersJustificatif() {
		return users;
	}

	public void setUsersJustificatif(Users users) {
		this.users = users;
	}
	
	
	public Justificatif() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeurs.
	 */

	public Justificatif(boolean validation, String url, Date dateDeb, Date dateFin, Users users) {
		super();
		this.validation = validation;
		this.url = url;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.users = users;
	}
	
	public int getCodeJust() {
		return CodeJ;
	}

	public void setCodeJust(int codeJ) {
		CodeJ = codeJ;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CodeJ);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Justificatif other = (Justificatif) obj;
		return CodeJ == other.CodeJ;
	}

	@Override
	public String toString() {
		return "Justificatif [Code=" + CodeJ + ", validation=" + validation + ", url=" + url + ", dateDeb="
				+ dateDeb + ", dateFin=" + dateFin + ", users=" + users + "]";
	}
	
	  



}