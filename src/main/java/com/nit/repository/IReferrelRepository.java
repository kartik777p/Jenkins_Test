package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.model.Referral;


public interface IReferrelRepository extends JpaRepository<Referral,Integer> {

	// Finder method to find Referral by referralCode
    Referral findByReferralCode(String referralCode);
    
    @Query("SELECT COUNT(c) FROM Candidate c WHERE c.referredBy = :referral")
    Long countCandidatesByReferral(Referral referral);
}
