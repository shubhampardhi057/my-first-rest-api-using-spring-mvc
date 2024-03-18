package com.prowings.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	public static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveStudent(Student std) {
		
		boolean result = false;
		
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			session.save(std);
			txn.commit();
			session.close();
			result = true;
			
			return result;
		}
		catch (Exception e) 
		{
//			System.out.println("Error occured :"+e.getMessage());
			
			logger.error("Error occured :", e.getMessage());
			
		}
		
		return result; 
	}

	@Override
	public Student getStudent(int id) {
		
		
		logger.info("Request received in Dao ...!!!");
		
		Student std = null;
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		std = session.get(Student.class,id);
		txn.commit();
		session.close();
		
		return std;
		
		
	}

	@Override
	public List<Student> getStudents() {
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		Query<Student> query = session.createQuery("from Student");
		List<Student> stdList = query.list();
		txn.commit();
		session.close();
	
		
		return stdList;
	}

	@Override
	public boolean deleteStudent(int id) {
		
		boolean result = false;
		Student retrievedStd = null;
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		txn=session.beginTransaction();
		try {
		
//		Query<Student>  query = session.createQuery("delete Student where id = "+id);
//		query.executeUpdate();
		
		retrievedStd =  session.get(Student.class, id);
		logger.info("Retrieved Student : {}",retrievedStd);
		
			session.delete(retrievedStd);
			result = true;
		
		
		txn.commit();		
		}
		catch (Exception e) {
//			System.out.println("Error occured :"+e.getMessage());
			
			logger.error("Error occured :", e.getMessage());
		}
		return result;
	}

	@Override
	public boolean updateStudent(Student std) {
		boolean result = false;
		
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			
			session.update(std);
			
			txn.commit();
			session.close();
			
			result = true;
			
			return result;
		}
		catch (Exception e) {
//			System.out.println("Error occured :"+e.getMessage());
			
			logger.error("Error occured :", e.getMessage());
		}
		
		return result;
	
	}
}
