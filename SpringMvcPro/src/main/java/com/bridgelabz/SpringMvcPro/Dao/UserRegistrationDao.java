package com.bridgelabz.SpringMvcPro.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.SpringMvcPro.Model.UserRegistrationModel;

@Repository
@Component
public class UserRegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(UserRegistrationModel userRegistrationModel) 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userRegistrationModel);
		transaction.commit();
		session.close();

	}
	public void Login(String email,String password) 
	{
		System.out.println( "this is password"+password);
		/*Session session = sessionFactory.openSession();
			List list = session.createQuery("from DemoDto e where e.PASSWORD="+ password).list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				UserRegistrationModel demodto = (UserRegistrationModel) iterator.next();
				System.out.print("id     :" + demodto.getName() + " ");
				System.out.print("brand  :" + demodto.getEmail() + " ");
				System.out.print("price  :" + demodto.getMobilnumber() + " ");
			}
		*/
	}

}
