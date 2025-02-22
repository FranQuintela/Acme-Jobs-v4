
package acme.features.administrator.banner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorBannerListService implements AbstractListService<Administrator, Banner> {

	@Autowired
	AdministratorBannerRepository repository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		// TODO Auto-generated method stub

		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan");
	}

	@Override
	public Collection<Banner> findMany(final Request<Banner> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Collection<Banner> result;

		result = this.repository.findManyAll();

		return result;
	}

}
