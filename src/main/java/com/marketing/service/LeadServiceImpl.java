package com.marketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadrepo;
	@Override
	public void saveLead(Lead lead) {
		leadrepo.save(lead);
	}
	@Override
	public List<Lead> getAllleads() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}
	@Override
	public void findAllLead(long id) {
		leadrepo.deleteById(id);
		
	}
	@Override
	public Lead findLead(long id) {
		Lead leads = leadrepo.findById(id).get();
		return leads;
	}
	@Override
	public void updateLeadinfo(LeadDto leaddto) {
		Lead lead   = new Lead();
		lead.setId(leaddto.getId());
		lead.setFirstName(leaddto.getFirstName());
		lead.setLastName(leaddto.getLastName());
		lead.setEmail(leaddto.getEmail());
		lead.setMobile(leaddto.getMobile());
		leadrepo.save(lead);
	}
}
