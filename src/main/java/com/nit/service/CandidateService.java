package com.nit.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Candidate;
import com.nit.model.Referral;
import com.nit.repository.ICandidateRepository;
import com.nit.repository.IReferrelRepository;
import com.nit.utils.RandomIdGenerator;
import com.nit.utils.ReferralCodeGenerator;

@Service
public class CandidateService {
    @Autowired
    private ICandidateRepository candidateRepository;

    @Autowired
    private IReferrelRepository referralRepository;

    public Candidate registerCandidate(String referredBy, Candidate candidate) {
        // Generate referral code
    	//String userId=candidate.getId().toString();
    	String userId=RandomIdGenerator.generateRandomId();
    	System.out.println("-------- "+userId);
        String referralCode = ReferralCodeGenerator.generateReferralCode(candidate.getFirstName(),userId);
        candidate.setReferralCode(referralCode);
        Referral byReferralCode = referralRepository.findByReferralCode(referredBy);
        System.out.println("CandidateService.registerCandidate()");
        candidate.setReferredBy(byReferralCode);
        // Create candidate
        Candidate savedCandidate = candidateRepository.save(candidate);

        // Create referral
        Referral referral = new Referral();
        referral.setReferralCode(referralCode);
       referral.setCandidates(Set.of(savedCandidate));

        // Save referral
        referralRepository.save(referral);

        return savedCandidate;
    }

    private String generateReferralCode() {
        // Logic to generate a unique referral code
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
