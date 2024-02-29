package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Electricity;
import com.web.service.ElectricityService;

@RestController
public class ElectricityController {
	@Autowired
	private ElectricityService service;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Electricity e) {
	
	Electricity e1 =service.saveRecord(e);
	String message =null;
	if(e1!=null)
	{
		message="Data Inserted successfully";
	}
	else {
		message="Data Failed";
	}
	return message;
	}
	
	
	@GetMapping("/get/{cid}")
	public Electricity getOne(@PathVariable int cid)
	{
		Electricity get=service.getOneRecord(cid);
		return 	get;
	}
	
	@GetMapping("/getAll")
	public List<Electricity> getAll()
	{
		List<Electricity> getAll=service.getAllRecord();
		return getAll;
	}
	

	
	
	
	@DeleteMapping("/delete/{cid}")
	public void delete(@PathVariable int cid)
	{
		service.deleteRecord(cid);
	}
	
	
	@PutMapping("/update/{cid}")
	public Electricity update(@RequestBody Electricity e,@PathVariable int cid)
	{
		Electricity update=service.updateRecord(e, cid);
		return update;
	}
	
	
	
}
