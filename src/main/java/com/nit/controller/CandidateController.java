package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Candidate;
import com.nit.model.Referral;
import com.nit.repository.IReferrelRepository;
import com.nit.service.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    
    @Autowired
    private IReferrelRepository repo;

    @PostMapping("/register/{referralCode}")
    public Candidate registerCandidate(@PathVariable(required = false) String referralCode , @RequestBody Candidate candidate) {
        return candidateService.registerCandidate(referralCode, candidate);
    }

    
    @GetMapping("List/{refferedBy}")
    public Long getCount(@PathVariable String refferedBy) {
    	Referral byReferralCode = repo.findByReferralCode(refferedBy);
    	return repo.countCandidatesByReferral(byReferralCode);
    }
}
