
package acme.features.messageThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	// Internal state

	@Autowired
	private AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "id", "title", "moment");
	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		// TODO Auto-generated method stub
		MessageThread result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneMessageThreadById(id);
		//result = this.repository.findManyMessageThreads();
		return result;
	}

	//Interface

}
