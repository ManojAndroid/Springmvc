package com.bridgelabz.SpringMvcPro.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.SpringMvcPro.Model.UserRegistrationModel;

/*@Repository*/
@Component
public class UserRegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(UserRegistrationModel userRegistrationModel) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userRegistrationModel);
		transaction.commit();
		session.close();

	}

	public boolean Login(String email, String fpassword) {
		System.out.println("this is password" + fpassword);
		Session session = sessionFactory.openSession();

		String sql = " from UserRegistrationModel u where u.Password=:pass and u.email=:email";
		Query query = session.createQuery(sql);
		query.setParameter("email", email);
		query.setParameter("pass", fpassword);
		List<UserRegistrationModel> list = query.list();
		/*
		 * for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		 * UserRegistrationModel demodto = (UserRegistrationModel)
		 * iterator.next();
		 * 
		 * System.out.print("id     :" + demodto.getMobilnumber()); }
		 */
		if (list.size() > 0) {
			session.close();
			return true;

		}
		session.close();
		return false;

	}

}
