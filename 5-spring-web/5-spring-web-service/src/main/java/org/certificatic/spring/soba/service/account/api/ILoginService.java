package org.certificatic.spring.soba.service.account.api;

import org.certificatic.spring.soba.domain.ILogableUser;

public interface ILoginService {

	ILogableUser checkLoginUser(String username, String password);

	boolean usernameExists(String username);

}
