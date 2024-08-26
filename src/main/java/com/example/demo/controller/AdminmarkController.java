package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminmarkModel;
import com.example.demo.service.AdminmarkService;

@RestController

public class AdminmarkController {

	@Autowired
	public AdminmarkService AdminmarkServiceApi;

	@CrossOrigin("*")

	@PostMapping("/adminmarkenter")

	public AdminmarkModel mark(@RequestBody AdminmarkModel model) {

		return AdminmarkServiceApi.markuplode(model);

	}

	@CrossOrigin("*")

	@GetMapping("/viewmark")

	public AdminmarkModel view(@RequestBody AdminmarkModel model) {

		return AdminmarkServiceApi.studentView(model);

	}
	
	@CrossOrigin("*")

	@PutMapping("/updatemark")

	public String update(@RequestBody AdminmarkModel model) {

		return AdminmarkServiceApi.updatemark(model);

	}

}
