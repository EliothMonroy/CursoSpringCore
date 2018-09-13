package org.certificatic.spring.soba.dao.api;

import org.certificatic.spring.soba.domain.Admin;

public interface IAdminDAO extends IGenericDAO<Admin, Long> {
	Admin getAdminByUsername(String username);
}
