package org.certificatic.spring.mvcsecurity.practica32.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("controllerBean")
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String showWelcomePage(Model model) {

		log.info("show welcome page ------------------");

		// Obtener objeto Authentication
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		// Obtener username
		String username=((UserDetails)auth.getPrincipal()).getUsername();

		// Obtener Authorities
		List<GrantedAuthority> authorities=(List<GrantedAuthority>)(auth.getAuthorities());

		log.info("username : {}", username);
		log.info("authorities : {}", authorities);

		model.addAttribute("currentSecc", "welcome");

		return "secure/view_welcome";
	}

}
