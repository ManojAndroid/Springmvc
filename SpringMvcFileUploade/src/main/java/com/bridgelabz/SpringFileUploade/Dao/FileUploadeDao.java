package com.bridgelabz.SpringFileUploade.Dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.bridgelabz.SpringFileUploade.Model.FileUploadeModel;

@Repository
@Component
public class FileUploadeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(FileUploadeModel fileUploadeModel) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(fileUploadeModel);
		transaction.commit();
		session.close();

	}

	public List<FileUploadeModel> display() {
		Session session = sessionFactory.openSession();
		List<FileUploadeModel> documents = null;
		try {
			documents = (List<FileUploadeModel>) session.createQuery("from FileUploadeModel").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return documents;
	}
	
	public FileUploadeModel getImage(int id) {
		
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FileUploadeModel> criteria = builder.createQuery(FileUploadeModel.class);
		

		Root<FileUploadeModel> c = criteria.from(FileUploadeModel.class);
		ParameterExpression<Integer> p = builder.parameter(Integer.class);
		criteria.select(c).where(builder.equal(c.get("id"), p));
		TypedQuery<FileUploadeModel> query = session.createQuery(criteria);
		query.setParameter(p, id);
		List<FileUploadeModel> imageFiles = query.getResultList();
		
		if (imageFiles != null && imageFiles.size() > 0) {
			return imageFiles.get(0);
		} else {
			return null;
		}
	}

}
