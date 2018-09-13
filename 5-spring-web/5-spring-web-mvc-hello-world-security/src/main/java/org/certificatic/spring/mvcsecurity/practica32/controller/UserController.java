package org.certificatic.spring.mvcsecurity.practica32.controller;

import org.certificatic.spring.mvcsecurity.practica32.service.api.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/userSection")
public class UserController {

	@Autowired
	@Qualifier("admin-data-service")
	private IDataService adminDataService;

	@Autowired
	@Qualifier("root-data-service")
	private IDataService rootDataService;

	@Autowired
	@Qualifier("user-data-service")
	private IDataService userDataService;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserPage(Model model, @RequestParam(value = "callmethod", required = false) String callmethod) {

		log.info("show user page ------------------");

		if (callmethod != null) {

			String data = null;

			log.info("callmethod: {}", callmethod);
			if (callmethod.equals("admin"))
				data = adminDataService.getData();
			else if (callmethod.equals("root"))
				data = rootDataService.getData();
			else if (callmethod.equals("user"))
				data = userDataService.getData();

			log.info("data: {}", data);

			model.addAttribute("server_data", data);
		}

		model.addAttribute("currentSecc", "userSection");

		return "secure/view_user_section";
	}

}
