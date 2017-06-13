package com.bridgelabz.SpringFileUploade.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.SpringFileUploade.Model.FileUploadeModel;

@Repository
@Component
public class FileUploadeDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*@Transactional
	public void save(FileUploadeModel fileUploadeModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fileUploadeModel);
	}*/
	public void save(FileUploadeModel fileUploadeModel) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(fileUploadeModel);
		transaction.commit();
		session.close();

	}

}
