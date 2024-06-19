package com.marketing.service;

import java.util.List;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;

public interface LeadService {
public void saveLead(Lead lead );

public List<Lead> getAllleads();

public void findAllLead(long id);

public Lead findLead(long id);

public void updateLeadinfo(LeadDto leaddto);
}
