
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.jobs.Application;
import acme.framework.repositories.AbstractRepository;

public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneApplicationById(int id);

	@Query("select a from Application a where a.worker.id = ?1")
	Collection<Application> findManyByWorkerId(int workerId);
}
