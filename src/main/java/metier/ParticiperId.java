<<<<<<< HEAD
//package metier;
//
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class ParticiperId {
//	@Column(name="CodeUt")
//	private int codeUt;
//	@Column(name="CodeSea")
//	private int codeSea;
//	
//	public ParticiperId() {
//		
//	}
//
//	public ParticiperId(int codeUt, int codeSea) {
//		
//		this.codeUt = codeUt;
//		this.codeSea = codeSea;
//	}
//
//	public int getCodeUt() {
//		return codeUt;
//	}
//
//	public void setCodeUt(int codeUt) {
//		this.codeUt = codeUt;
//	}
//
//	public int getCodeSea() {
//		return codeSea;
//	}
//
//	public void setCodeSea(int codeSea) {
//		this.codeSea = codeSea;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(codeSea, codeUt);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ParticiperId other = (ParticiperId) obj;
//		return codeSea == other.codeSea && codeUt == other.codeUt;
//	}
//
//	@Override
//	public String toString() {
//		return "ParticiperId [codeUt=" + codeUt + ", codeSea=" + codeSea + "]";
//	}
//	
//	
//	
//
//}
=======
package metier;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticiperId implements java.io.Serializable {

	@Column(name="CodeUt")
	private int codeUt;

	@Column(name="CodeSea")
	private int codeSea;

	public ParticiperId() {

	}

	public ParticiperId(int codeUt, int codeSea) {
		this.codeUt = codeUt;
		this.codeSea = codeSea;
	}

	public int getCodeUt() {
		return codeUt;
	}

	public void setCodeUt(int codeUt) {
		this.codeUt = codeUt;
	}

	public int getCodeSea() {
		return codeSea;
	}

	public void setCodeSea(int codeSea) {
		this.codeSea = codeSea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeSea, codeUt);
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
		return codeSea == other.codeSea && codeUt == other.codeUt;
	}

	@Override
	public String toString() {
		return "ParticiperId [codeUt=" + codeUt + ", codeSea=" + codeSea + "]";
	}




}
>>>>>>> refs/remotes/origin/Binôme
