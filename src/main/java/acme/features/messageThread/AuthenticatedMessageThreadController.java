
package acme.features.messageThread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.messageThread.MessageThread;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/message-thread/")
public class AuthenticatedMessageThreadController extends AbstractController<Authenticated, MessageThread> {

	@Autowired
	private AuthenticatedMessageThreadListMineService	listMineService;
	//	@Autowired
	//	private AuthenticatedMessageThreadListMineMessagesService	listMineMessagesService;
	@Autowired
	private AuthenticatedMessageThreadShowService		showService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		//		super.addCustomCommand(CustomCommand.LIST_MINE_MESSAGES, BasicCommand.LIST, this.listMineService);

	}
}
