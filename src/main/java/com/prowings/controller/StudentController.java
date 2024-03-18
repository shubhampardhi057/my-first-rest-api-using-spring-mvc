package com.prowings.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.service.StudentService;

@RestController
public class StudentController {
	
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);// slf4j
	
	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public String createStudent(@RequestBody Student std)
	{
//		System.out.println("request received to create student  : " + std);
		
		logger.info("Request received to create student : {} Object ",std);
		
		
		if(studentService.saveStudent(std))
			return "Student saved successfully!!!";
		else
			return "Student not saved!!!";
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id)
	{
//		System.out.println("request recievied to get Student of id :"+id);
		
		MDC.put("StudentId",String.valueOf(id));
//		MDC.get("StudentId");
		
		logger.info("Request received to get student id : {}  ",id);
		
		Student retrievedStudent = studentService.getStudent(id);
		
		return retrievedStudent;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> stdList = studentService.getStudents();
		
		return stdList;
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
//		System.out.println("request received to delete student of id : " + id);
		
		logger.info("Request received to delete student id : {}  ",id);
		
		if(studentService.deleteStudent(id))
			return "Student Deleted successfully!!!";
		else
			return "Student Not Deleted successfully!!!";
	}
	
	
	@PatchMapping("/students")
	public String  updateStudent(@RequestBody Student std)
	{
		
		if(studentService.updateStudent(std))
			return "Student Updated Successfully!!!";
		else
			return "Student Not Updated Successfully!!!";
			
		
	}
}
