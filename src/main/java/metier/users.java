package metier;
import javax.persistence.Entity;


@Entity(name="users")
public class users {
	private String identifiant;
	private String motDePasse;
}
