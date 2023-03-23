
package metier;

/**
 * Clé composite
 */
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticiperId implements Serializable {
	
	//Propriétés
	@Column(name="CodeU")
	private int codeU;
	
	@Column(name="CodeSea")
	private int idSea;
	
	public ParticiperId() {	}

	public ParticiperId(int codeU, int idSea) {
		
		this.codeU = codeU;
		this.idSea = idSea;
	}

	public int getcodeU() {
		return codeU;
	}

	public void setcodeU(int codeU) {
		this.codeU = codeU;
	}

	public int getidSea() {
		return idSea;
	}

	public void setidSea(int idSea) {
		this.idSea = idSea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSea, codeU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticiperId other = (ParticiperId) obj;
		return idSea == other.idSea && codeU == other.codeU;
	}

	@Override
	public String toString() {
		return "ParticiperId [codeU=" + codeU + ", idSea=" + idSea + "]";
	}}

