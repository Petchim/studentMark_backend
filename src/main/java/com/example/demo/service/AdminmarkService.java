package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.AdminmarkRepo;
import com.example.demo.model.AdminmarkModel;

@Service
public class AdminmarkService {

	@Autowired
	private AdminmarkRepo AdminmarkRepoApi;

	public AdminmarkModel markuplode(AdminmarkModel model) {
		if (model.getMaths() >= 35 && model.getEnglish() >= 35 && model.getScience() >= 35 && model.getSocial() >= 35
				&& model.getTamil() >= 35) {
			int totalmark = model.getEnglish() + model.getMaths() + model.getScience() + model.getSocial()
					+ model.getTamil();

			model.setTotal(totalmark);

			int percentage = totalmark / 5;
			model.setPercentage(percentage);
			model.setStatus("pass");
			return AdminmarkRepoApi.save(model);
		} else {

			int totalmark = model.getEnglish() + model.getMaths() + model.getScience() + model.getSocial()
					+ model.getTamil();

			model.setTotal(totalmark);

			int percentage = totalmark / 5;
			model.setPercentage(percentage);

			model.setStatus("fail");
			return AdminmarkRepoApi.save(model);

		}

	}

	public AdminmarkModel studentView(AdminmarkModel model) {

		AdminmarkModel view = AdminmarkRepoApi.findByRollnumber(model.getRollnumber());
		return view;

	}

	public String updatemark(AdminmarkModel model) {

		AdminmarkModel update = AdminmarkRepoApi.findByRollnumber(model.getRollnumber());

		if (update != null) {
			update.setMaths(model.getMaths());
			update.setEnglish(model.getEnglish());
			update.setMaths(model.getMaths());
			update.setScience(model.getSocial());
			update.setSocial(model.getSocial());

			 AdminmarkRepoApi.save(update);
			 return "update";
		} else {
			return "no roll number";
		}

	}

}
