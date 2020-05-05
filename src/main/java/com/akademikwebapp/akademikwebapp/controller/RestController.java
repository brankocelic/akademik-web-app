package com.akademikwebapp.akademikwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akademikwebapp.akademikwebapp.entity.Jelo;
import com.akademikwebapp.akademikwebapp.service.ServiceDAO;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
//	@Autowired
//	private ServiceDAO employeeService;
//
//	@GetMapping("/jelovnika")
//	public List<Jelo> findAll() {
//		return employeeService.findAll();
//}
//
//	@PostMapping("/jelovnika")
//	public Jelo addJelo(@RequestBody Jelo jelovnik)
//	{
//		jelovnik.setId(0);
//		
//	employeeService.save(jelovnik);
//		
//		return jelovnik;
//	}
}
