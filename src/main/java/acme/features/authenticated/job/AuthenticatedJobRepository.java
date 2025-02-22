
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.deadline > utc_timestamp() and j.status = 1")
	Collection<Job> findManyActiveJobs();

	@Query("select j.job from Descriptor j where j.job.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Descriptor j where j.job.id = ?1")
	Descriptor findOneDescriptorById(int jobId);
}
