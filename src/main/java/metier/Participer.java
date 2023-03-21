package metier;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "Participer")
public class Participer {
	
	@EmbeddedId
	private ParticiperID id;
	
	@Column(name = "Status")
	private String StatutAppel;
	

	public Participer(String statutAppel) {
		super();
		StatutAppel = statutAppel;
	}

	public Participer() {
		super();
	}

	public String getStatutAppel() {
		return StatutAppel;
	}

	public void setStatutAppel(String statutAppel) {
		StatutAppel = statutAppel;
	}
	
	

}
