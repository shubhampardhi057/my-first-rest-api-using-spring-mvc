package com.prowings.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.dao.StudentDaoImpl;
import com.prowings.entity.Student;

@Service
public class StudentServiceEmpl implements StudentService {
	
	public static final Logger logger = LoggerFactory.getLogger(StudentServiceEmpl.class);
	
	
	
	@Autowired
	StudentDao studentDao;

	@Override
	public boolean saveStudent(Student std) {
		
		return studentDao.saveStudent(std);
	}

	@Override
	public Student getStudent(int id) {
		
		
		logger.info("Request recieved in Service ...!!!");
		
		
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		
		return studentDao.getStudents();
	}

	@Override
	public boolean deleteStudent(int id) {
		
		return studentDao.deleteStudent(id);
	}

	@Override
	public boolean updateStudent(Student std) {
		return studentDao.updateStudent(std);
	}
	
	

	
}
