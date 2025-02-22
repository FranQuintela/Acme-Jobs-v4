
package acme.entities.messageThreads;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "title")
})
public class MessageThread extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	@NotBlank
	private String					title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date					moment;

	@Valid
	@OneToMany
	private Collection<UserAccount>	involvedUsers;

	//Relationships -----------------------------------------------
	@Valid
	@ManyToOne(optional = true)
	private Authenticated			creator;

}
