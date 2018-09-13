package org.certificatic.spring.soba.mvc.controller.customer;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardCustomerController {

	@RequestMapping(value = { "/customer/dashboard" }, method = RequestMethod.GET)
	public String showDashboardPage(HttpSession session, Locale locale, Model model) {

		model.addAttribute("currentSecc", "dashboard");

		return "customer/dashboard";
	}
}
