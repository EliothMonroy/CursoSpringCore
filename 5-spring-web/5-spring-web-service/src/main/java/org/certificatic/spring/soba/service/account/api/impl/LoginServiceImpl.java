package org.certificatic.spring.soba.service.account.api.impl;

import org.certificatic.spring.soba.dao.api.IAdminDAO;
import org.certificatic.spring.soba.dao.api.ICustomerDAO;
import org.certificatic.spring.soba.dao.api.IUserDAO;
import org.certificatic.spring.soba.domain.Admin;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.domain.ILogableUser;
import org.certificatic.spring.soba.service.account.api.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IAdminDAO adminDAO;

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public ILogableUser checkLoginUser(String username, String password) {
		Customer customer = null;
		Admin admin = null;
		boolean isCustomer = false;
		boolean isAdmin = false;
		boolean isLoginOk = false;

		customer = this.customerDAO.getCustomerByUsername(username);
		if (customer != null) {
			isCustomer = true;

			if (customer.getUser().getPassword().equals(password))
				isLoginOk = true;

		} else {
			admin = this.adminDAO.getAdminByUsername(username);

			if (admin != null) {
				isAdmin = true;

				if (admin.getUser().getPassword().equals(password))
					isLoginOk = true;
			}
		}

		if (isCustomer && isLoginOk)
			return customer;

		else if (isAdmin && isLoginOk)
			return admin;

		return null;
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean usernameExists(String username) {
		return this.userDAO.findByUsername(username) != null ? true : false;
	}

	/*@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Account getByAccountId(@NonNull Long id) {
		return this.accountDAO.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<Account> getByCustomerId(@NonNull Long id) {
		return this.accountDAO.findByCustomerId(id);
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public String transfer(@NonNull Account origin, @NonNull Account destination, @NonNull BigDecimal amount,
			@NonNull String description) {
	
		if (origin.getBalance().compareTo(amount) < 0)
			throw new RuntimeException("Origin Account doesn't have enough balance to do this operation");
	
		origin.setBalance(origin.getBalance().subtract(amount));
	
		destination.setBalance(destination.getBalance().add(amount));
	
		accountDAO.update(destination);
	
		accountDAO.update(origin);
	
		return "refNumber";
	}*/

}
