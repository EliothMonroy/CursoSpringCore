package org.certificatic.spring.soba.mvc.controller.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.certificatic.spring.soba.domain.Admin;
import org.certificatic.spring.soba.domain.Authority;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.domain.User;
import org.certificatic.spring.soba.mvc.util.IMapUtils;
import org.certificatic.spring.soba.mvc.validator.CreateCustomerFormValidator;
import org.certificatic.spring.soba.mvc.validator.EditCustomerFormValidator;
import org.certificatic.spring.soba.service.account.api.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({ "userSession", "logableUser" })
@RequestMapping(value = "/admin/manage/customers")
public class CustomersManagementAdminController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private CreateCustomerFormValidator createCustomerFormValidator;

	@Autowired
	private EditCustomerFormValidator editCustomerFormValidator;

	private final static Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());

	static {
		map.put(1, "ROLE_ADMIN");
		map.put(2, "ROLE_CUSTOMER");
	}

	@InitBinder(value = "createCustomerForm")
	protected void initBinderCreateCustomerForm(WebDataBinder binder) {
		binder.setValidator(createCustomerFormValidator);
	}

	@InitBinder(value = "editCustomerForm")
	protected void initBinderEditCustomerForm(WebDataBinder binder) {
		binder.setValidator(editCustomerFormValidator);
	}

	@ModelAttribute("authoritiesCatalog")
	public Map<Integer, String> getAuthoritiesCatalog() {
		return map;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showManagementCustomersPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin) {

		log.info("logable user: {}", admin);

		List<Customer> customers = customerService.getAll();

		model.addAttribute("customers", customers);

		model.addAttribute("currentSecc", "manageCustomers");

		return "admin/manage/customers";
	}

	@RequestMapping(value = "/view/{customerId}", method = RequestMethod.GET)
	public String showViewCustomerPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin, @PathVariable Long customerId) {

		Customer customer = customerService.getByCustomerId(customerId);

		if (customer == null)
			return "rediect:/admin/manage/customers";

		model.addAttribute("customer", customer);

		model.addAttribute("currentSecc", "manageCustomers");

		return "admin/manage/customers/view";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateCustomerPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin) {

		Customer customer = new Customer();
		customer.setUser(new User());

		model.addAttribute("createCustomerForm", customer);

		model.addAttribute("currentSecc", "manageCustomers");

		return "admin/manage/customers/create";
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public String createCustomer(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin,
			@Validated @ModelAttribute("createCustomerForm") Customer createCustomerForm, BindingResult result) {

		if (result.hasErrors()) {

			model.addAttribute("currentSecc", "manageCustomers");

			return "admin/manage/customers/create";
		}

		List<Authority> authorities = new ArrayList<>();

		for (Integer id : createCustomerForm.getUser().getIdAuthorities()) {
			Authority auth = new Authority();
			auth.setAuthorityName(map.get(id));
			auth.setUser(createCustomerForm.getUser());
			authorities.add(auth);
		}

		createCustomerForm.getUser().setAuthorities(authorities);

		log.info("createCustomerForm: {}", createCustomerForm);
		log.info("authorities: {}", createCustomerForm.getUser().getAuthorities());

		customerService.create(createCustomerForm);

		model.addAttribute("currentSecc", "manageCustomers");

		return "redirect:/admin/manage/customers";
	}

	@RequestMapping(value = "/edit/{customerId}", method = RequestMethod.GET)
	public String showEditCustomerPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin, @PathVariable Long customerId) {

		Customer customer = customerService.getByCustomerId(customerId);

		if (customer == null)
			return "rediect:/admin/manage/customers";

		List<Integer> idAuthorities = new ArrayList<>();
		for (Authority auth : customer.getUser().getAuthorities()) {
			idAuthorities.add(IMapUtils.getKeyByValue(map, auth.getAuthorityName()));
		}
		customer.getUser().setIdAuthorities(idAuthorities);

		model.addAttribute("editCustomerForm", customer);

		model.addAttribute("currentSecc", "manageCustomers");

		return "admin/manage/customers/edit";
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
	public String editCustomer(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin,
			@Validated @ModelAttribute("editCustomerForm") Customer editCustomerForm, BindingResult result) {

		if (result.hasErrors()) {

			model.addAttribute("currentSecc", "manageCustomers");

			return "admin/manage/customers/edit";
		}

		Customer customer = customerService.getByCustomerId(editCustomerForm.getId());

		customer.setName(editCustomerForm.getName());
		customer.setLastName(editCustomerForm.getLastName());
		customer.getUser().setPassword(editCustomerForm.getUser().getPassword());

		customer.getUser().getAuthorities().clear();

		for (Integer id : editCustomerForm.getUser().getIdAuthorities()) {
			Authority auth = new Authority();
			auth.setAuthorityName(map.get(id));
			auth.setUser(customer.getUser());
			customer.getUser().getAuthorities().add(auth);
		}

		log.info("editCustomerForm: {}", editCustomerForm);
		log.info("authorities: {}", editCustomerForm.getUser().getAuthorities());

		log.info("customer: {}", customer);
		log.info("authorities: {}", customer.getUser().getAuthorities());

		customerService.update(customer);

		model.addAttribute("currentSecc", "manageCustomers");

		return "redirect:/admin/manage/customers";
	}

	@RequestMapping(value = "/delete/{customerId}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteAccount(HttpSession session, Model model,
			@ModelAttribute("logableUser") Admin admin, @PathVariable Long customerId) {

		log.info("delete customer id: {}", customerId);

		// customerService.delete(Customer.builder().id(customerId).build());

		model.addAttribute("currentSecc", "manageCustomers");

		// throw new RuntimeException("Error trying delete customer id: " +
		// customerId);

		Map<String, Object> map = new HashMap<>();
		map.put("message", "Customer id: " + customerId + " deleted.");
		map.put("status", true);

		return map;
	}
}
