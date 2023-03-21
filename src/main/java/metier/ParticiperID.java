package metier;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticiperID implements Serializable{
	
	@Column(name = "CodeUsers")
	private int codeU;

	@Column(name = "CodeSeance")
	private int codeS;

	public ParticiperID() {
		super();
	}

	public ParticiperID(int codeU, int codeS) {
		super();
		this.codeU = codeU;
		this.codeS = codeS;
	}

	public int getCodeU() {
		return codeU;
	}

	public void setCodeU(int codeU) {
		this.codeU = codeU;
	}

	public int getCodeS() {
		return codeS;
	}

	public void setCodeS(int codeS) {
		this.codeS = codeS;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeS, codeU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticiperID other = (ParticiperID) obj;
		return codeS == other.codeS && codeU == other.codeU;
	}

	@Override
	public String toString() {
		return "ParticiperID [codeU=" + codeU + ", codeS=" + codeS + "]";
	}
	

}
