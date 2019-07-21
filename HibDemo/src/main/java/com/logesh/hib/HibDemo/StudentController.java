package com.logesh.hib.HibDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping("students")
	public void getAllStudents() {
		System.out.println("here at stu con");
		 service.findAll();
	}
}
