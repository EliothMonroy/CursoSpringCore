package org.certificatic.spring.soba.mvc.controller;

import java.util.Locale;

import org.certificatic.spring.soba.domain.Admin;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.domain.ILogableUser;
import org.certificatic.spring.soba.domain.User;
import org.certificatic.spring.soba.service.account.api.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({ "userSession", "logableUser" })
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showLoginPage(Locale locale,
			Model model) {

		model.addAttribute("command", new User());

		return "login";
	}

	@RequestMapping(value = { "/login", "" }, method = RequestMethod.POST)
	public String login(Locale locale, Model model, @ModelAttribute User user) {

		log.info("loggear a {}", user);

		ILogableUser logableUser = loginService.checkLoginUser(user.getUsername(), user.getPassword());

		if (logableUser == null)
			return "redirect:?error=Unknown user or password";

		log.info("logableUser instanceof Customer: {}", (logableUser instanceof Customer));
		log.info("logableUser instanceof Admin: {}", (logableUser instanceof Admin));

		if (logableUser instanceof Customer)
			log.info("loggeado {}", (Customer) logableUser);
		else
			log.info("loggeado {}", (Admin) logableUser);

		model.addAttribute("userSession", user);

		if (logableUser instanceof Customer)
			model.addAttribute("logableUser", (Customer) logableUser);
		else
			model.addAttribute("logableUser", (Admin) logableUser);

		if (logableUser instanceof Customer)
			return "redirect:customer/welcome";
		else
			return "redirect:admin/welcome";
	}

	@RequestMapping(value = { "/logout", "" }, method = RequestMethod.GET)
	public String logout(Locale locale, Model model, SessionStatus status) {

		status.setComplete();
		return "redirect:/";
	}
}
