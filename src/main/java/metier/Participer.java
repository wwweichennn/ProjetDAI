package metier;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "Participer")
public class Participer {
	
	@EmbeddedId
	private ParticiperID id;
	
	@Column(name = "Status")
	private String StatutAppel;
	
	/*----- participer vers users -----*/
	
	@ManyToOne
	@JoinColumn(name = "CodeU", insertable = false, updatable = false)	
	private Users users;												

	/*----- participer vers seance -----*/
	@ManyToOne
    @JoinColumn(name = "CodeSeance", insertable = false, updatable = false)
	private Seance seance;
	
	
	public Participer() {}
	public Participer(ParticiperID id, String statutAppel, Users users, Seance seance) {
		super();
		this.id = id;
		this.StatutAppel = statutAppel;
		this.users = users;
		this.seance = seance;
	}


	public String getStatutAppel() {return StatutAppel;}
	public void setStatutAppel(String statutAppel) {StatutAppel = statutAppel;}
	public ParticiperID getId() {return id;}
	public void setId(ParticiperID id) {this.id = id;}
	public Users getUsers() {return users;}
	public void setUsers(Users users) {this.users = users;}
	public Seance getSeance() {return seance;}
	public void setSeance(Seance seance) {this.seance = seance;}

	@Override
	public int hashCode ()
		{
		int hash = 5;
		hash = 43 * hash + Objects.hashCode(this.getId());
		return hash;
		}

	@Override
	public boolean equals (Object obj)
		{
		if (obj == null) return false;
		if (!(obj instanceof Participer)) return false;

		return Objects.equals(this.getId(), ((Participer)obj).getId());
		}

	@Override
	public String toString() {
		return "Participer [id=" + id + ", StatutAppel=" + StatutAppel + ", users=" + users + ", seance=" + seance
				+ "]";
	}
}