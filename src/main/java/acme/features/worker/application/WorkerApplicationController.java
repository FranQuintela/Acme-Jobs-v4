
package acme.features.worker.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.jobs.Application;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/application/")
public class WorkerApplicationController extends AbstractController<Worker, Application> {

	@Autowired
	private WorkerApplicationShowService		showService;

	@Autowired
	private WorkerApplicationListMineService	listMineService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

	}

}
