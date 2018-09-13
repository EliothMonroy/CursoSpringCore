package org.certificatic.spring.soba.mvc.controller.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.domain.Movement;
import org.certificatic.spring.soba.domain.vo.CustomDate;
import org.certificatic.spring.soba.mvc.validator.CreateAccountFormValidator;
import org.certificatic.spring.soba.service.account.api.IAccountService;
import org.certificatic.spring.soba.service.account.api.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
@RequestMapping(value = "/customer/manage/accounts")
public class AccountManagementCustomerController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IMovementService movementService;

	@Autowired
	private CreateAccountFormValidator createAccountFormValidator;

	@InitBinder(value = "createAccountForm")
	protected void initBinderCreateAccountForm(WebDataBinder binder) {
		binder.setValidator(createAccountFormValidator);
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showManagementAccountsPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer) {

		log.info("logable user: {}", customer);

		List<Account> accounts = accountService.getByCustomerId(customer.getId());

		model.addAttribute("accounts", accounts);

		model.addAttribute("currentSecc", "manageAccounts");

		return "customer/manage/accounts";
	}

	@RequestMapping(value = "/view/{accountId}", method = RequestMethod.GET)
	public String showViewAccountPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer, @PathVariable Long accountId) {

		List<Account> accounts = accountService.getByCustomerId(customer.getId());

		Optional<Account> optionalAccount = accounts.stream().filter((a) -> a.getId().equals(accountId))
				.findAny();

		if (!optionalAccount.isPresent())
			return "rediect:/customer/manage/accounts";

		List<Movement> movements = movementService.getByAccountId(accountId);

		model.addAttribute("account", optionalAccount.get());
		model.addAttribute("movements", movements);

		model.addAttribute("currentSecc", "manageAccounts");

		return "customer/manage/accounts/view";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateAccountPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer) {

		model.addAttribute("createAccountForm", new Account());

		model.addAttribute("currentSecc", "manageAccounts");

		return "customer/manage/accounts/create";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer,
			@Validated @ModelAttribute("createAccountForm") Account createAccountForm, BindingResult result) {

		model.addAttribute("currentSecc", "manageAccounts");

		if (result.hasErrors()) {
			return "customer/manage/accounts/create";
		}

		createAccountForm.setCustomer(customer);
		createAccountForm.setCreatedDate(new CustomDate());

		log.info("createAccountForm: {}", createAccountForm);

		try {
			accountService.create(createAccountForm);
		} catch (DataAccessException dae) {
			model.addAttribute("serviceError", dae.getRootCause().getLocalizedMessage());

			return "customer/manage/accounts/create";
		}

		model.addAttribute("currentSecc", "manageAccounts");

		return "redirect:/customer/manage/accounts";
	}

	@RequestMapping(value = "/transfer/{accountId}", method = RequestMethod.GET)
	public String showViewTransferAccountPage(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer, @PathVariable Integer accountId) {

		List<Account> accounts = accountService.getByCustomerId(customer.getId());

		Optional<Account> optionalAccount = accounts.stream().filter((a) -> a.getId().equals(new Long(accountId)))
				.findAny();

		if (!optionalAccount.isPresent())
			return "rediect:/customer/manage/accounts";

		model.addAttribute("account", optionalAccount.get());

		model.addAttribute("currentSecc", "manageAccounts");

		return "customer/manage/accounts/transfer";
	}

	@RequestMapping(value = "/delete/{accountId}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteAccount(HttpSession session, Model model,
			@ModelAttribute("logableUser") Customer customer, @PathVariable Long accountId) {

		log.info("delete account id: {}", accountId);

		// accountService.delete(Account.builder().id(accountId).build());

		model.addAttribute("currentSecc", "manageAccounts");

		// throw new RuntimeException("Error trying delete account id: " +
		// accountId);

		Map<String, Object> map = new HashMap<>();
		map.put("message", "Account id: " + accountId + " deleted.");
		map.put("status", true);

		return map;
	}
}
