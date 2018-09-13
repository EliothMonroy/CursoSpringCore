package org.certificatic.spring.soba.mvc.validator;

import org.certificatic.spring.soba.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EditCustomerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;

		if (customer.getName().trim().isEmpty()) {
			errors.rejectValue("name", "", "Name cannot be empty.");
		}

		if (customer.getLastName().trim().isEmpty()) {
			errors.rejectValue("lastName", "", "Last Name cannot be empty.");
		}

		if (customer.getUser().getPassword().trim().isEmpty()) {
			errors.rejectValue("user.password", "", "Password cannot be empty.");
		}

		if (customer.getUser().getIdAuthorities() == null || customer.getUser().getIdAuthorities().isEmpty()) {
			errors.rejectValue("user.idAuthorities", "", "Select at least one authority.");
		}

	}

}
