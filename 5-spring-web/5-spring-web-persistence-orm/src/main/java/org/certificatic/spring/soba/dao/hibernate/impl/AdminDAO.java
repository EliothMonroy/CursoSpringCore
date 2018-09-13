package org.certificatic.spring.soba.dao.hibernate.impl;

import org.certificatic.spring.soba.dao.api.IAdminDAO;
import org.certificatic.spring.soba.domain.Admin;
import org.springframework.stereotype.Repository;;

@Repository
public class AdminDAO extends GenericEntityDAO<Admin, Long> implements IAdminDAO {

	public AdminDAO() {
		super(Admin.class);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		return (Admin) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE user.username = '" + username + "'")
				.uniqueResult();
	}

}
