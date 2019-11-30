
package acme.features.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.message.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	//	@Query("select m from Authenticated a JOIN a.messageThread m")
	//	Collection<MessageThread> findManyMessageThreads();
	@Query("select m from Message m where m.messageThread.id = ?1")
	Collection<Message> findManyMessageByMessageThread(int id);
	//
	@Query("select m from Message m where m.id = ?1")
	Message findOneMessageById(int id);

}
