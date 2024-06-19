package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;

//Spring MVC ,Spring web 
@Controller
public class LeadController {

	@Autowired
	private LeadService leadservice;

	@Autowired
	private EmailService emailService;

//Handler Method
	// http://localhost:8080/view
	@RequestMapping("/view")
	public String viewCreateLeadForm() {
		return "create_lead";
		// RequstDispatcher
	}
    
	// public void saveLead(@ModelAttribute(Lead lead))
	// @ModelAttribute:- This annotation Bind form data with Entity Class if we not
	// include it include by default automatically in back end
	@RequestMapping("/saveLead")
	public String saveLead(LeadDto leaddto, Model model) {
		Lead lead = new Lead();
		lead.setFirstName(leaddto.getFirstName());
		lead.setLastName(leaddto.getLastName());
		lead.setEmail(leaddto.getEmail());
		lead.setMobile(leaddto.getMobile());
		model.addAttribute("msg", "Lead is Saved!!");
		model.addAttribute("msg1", "Email is Sent Successfully");
		leadservice.saveLead(lead);
		emailService.sendEmail(leaddto.getEmail(), "Test", "Test Email Sending");
		return "create_lead";
	}
	
	@RequestMapping("/listsAll")
	public String listallLeads(Model model) {
		List<Lead> leads = leadservice.getAllleads();
		model.addAttribute("leads", leads);
		return "lisrtAll_lead";
	}

	@RequestMapping("/delete")
	public String deleteLeads(@RequestParam("id") long id, ModelMap model) {
		leadservice.findAllLead(id);
		List<Lead> leads = leadservice.getAllleads();
		model.addAttribute("leads", leads);
		return "lisrtAll_lead";
	}

	@RequestMapping("/update")
	public String updateLeads(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservice.findLead(id);
		model.addAttribute("leads", lead);
		return "update_lead";
	}

	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadDto leaddto, Model model) {
		leadservice.updateLeadinfo(leaddto);
		List<Lead> leads = leadservice.getAllleads();
		model.addAttribute("leads", leads);
		return "lisrtAll_lead";
	}

}
