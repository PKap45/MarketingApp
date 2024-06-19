package com.marketing.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@RestController
@RequestMapping("/api")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadrepo;

	@GetMapping
	public List<Lead> getAllLeads()
	{
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveLeads(@RequestBody Lead leads)
	{
		leadrepo.save(leads);
	}
	
	@PutMapping
	public void updateLeads(@RequestBody Lead leads)
	{
		leadrepo.save(leads);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLeads(@PathVariable("id") long id)
	{
		leadrepo.deleteById(id);
	}
}
