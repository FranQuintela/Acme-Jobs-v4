
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Worker extends UserRole {

	//Serialisation Identifier
	private static final long	serialVersionUID	= 1L;

	//Atributes:

	@NotBlank
	private String				cualificationsRecord;

	@NotBlank
	private String				skillsRecord;
}
