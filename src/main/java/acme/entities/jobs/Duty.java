
package acme.entities.jobs;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "descriptor")
})
public class Duty extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				titleDuty;

	@NotBlank
	private String				descriptionDuty;

	@Range(min = 0, max = 100)
	private Integer				percentage;

	@NotNull
	@Valid
	@ManyToOne
	private Descriptor			descriptor;

}
